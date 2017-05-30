package webtester.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;
import webtester.model.Test;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/student/all-test-for-students"})
public class AllTestForStudents extends AbstarctServlet {
	private static final long serialVersionUID = -6542973315559732902L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Test> tests = getTutorService().selectAllTest();
		req.setAttribute("tests", tests);
		req.getSession().setAttribute("listT", tests);
		long countCorrectAnswerByUser = 0;
		long countAllCorrectAnswer = 0;
		req.getSession().setAttribute("countCorrectAnswerByUser", countCorrectAnswerByUser);
		req.getSession().setAttribute("countAllCorrectAnswer", countAllCorrectAnswer);
		forwardToPage("student/all_test_for_students.jsp", req, resp);
	}
}
