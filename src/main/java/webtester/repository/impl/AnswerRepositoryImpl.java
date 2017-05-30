package webtester.repository.impl;

import static webtester.repository.impl.ConnectionUtils.getCurrentConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import webtester.exception.WebtesterApplicationException;
import webtester.handler.DefaultResultSetHandler;
import webtester.model.Answer;
import webtester.model.Id;
import webtester.model.Question;
import webtester.model.Test;
import webtester.repository.AnswerRepository;

public class AnswerRepositoryImpl implements AnswerRepository {

	@Override
	public List<Answer> selectAnswernByIdQuestion(Long id) {
		Connection c = getCurrentConnection();
		try {
			return (List<Answer>) new QueryRunner().query(c, 
					"SELECT id, id_question, name, correct FROM answer where id_question = ?",
					new DefaultResultSetHandler(Answer.class, true), id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public Answer selectAnswerById(Long id) {
		Connection c = getCurrentConnection();
		try{
			return (Answer) new QueryRunner().query(c,
					"SELECT id, id_question, name, correct FROM answer where id = ?",
					new DefaultResultSetHandler(Answer.class, false), id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void insertAnswer(Answer answer) {
		Connection c = getCurrentConnection();
		Long idQuestion = answer.getIdQuestion();
		String name = answer.getName();
		boolean correct = answer.getCorrect();
		try {
			Id id = (Id)new QueryRunner().insert(c, "INSERT INTO answer(id_question, name, correct) VALUES(?,?,?)",
					new DefaultResultSetHandler(Id.class, false), idQuestion, name, correct);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void updateAnswer(Answer answer) {
		Connection c = getCurrentConnection();
		long id = answer.getId();
		String name = answer.getName();
		boolean correct = answer.getCorrect();
		try {
			new QueryRunner().update(c, 
					"UPDATE answer SET name=?, correct=? WHERE id=?",
					 name, correct, id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void deleteAnswer(long id) {
		Connection c = getCurrentConnection();
		try {
			new QueryRunner().update(c, "DELETE FROM answer WHERE id=?", id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

}
