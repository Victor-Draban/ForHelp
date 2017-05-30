package webtester.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import webtester.exception.WebtesterApplicationException;
import webtester.handler.DefaultResultSetHandler;
import webtester.model.Account;
import webtester.model.AccountInsert;
import webtester.model.Id;
import webtester.repository.AccountRepository;
import static webtester.repository.impl.ConnectionUtils.getCurrentConnection;

public class AccountRepositoryImpl implements AccountRepository {

	public Account findByLogin(String login) {
		Connection c = getCurrentConnection();
		try {
			return (Account) new QueryRunner().query(c, "select * from account where login=?",
					new DefaultResultSetHandler(Account.class, false), login);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}
	
	@Override
	public Account findByEmail(String email) {
		Connection c = getCurrentConnection();
		try {
			return (Account) new QueryRunner().query(c, "select * from account where email=?",
					new DefaultResultSetHandler(Account.class, false), email);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public List<Account> findAll() {
		Connection c = getCurrentConnection();
		try {
			return (List<Account>) new QueryRunner().query(c, "select * from account",
					new DefaultResultSetHandler(Account.class, true));
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public Account findById(long id) {
		Connection c = getCurrentConnection();
		try {
			return (Account) new QueryRunner().query(c, "select * from account where id=?",
					new DefaultResultSetHandler(Account.class, false), id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void insertAccount(Account account) {
		Connection c = getCurrentConnection();
		try {
			new QueryRunner().insert(c, "INSERT INTO account(login, password, first_name, last_name, second_name, email) VALUES(?,?,?,?,?,?)",
					new DefaultResultSetHandler(Id.class, false), account.getLogin(), account.getPassword(), account.getFirstName(),
					account.getLastName(), account.getSecondName(), account.getEmail());
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void insertAccountWithRole(Account account, List<Integer> role) {
		Connection c = getCurrentConnection();
		try {
			Id id = (Id)new QueryRunner().insert(c, "INSERT INTO account(login, password, first_name, last_name, second_name, email, active) VALUES(?,?,?,?,?,?,?)",
					new DefaultResultSetHandler(Id.class, false), account.getLogin(), account.getPassword(), account.getFirstName(),
					account.getLastName(), account.getSecondName(), account.getEmail(), account.getActive());
			
			int id_acc = id.getId().intValue();
			if (role.size() > 0) {
				for(Integer integer: role) {
					new QueryRunner().insert(c, "INSERT INTO account_role(id_account, id_role) VALUES (?,?)",
							new DefaultResultSetHandler(Id.class, false), id_acc, integer);
				}
			}
			
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void updateAccountWithRole(Account account, List<Integer> role) {
		Connection c = getCurrentConnection();
		try {
			new QueryRunner().update(c, 
					"UPDATE account SET login=?, password=?, first_name=?, last_name=?, second_name=?, email=?, active=? WHERE id=?",
					account.getLogin(), account.getPassword(), account.getFirstName(),
					account.getLastName(), account.getSecondName(),
					account.getEmail(), account.getActive(), account.getId());
			
			new QueryRunner().update(c, "DELETE FROM account_role WHERE id_account = ?", account.getId());
			
			if (role.size() > 0) {
				for(Integer integer: role) {
					new QueryRunner().insert(c, "INSERT INTO account_role(id_account, id_role) VALUES (?,?)",
							new DefaultResultSetHandler(Id.class, false), account.getId(), integer);
				}
			}
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void deleteAccount(long id) {
		Connection c = getCurrentConnection();
		try {
			new QueryRunner().update(c, "DELETE FROM account WHERE id=?", id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

}
