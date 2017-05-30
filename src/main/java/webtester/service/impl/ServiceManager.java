package webtester.service.impl;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import webtester.exception.ValidationException;
import webtester.model.Account;
import webtester.repository.AccountRepository;
import webtester.repository.AccountRoleRepository;
import webtester.repository.AnswerRepository;
import webtester.repository.QuestionRepository;
import webtester.repository.ResultRepository;
import webtester.repository.TestRepository;
import webtester.repository.impl.AccountRepositoryImpl;
import webtester.repository.impl.AccountRoleRepositoryImpl;
import webtester.repository.impl.AnswerRepositoryImpl;
import webtester.repository.impl.QuestionRepositoryImpl;
import webtester.repository.impl.ResultRepositoryImpl;
import webtester.repository.impl.TestRepositoryImpl;
import webtester.service.AccountRoleService;
import webtester.service.AdminService;
import webtester.service.CommonService;
import webtester.service.TutorService;
import webtester.service.StudentService;

public final class ServiceManager {

	private static final String SERVICE_MANAGER = "SERVICE_MANAGER";

	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute(SERVICE_MANAGER);
		if (instance == null) {
			instance = new ServiceManager();
			context.setAttribute(SERVICE_MANAGER, instance);
		}
		return instance;
	}
	
	private final AccountRepository accountRepository;
	private final AccountRoleRepository accountRoleRepository;
	private final TestRepository testRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final ResultRepository resultRepository;
	
	private final CommonService commonService;
	private final AdminService adminService;
	private final AccountRoleService accountRoleService;
	private final TutorService tutorService;
	private final StudentService studentService;
	private final BasicDataSource dataSource;
	
	private ServiceManager() {
		dataSource = buildDataSource();
		accountRepository = new AccountRepositoryImpl();
		accountRoleRepository = new AccountRoleRepositoryImpl();
		testRepository = new TestRepositoryImpl();
		questionRepository = new QuestionRepositoryImpl();
		answerRepository = new AnswerRepositoryImpl();
		resultRepository = new ResultRepositoryImpl();
		
		commonService = new CommonServiceImpl(accountRepository, dataSource);
		adminService = new AdminServiceImpl(accountRepository, dataSource);
		accountRoleService = new AccountRoleServiceImpl(accountRoleRepository, dataSource);
		tutorService = new TutorServiceImpl(testRepository, questionRepository, answerRepository, dataSource);
		studentService = new StudentServiceImpl(resultRepository, dataSource);
	}
	
	public CommonService getCommonService() {
		return commonService;
	}
	
	public AdminService getAdminService() {
		return adminService;
	}
	
	public TutorService getTutorService() {
		return tutorService;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	
	public AccountRoleService getAccountRoleService() {
		return accountRoleService;
	}
	
	public void shutdown() {
		try {
			dataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private BasicDataSource buildDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/testUIT?useSSL=false&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("increase");
		ds.setInitialSize(5);
		ds.setMaxTotal(20);
		return ds;
	}
}
