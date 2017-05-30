package webtester.service;

import java.util.List;
import webtester.model.Result;

public interface StudentService {

	void insertResult(Result result);
	
	List<Result> findAllById(Long id);
}
