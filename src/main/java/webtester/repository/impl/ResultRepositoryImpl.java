package webtester.repository.impl;

import static webtester.repository.impl.ConnectionUtils.getCurrentConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import webtester.exception.WebtesterApplicationException;
import webtester.handler.DefaultResultSetHandler;
import webtester.model.Id;
import webtester.model.Result;
import webtester.model.Test;
import webtester.repository.ResultRepository;

public class ResultRepositoryImpl implements ResultRepository {

	@Override
	public void insertTest(Result result) {
		Connection c = getCurrentConnection();
		Long idTest = result.getIdTest();
		Long idAccount = result.getIdAccount();
		double percent = result.getPercent();
		String testName = result.getTestName();
		try {
			Id id = (Id)new QueryRunner().insert(c, "INSERT INTO result(id_test, id_account, percent, test_name) VALUES(?,?,?,?)",
					new DefaultResultSetHandler(Id.class, false), idTest, idAccount, percent, testName);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public List<Result> findAllById(Long id) {
		Connection c = getCurrentConnection();
		try {
			return (List<Result>) new QueryRunner().query(c, 
					"SELECT id, id_test, id_account, percent, created, test_name FROM result WHERE id_account=?",
					new DefaultResultSetHandler(Result.class, true),id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

}
