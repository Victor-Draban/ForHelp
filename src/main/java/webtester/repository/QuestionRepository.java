package webtester.repository;

import java.util.List;

import webtester.model.Answer;
import webtester.model.Question;
import webtester.model.Test;

public interface QuestionRepository {

	public List<Question> selectQuestionByIdTest(Long id);
	
	void insertQuestion(Question question);
	
	void updateQuestion(Question question);
	
	void deleteQuestion(long id);
}
