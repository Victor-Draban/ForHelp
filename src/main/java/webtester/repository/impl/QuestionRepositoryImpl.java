package webtester.repository.impl;

import static webtester.repository.impl.ConnectionUtils.getCurrentConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import webtester.exception.WebtesterApplicationException;
import webtester.handler.DefaultResultSetHandler;
import webtester.model.Id;
import webtester.model.Question;
import webtester.model.Test;
import webtester.repository.QuestionRepository;

public class QuestionRepositoryImpl implements QuestionRepository {

	@Override
	public List<Question> selectQuestionByIdTest(Long id) {
		Connection c = getCurrentConnection();
		try {
			return (List<Question>) new QueryRunner().query(c, 
					"SELECT id, id_test, name FROM question where id_test = ?",
					new DefaultResultSetHandler(Question.class, true), id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void insertQuestion(Question question) {
		Connection c = getCurrentConnection();
		Long idTest = question.getIdTest();
		String name = question.getName();
		try {
			Id id = (Id)new QueryRunner().insert(c, "INSERT INTO question(id_test, name) VALUES(?,?)",
					new DefaultResultSetHandler(Id.class, false), idTest, name);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void updateQuestion(Question question) {
		Connection c = getCurrentConnection();
		long id = question.getId();
		String name = question.getName();
		try {
			new QueryRunner().update(c, 
					"UPDATE question SET name=? WHERE id=?",
					 name, id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void deleteQuestion(long id) {
		Connection c = getCurrentConnection();
		try {
			new QueryRunner().update(c, "DELETE FROM question WHERE id=?", id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

}
