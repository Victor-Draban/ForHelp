package webtester.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Question;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/create-question"})
public class CreateNewQuestion extends AbstarctServlet {
	private static final long serialVersionUID = -6352525554247446025L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long allQuestion = Long.parseLong(req.getParameter("id"));
		req.getSession().setAttribute("FROM", allQuestion);
		forwardToPage("tutor/create_new_question.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long idTest = (long) req.getSession().getAttribute("FROM");
		String name = req.getParameter("name_test");
		
		if (name.equals("")) {
			req.setAttribute("errorQuestion", "field name is empty");
			forwardToPage("tutor/create_new_question.jsp", req, resp);
		} else {
		Question question = new Question();
		question.setIdTest(idTest);
		question.setName(name);
		
		getTutorService().insertQuestion(question);
		req.setAttribute("successQuestion", "Question was created");
		forwardToPage("tutor/create_new_question.jsp", req, resp);
		}
	}
}
