package webtester.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Test;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/create-test"})
public class CreateNewTest extends AbstarctServlet {
	private static final long serialVersionUID = -7933542687573100434L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		forwardToPage("tutor/create_new_test.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long idAccount = (long) req.getSession().getAttribute("IdCurrentAccount");
		String name = req.getParameter("name_test");
		String description = req.getParameter("review_text");
		String durationPerQuestion = req.getParameter("duration_per_question");
		
		if (name.equals("")) {
			req.setAttribute("errorTest", "field name is empty");
			forwardToPage("tutor/create_new_test.jsp", req, resp);
		} else if (description.equals("")) {
			req.setAttribute("errorTest", "field description is empty");
			forwardToPage("tutor/create_new_test.jsp", req, resp);
		} else if (durationPerQuestion.equals("")) {
			req.setAttribute("errorTest", "field durationPerQuestion is empty");
			forwardToPage("tutor/create_new_test.jsp", req, resp);
		}
		
		int k = 0;
		try {
		k = Integer.parseInt(durationPerQuestion);
		Test test = new Test();
		test.setIdAccount(idAccount);
		test.setName(name);
		test.setDescription(description);
		test.setDurationPerQuestion(k);
		getTutorService().insertTest(test);
		
		req.setAttribute("successTest", "test was create");
		forwardToPage("tutor/create_new_test.jsp", req, resp);
		} catch (Exception e) {
			req.setAttribute("errorTest", "field durationPerQuestion not number");
			forwardToPage("tutor/create_new_test.jsp", req, resp);
		}
		
	}
}
