package webtester.tutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;
import webtester.model.Test;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/edit"})
public class ChangeTest extends AbstarctServlet {
	private static final long serialVersionUID = 5330979047604440837L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long idTest = Long.parseLong(req.getParameter("id"));
		Test test = getTutorService().selectTestById(idTest);
		req.setAttribute("test", test);
		req.getSession().setAttribute("pathToBack", idTest);
		req.getSession().setAttribute("ID_TEST", idTest);
		forwardToPage("tutor/date_of_test.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long idAccount = (long) req.getSession().getAttribute("pathToBack");
		String name = req.getParameter("name_test");
		String description = req.getParameter("review_text");
		String durationPerQuestion = req.getParameter("duration_per_question");
		
		if (name.equals("")) {
			req.setAttribute("error", "field name is empty");
			forwardToPage("tutor/date_of_test.jsp", req, resp);
		} else if (description.equals("")) {
			req.setAttribute("error", "field description is empty");
			forwardToPage("tutor/date_of_test.jsp", req, resp);
		} else if (durationPerQuestion.equals("")) {
			req.setAttribute("error", "field durationPerQuestion is empty");
			forwardToPage("tutor/date_of_test.jsp", req, resp);
		}
		
		try {
		int k = Integer.parseInt(durationPerQuestion);
		Test test = new Test();
		test.setId(idAccount);
		test.setName(name);
		test.setDescription(description);
		test.setDurationPerQuestion(k);
		getTutorService().updateTest(test);
		
		req.setAttribute("success", "test was update");
		forwardToPage("tutor/date_of_test.jsp", req, resp);
		} catch (Exception e) {
			req.setAttribute("error", "field durationPerQuestion not number");
			forwardToPage("tutor/date_of_test.jsp", req, resp);
		}
	}
}
