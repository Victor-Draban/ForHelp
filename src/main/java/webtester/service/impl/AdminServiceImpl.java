package webtester.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webtester.exception.WebtesterApplicationException;
import webtester.model.Account;
import webtester.repository.AccountRepository;
import webtester.repository.impl.ConnectionUtils;
import webtester.service.AdminService;

class AdminServiceImpl implements AdminService {
	
	private final AccountRepository accountRepository;
	private final DataSource dateSource;
	
	AdminServiceImpl(AccountRepository accountRepository,
			DataSource dateSource) {
		super();
		this.accountRepository = accountRepository;
		this.dateSource = dateSource;
	}

	@Override
	public List<Account> findAll() {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			return accountRepository.findAll();
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}
	
	@Override
	public void insertAccount(Account account, List<Integer> role) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			accountRepository.insertAccountWithRole(account, role);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void updateAccount(Account account, List<Integer> role) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			accountRepository.updateAccountWithRole(account, role);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void deleteAccount(long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			accountRepository.deleteAccount(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

}
