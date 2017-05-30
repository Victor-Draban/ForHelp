package webtester.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webtester.exception.WebtesterApplicationException;
import webtester.model.Account;
import webtester.model.AccountRole;
import webtester.repository.AccountRoleRepository;
import webtester.repository.impl.ConnectionUtils;
import webtester.service.AccountRoleService;

public class AccountRoleServiceImpl implements AccountRoleService {

	private final AccountRoleRepository accountRoleRepository;
	private final DataSource dateSource;
	
	AccountRoleServiceImpl(AccountRoleRepository accountRoleRepository,
			DataSource dateSource) {
		super();
		this.accountRoleRepository = accountRoleRepository;
		this.dateSource = dateSource;
	}
	
	@Override
	public List<AccountRole> findRole() {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			return accountRoleRepository.findRoles();
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public List<AccountRole> findRoleById(long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			return accountRoleRepository.findRoleById(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

}
