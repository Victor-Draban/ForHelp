package webtester.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/tutor/answer/del"})
public class AnswerDel extends AbstarctServlet {
	private static final long serialVersionUID = 4853675388137526910L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long id = Long.parseLong(req.getParameter("id"));
//		getAnswerService().deleteAnswer(id);
		getTutorService().deleteAnswer(id);
		req.setAttribute("success", "test was delete");
		req.setAttribute("point", "1");
		forwardToPage("tutor/date_of_answer.jsp", req, resp);
	}
}
