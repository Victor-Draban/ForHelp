package webtester.repository;

import java.util.List;

import webtester.model.Account;

public interface AccountRepository {

	Account findByLogin(String login);
	
	List<Account> findAll();
	
	Account findById(long id);
	
	Account findByEmail(String email);
	
	void insertAccount(Account account);
	
	void insertAccountWithRole(Account account, List<Integer> role);
	
	void updateAccountWithRole(Account account, List<Integer> role);
	
	void deleteAccount(long id);
}
