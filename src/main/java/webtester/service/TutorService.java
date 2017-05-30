package webtester.service;

import java.util.List;

import webtester.model.Answer;
import webtester.model.Question;
import webtester.model.Test;

public interface TutorService {

	List<Test> selectAllTest();
	
	List<Test> selectAllTestById(Long id);
	
	Test selectTestById(Long id);
	
	void insertTest(Test test);
	
	void updateTest(Test test);
	
	void deleteTest(long id);
	
	
	List<Question> selectQuestionByIdTest(Long id);
	
	void insertQuestion(Question question);
	
	void updateQuestion(Question question);
	
	void deleteQuestion(long id);
	
	
	List<Answer> selectAnswerByIdQuestion(Long id);
	
	Answer selectAnswerById(Long id);
	
	void insertAnswer(Answer answer);
	
	void updateAnswer(Answer answer);
	
	void deleteAnswer(long id);
	
}
