package webtester.repository;

import java.util.List;

import webtester.model.AccountRole;

public interface AccountRoleRepository {

	List<AccountRole> findRoles();
	
	List<AccountRole> findRoleById(long id);
	
}
