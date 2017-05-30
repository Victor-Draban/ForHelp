package webtester.service;

import java.util.List;

import webtester.model.Account;

public interface AdminService {

	List<Account> findAll();
	
	void insertAccount(Account account, List<Integer> role);
	
	void updateAccount(Account account, List<Integer> role);
	
	void deleteAccount(long id);
}
