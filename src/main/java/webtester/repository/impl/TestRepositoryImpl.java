package webtester.repository.impl;

import static webtester.repository.impl.ConnectionUtils.getCurrentConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import webtester.exception.WebtesterApplicationException;
import webtester.handler.DefaultResultSetHandler;
import webtester.model.Account;
import webtester.model.Id;
import webtester.model.Test;
import webtester.repository.TestRepository;

public class TestRepositoryImpl implements TestRepository {

	@Override
	public List<Test> findAll() {
		Connection c = getCurrentConnection();
		try {
			return (List<Test>) new QueryRunner().query(c, 
					"SELECT id, id_account, name, description, duration_per_question FROM test",
					new DefaultResultSetHandler(Test.class, true));
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}
	
	@Override
	public List<Test> findAllById(Long id) {
		Connection c = getCurrentConnection();
		try {
			return (List<Test>) new QueryRunner().query(c, 
					"SELECT id, id_account, name, description, duration_per_question FROM test WHERE id_account=?",
					new DefaultResultSetHandler(Test.class, true),id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public Test selectTestById(Long id) {
		Connection c = getCurrentConnection();
		try {
			return (Test) new QueryRunner().query(c, 
					"SELECT id, id_account, name, description, duration_per_question FROM test where id=?",
					new DefaultResultSetHandler(Test.class, false), id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void insertTest(Test test) {
		Connection c = getCurrentConnection();
		Long idAccount = test.getIdAccount();
		String name = test.getName();
		String description = test.getDescription();
		int durationPerQuestion = test.getDurationPerQuestion();
		try {
			Id id = (Id)new QueryRunner().insert(c, "INSERT INTO test(id_account, name, description, duration_per_question) VALUES(?,?,?,?)",
					new DefaultResultSetHandler(Id.class, false), idAccount, name, description, durationPerQuestion);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void updateTest(Test test) {
		Connection c = getCurrentConnection();
		long id = test.getId();
		String name = test.getName();
		String description = test.getDescription();
		int durationPerQuestion = test.getDurationPerQuestion();
		try {
			new QueryRunner().update(c, 
					"UPDATE test SET name=?, description=?, duration_per_question=? WHERE id=?",
					 name, description, durationPerQuestion, id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public void deleteTest(long id) {
		Connection c = getCurrentConnection();
		try {
			new QueryRunner().update(c, "DELETE FROM test WHERE id=?", id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}
}
