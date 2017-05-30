package webtester.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webtester.exception.WebtesterApplicationException;
import webtester.model.Answer;
import webtester.model.Question;
import webtester.model.Test;
import webtester.repository.AnswerRepository;
import webtester.repository.QuestionRepository;
import webtester.repository.TestRepository;
import webtester.repository.impl.ConnectionUtils;
import webtester.service.TutorService;

public class TutorServiceImpl implements TutorService {

	private final DataSource dateSource;
	private final TestRepository testRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	
	public TutorServiceImpl(TestRepository testRepository, QuestionRepository questionRepository,
			AnswerRepository answerRepository, DataSource dateSource) {
		super();
		this.dateSource = dateSource;
		this.testRepository = testRepository;
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
	}
	
	@Override
	public List<Test> selectAllTest() {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			return testRepository.findAll();
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public List<Test> selectAllTestById(Long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			return testRepository.findAllById(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public Test selectTestById(Long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			Test test = testRepository.selectTestById(id);
			return test;
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void insertTest(Test test) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			testRepository.insertTest(test);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void updateTest(Test test) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			testRepository.updateTest(test);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void deleteTest(long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			testRepository.deleteTest(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public List<Answer> selectAnswerByIdQuestion(Long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			return (List<Answer>) answerRepository.selectAnswernByIdQuestion(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public Answer selectAnswerById(Long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			Answer answer = answerRepository.selectAnswerById(id);
			return answer;
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void insertAnswer(Answer answer) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			answerRepository.insertAnswer(answer);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void updateAnswer(Answer answer) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			answerRepository.updateAnswer(answer);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void deleteAnswer(long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			answerRepository.deleteAnswer(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public List<Question> selectQuestionByIdTest(Long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			return (List<Question>) questionRepository.selectQuestionByIdTest(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void insertQuestion(Question question) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			questionRepository.insertQuestion(question);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void updateQuestion(Question question) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			questionRepository.updateQuestion(question);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public void deleteQuestion(long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			questionRepository.deleteQuestion(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

}
