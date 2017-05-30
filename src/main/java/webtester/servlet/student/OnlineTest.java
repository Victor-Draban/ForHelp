package webtester.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Answer;
import webtester.model.Question;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns = { "/student/online" })
public class OnlineTest extends AbstarctServlet {
	private static final long serialVersionUID = -7941503088580014398L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long IdTest = (long) req.getSession().getAttribute("studentIdTest");
		int time = (int)req.getSession().getAttribute("time");
		List<Question> questions = getTutorService().selectQuestionByIdTest(
				IdTest);
		long pageN = Long.parseLong(req.getParameter("page"));
		long idQuestion = questions.get((int) pageN).getId();
		String nameQuestion = questions.get((int) pageN).getName();
		req.setAttribute("nameQuestion", nameQuestion);
		List<Answer> answers = getTutorService().selectAnswerByIdQuestion(
				idQuestion);
		req.getSession().setAttribute("Answers", answers);
		req.setAttribute("time", time);
		req.setAttribute("answers", answers);
		req.setAttribute("sizeQuestion", questions.size());
		req.setAttribute("sizeAnswer", answers.size());
		
		if (questions.size() - 1 > pageN) {
			pageN++;
			req.setAttribute("page", pageN);
		} else {
			String stop = "stop";
			req.setAttribute("stop", stop);
		}
		
		forwardToPage("student/online_test.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int sizeQuestion = Integer.parseInt(req.getParameter("countQuestion"));
		int sizeAnswer = Integer.parseInt(req.getParameter("countAnswer"));
		long correct = (long) req.getSession().getAttribute("countCorrectAnswerByUser");
		long countAllCorrect = (long) req.getSession().getAttribute("countAllCorrectAnswer");
		List<Answer> answers = (List<Answer>) req.getSession().getAttribute("Answers");
		long countCorrect = answers.stream().filter(i -> (i.getCorrect() == true)).count();
		countAllCorrect += countCorrect;
		
		List<Boolean> list = new ArrayList<>();
		for(int i=0; i<sizeAnswer; i++) {
			String check = req.getParameter("kok"+i);
			list.add((check == null) ? false : true);
		}
		
		for(int i=0; i<sizeAnswer; i++) {
			if (list.get(i) == true && list.get(i).equals(answers.get(i).getCorrect())) {
				correct++;
			} else if(list.get(i) == true && !list.get(i).equals(answers.get(i).getCorrect())) {
				correct--;
			}
		}
		
		req.getSession().setAttribute("countCorrectAnswerByUser", correct);
		req.getSession().setAttribute("allCorrectAnswer", countAllCorrect);
		System.out.println("countCorrectAnswerByUser" + correct);
		System.out.println("allCorrectAnswer" + countAllCorrect);
		String path = "/student/online?page=" + page;
		
		if (sizeQuestion-1 == page ) {
			resp.sendRedirect("/student/test-result?checkCorrect="+correct+"&checkAllCorrect="+countAllCorrect);
		} else {
			resp.sendRedirect(path);
		}
	}
	
}
