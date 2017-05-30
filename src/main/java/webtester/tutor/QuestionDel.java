package webtester.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/question/del"})
public class QuestionDel extends AbstarctServlet {
	private static final long serialVersionUID = -3289862402822570912L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long id = Long.parseLong(req.getParameter("id"));
		getTutorService().deleteQuestion(id);
		req.setAttribute("success", "question was delete");
		req.setAttribute("point", "1");
		forwardToPage("tutor/date_of_question.jsp", req, resp);
	}
}
