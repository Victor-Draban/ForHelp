package webtester.repository;

import java.util.List;

import webtester.model.Answer;
import webtester.model.Question;
import webtester.model.Test;

public interface AnswerRepository {

	public List<Answer> selectAnswernByIdQuestion(Long id);
	
	public Answer selectAnswerById(Long id);
	
	void insertAnswer(Answer answer);
	
	void updateAnswer(Answer answer);
	
	void deleteAnswer(long id);
}
