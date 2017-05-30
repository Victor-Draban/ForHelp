package webtester.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/test/del"})
public class TestDel extends AbstarctServlet {
	private static final long serialVersionUID = 7493560667327404844L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long id = Long.parseLong(req.getParameter("id"));
		getTutorService().deleteTest(id);
		req.setAttribute("success", "test was delete");
		req.setAttribute("point", "1");
		forwardToPage("tutor/date_of_test.jsp", req, resp);
	}
}
