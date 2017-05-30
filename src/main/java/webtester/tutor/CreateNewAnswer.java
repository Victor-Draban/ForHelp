package webtester.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Answer;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/question/create-answer"})
public class CreateNewAnswer extends AbstarctServlet {
	private static final long serialVersionUID = 7296528942061926151L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long idQuestion = Long.parseLong(req.getParameter("id"));
		req.getSession().setAttribute("backQuestion", idQuestion);
		forwardToPage("tutor/create_new_answer.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long idQuestion = (long) req.getSession().getAttribute("backQuestion");
		String name = req.getParameter("answer_field");
		String correct = req.getParameter("correct_field");
		
		
		Answer answer = new Answer();
		answer.setIdQuestion(idQuestion);
		answer.setName(name);
		
		if (name.equals("")) {
			req.setAttribute("errorAnswer", "field name is empty");
			forwardToPage("tutor/create_new_answer.jsp", req, resp);
		} else if (correct == null) {
			answer.setCorrect(false);
			getTutorService().insertAnswer(answer);
			req.setAttribute("successAnswer", "Answer was created");
			forwardToPage("tutor/create_new_answer.jsp", req, resp);
		} else if (correct != null) {
			answer.setCorrect(true);
			getTutorService().insertAnswer(answer);
			req.setAttribute("successAnswer", "Answer was created");
			forwardToPage("tutor/create_new_answer.jsp", req, resp);
		}
		
	}
}
