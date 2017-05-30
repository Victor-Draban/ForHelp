package webtester.repository;

import java.util.List;

import webtester.model.Account;
import webtester.model.Test;

public interface TestRepository {

	List<Test> findAll();
	
	List<Test> findAllById(Long id);
	
	Test selectTestById(Long id);
	
	void insertTest(Test test);
	
	void updateTest(Test test);
	
	void deleteTest(long id);
}
