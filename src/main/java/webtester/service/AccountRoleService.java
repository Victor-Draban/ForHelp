package webtester.service;

import java.util.List;
import webtester.model.AccountRole;

public interface AccountRoleService {

	List<AccountRole> findRole();
	
	List<AccountRole> findRoleById(long id);
	
}
