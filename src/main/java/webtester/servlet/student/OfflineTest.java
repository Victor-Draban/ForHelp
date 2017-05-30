package webtester.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Answer;
import webtester.model.Question;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/student/offline"})
public class OfflineTest extends AbstarctServlet {
	private static final long serialVersionUID = 7332698869998200830L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long IdTest = (long) req.getSession().getAttribute("studentID_TEST");
		List<Question> questions = getTutorService().selectQuestionByIdTest(IdTest);
		req.setAttribute("question", questions);
		
		Map<Question, List<Answer>> result = new HashMap<>();
		List<Answer> list = new ArrayList<>();
		
		for(Question q: questions) {
			list = getTutorService().selectAnswerByIdQuestion(q.getId());
			result.put(q, list);
		}
		
		req.setAttribute("map", result);
		forwardToPage("student/offline_test.jsp", req, resp);
	}
}
