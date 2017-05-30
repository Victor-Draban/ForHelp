package webtester.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Test;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns = { "/student/info-for-student" })
public class InfoForStudent extends AbstarctServlet {
	private static final long serialVersionUID = 8083167387258363781L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		forwardToPage("student/info_for_student.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tmp = req.getParameter("test");
		long tmp5 = Long.parseLong(tmp);
		List<Test> tests = (List<Test>) req.getSession().getAttribute("listT");
		String nameTest = tests.stream().filter(i -> i.getId() == tmp5).findFirst().get().getName();
		int time = tests.stream().filter(i -> i.getId() == tmp5).findFirst().get().getDurationPerQuestion();
		int page = 0;
		req.getSession().setAttribute("page", page);
		if (tmp == null) {
			resp.sendRedirect("/student/all-test-for-students");
		} else {
			long idTest = tmp5;
			req.getSession().setAttribute("studentIdTest", idTest);
			req.getSession().setAttribute("studentNameTest", nameTest);
			req.getSession().setAttribute("time", time);
			forwardToPage("student/info_for_student.jsp", req, resp);
		}
	}
}
