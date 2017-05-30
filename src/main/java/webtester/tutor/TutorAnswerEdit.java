package webtester.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Answer;
import webtester.model.Test;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/question/answer/edit"})
public class TutorAnswerEdit extends AbstarctServlet {
	private static final long serialVersionUID = -5476930110130164273L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long idQuestion = (long) req.getSession().getAttribute("pathToBack");
		req.setAttribute("backQuestion", idQuestion);
		
		long idAnswer = Long.parseLong(req.getParameter("id"));
		Answer answer = getTutorService().selectAnswerById(idAnswer);
		req.setAttribute("singleAnswer", answer);
		
		forwardToPage("tutor/date_of_answer.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("answer_field");
		String correct = req.getParameter("correct_field");
		
		Answer answer = new Answer();
		answer.setId(id);
		answer.setName(name);
		answer.setCorrect(correct == null ? false : true) ;
		getTutorService().updateAnswer(answer);
		req.setAttribute("success", "answer was update");
		req.setAttribute("point", "1");
		forwardToPage("tutor/date_of_answer.jsp", req, resp);
	}
}
