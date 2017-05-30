package webtester.service.impl;

import static webtester.repository.impl.ConnectionUtils.getCurrentConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webtester.exception.ValidationException;
import webtester.exception.WebtesterApplicationException;
import webtester.handler.DefaultResultSetHandler;
import webtester.model.Account;
import webtester.repository.AccountRepository;
import webtester.repository.impl.ConnectionUtils;
import webtester.service.CommonService;

class CommonServiceImpl implements CommonService {

	private final AccountRepository accountRepository;
	private final DataSource dateSource;
	
	CommonServiceImpl(AccountRepository accountRepository,
			DataSource dateSource) {
		super();
		this.accountRepository = accountRepository;
		this.dateSource = dateSource;
	}

	public Account login(String login, String password, int role)
			throws ValidationException {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			Account account = accountRepository.findByLogin(login);
			if (account == null) {
				throw new ValidationException("Account not found by login");
			} 
			if (!account.getPassword().equals(password)) {
				throw new ValidationException("Password is not valid");
			}
			if (account.getActive() == false) {
				throw new ValidationException("Account not active");
			}
			return account;
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}
	
	public Account findById(Long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			Account account = accountRepository.findById(id);
			return account;
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void insertAccount(Account account) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			accountRepository.insertAccount(account);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public Account findByEmail(String email) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			Account account = accountRepository.findByEmail(email);
			return account;
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public Account findByLogin(String login) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			Account account = accountRepository.findByLogin(login);
			return account;
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

//	@Override
//	public void insertAccount(Account account, List<Integer> role) {
//		try(Connection c = dateSource.getConnection()) {
//			ConnectionUtils.setCurrentConnection(c);
//			accountRepository.insertAccount(account, role);
//		} catch (SQLException e) {
//			throw new WebtesterApplicationException(e);
//		} finally {
//			ConnectionUtils.removeCurrentConnection();
//		}
//	}
//
//	@Override
//	public void updateAccount(Account account, List<Integer> role) {
//		try(Connection c = dateSource.getConnection()) {
//			ConnectionUtils.setCurrentConnection(c);
//			accountRepository.updateAccount(account, role);
//		} catch (SQLException e) {
//			throw new WebtesterApplicationException(e);
//		} finally {
//			ConnectionUtils.removeCurrentConnection();
//		}
//	}
//
//	@Override
//	public void deleteAccount(long id) {
//		try(Connection c = dateSource.getConnection()) {
//			ConnectionUtils.setCurrentConnection(c);
//			accountRepository.deleteAccount(id);
//		} catch (SQLException e) {
//			throw new WebtesterApplicationException(e);
//		} finally {
//			ConnectionUtils.removeCurrentConnection();
//		}
//	}
}
