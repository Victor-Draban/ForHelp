package webtester.tutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;
import webtester.model.Question;
import webtester.model.Test;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/allQuestion"})
public class TutorAllQuestion extends AbstarctServlet {
	private static final long serialVersionUID = -2493496880165278L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long idQuestion = Long.parseLong(req.getParameter("id"));
		List<Question> question = getTutorService().selectQuestionByIdTest(idQuestion);
		req.getSession().setAttribute("ID_QUESTION", idQuestion);
		req.setAttribute("back", idQuestion);
		req.setAttribute("question", question);
		forwardToPage("tutor/all_questions.jsp", req, resp);
	}
}
