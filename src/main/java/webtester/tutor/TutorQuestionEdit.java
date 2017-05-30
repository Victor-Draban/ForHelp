package webtester.tutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Answer;
import webtester.model.Question;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/question/edit"})
public class TutorQuestionEdit extends AbstarctServlet {
	private static final long serialVersionUID = -1461811387985287640L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long dateOfQuestion = Long.parseLong(req.getParameter("id"));
		String nameQueston = req.getParameter("name");
		req.setAttribute("idQuestion", dateOfQuestion);
		req.getSession().setAttribute("nameQuestion", nameQueston);
		req.getSession().setAttribute("backToHome", dateOfQuestion);
		
		long idQuestion = Long.parseLong(req.getParameter("id"));
		List<Answer> answer = getTutorService().selectAnswerByIdQuestion(idQuestion);
		req.setAttribute("answer", answer);
		forwardToPage("tutor/date_of_question.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("question_name_field");

		Question question = new Question();
		question.setId(id);
		question.setName(name);
		getTutorService().updateQuestion(question);
		
		req.setAttribute("success", "question was update");
		req.setAttribute("point", "1");
		forwardToPage("tutor/date_of_question.jsp", req, resp);
	}
}
