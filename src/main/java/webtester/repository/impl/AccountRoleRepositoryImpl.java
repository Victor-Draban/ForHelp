package webtester.repository.impl;

import static webtester.repository.impl.ConnectionUtils.getCurrentConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import webtester.exception.WebtesterApplicationException;
import webtester.handler.DefaultResultSetHandler;
import webtester.model.Account;
import webtester.model.AccountRole;
import webtester.repository.AccountRoleRepository;

public class AccountRoleRepositoryImpl implements AccountRoleRepository {

	@Override
	public List<AccountRole> findRoles() {
		Connection c = getCurrentConnection();
		try {
			return (List<AccountRole>) new QueryRunner().query(c, 
					"SELECT ar.id, ar.id_account, ar.id_role, r.name FROM account_role ar JOIN Role r ON ar.id_role = r.id",
					new DefaultResultSetHandler(AccountRole.class, true));
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public List<AccountRole> findRoleById(long id) {
		Connection c = getCurrentConnection();
		try {
			return (List<AccountRole>) new QueryRunner().query(c, 
					"SELECT ar.id, ar.id_account, ar.id_role, r.name FROM account_role ar JOIN Role r ON ar.id_role = r.id where ar.id_account=?",
					new DefaultResultSetHandler(AccountRole.class, true), id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

}
