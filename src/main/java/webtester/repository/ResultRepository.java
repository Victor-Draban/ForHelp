package webtester.repository;

import java.util.List;

import webtester.model.Result;

public interface ResultRepository {

	void insertTest(Result result);
	
	List<Result> findAllById(Long id);
}
