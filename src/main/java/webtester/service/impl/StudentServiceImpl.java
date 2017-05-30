package webtester.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webtester.exception.WebtesterApplicationException;
import webtester.model.Result;
import webtester.repository.ResultRepository;
import webtester.repository.impl.ConnectionUtils;
import webtester.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private final DataSource dateSource;
	private final ResultRepository resultRepository;
	
	public StudentServiceImpl(ResultRepository resultRepository, DataSource dateSource) {
		super();
		this.dateSource = dateSource;
		this.resultRepository = resultRepository;
	}

	@Override
	public void insertResult(Result result) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			resultRepository.insertTest(result);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

	@Override
	public List<Result> findAllById(Long id) {
		try(Connection c = dateSource.getConnection()) {
			ConnectionUtils.setCurrentConnection(c);
			return resultRepository.findAllById(id);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		} finally {
			ConnectionUtils.removeCurrentConnection();
		}
	}

}
