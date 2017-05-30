package webtester.service;

import java.util.List;

import webtester.exception.ValidationException;
import webtester.model.Account;

public interface CommonService {

	Account login(String login, String password, int role) throws ValidationException;
	
	Account findById(Long i);
	
	Account findByLogin(String login);
	
	Account findByEmail(String email);
	
	void insertAccount(Account account);
	
}
