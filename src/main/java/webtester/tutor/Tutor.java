package webtester.tutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Test;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor"})
public class Tutor extends AbstarctServlet {
	private static final long serialVersionUID = -5105872134839652720L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String roleIs = (String) req.getSession().getAttribute("role");
		long id = (long) req.getSession().getAttribute("IdCurrentAccount");
		List<Test> tests = (roleIs.equals("tutor")) ? getTutorService().selectAllTestById(id) : getTutorService().selectAllTest();
		req.setAttribute("tests", tests);
		forwardToPage("tutor/all_test.jsp", req, resp);
	}
}
