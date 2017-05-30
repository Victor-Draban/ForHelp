package webtester.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;
import webtester.model.Result;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/student/passed-test"})
public class PassedTest extends AbstarctServlet {
	private static final long serialVersionUID = 8336628074170590194L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long idAccount = Long.parseLong(req.getParameter("id"));
		List<Result> passedTests = getStudentService().findAllById(idAccount);
		req.setAttribute("passedTests", passedTests);
		forwardToPage("student/passed_tests.jsp", req, resp);
	}
}
