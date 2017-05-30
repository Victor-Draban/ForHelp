package webtester.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Result;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/student/test-result"})
public class TestResult extends AbstarctServlet {
	private static final long serialVersionUID = 2392368853473775834L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long idAccount = (long) req.getSession().getAttribute("IdCurrentAccount");
		long idTest = (long) req.getSession().getAttribute("studentIdTest");
		String nameTest = (String) req.getSession().getAttribute("studentNameTest");
		
		long checkCorrect = Long.parseLong(req.getParameter("checkCorrect"));
		if (checkCorrect < 0) {
			checkCorrect = 0;
		}
		
		long checkAllCorrect = Long.parseLong(req.getParameter("checkAllCorrect"));
		if (checkAllCorrect == 0) {
			checkAllCorrect = 1;
		}
		double correctAnswerPercent = (checkCorrect /(double)checkAllCorrect)*100;
		double incorrectAnswerPercent = 100 - correctAnswerPercent;
		String s1 = String.format("%.2f", correctAnswerPercent);
		String s2 = String.format("%.2f", incorrectAnswerPercent);
		
		req.setAttribute("correct", checkCorrect);
		req.setAttribute("allCorrect", checkAllCorrect);
		req.setAttribute("correctAnswer", s1);
		req.setAttribute("incorrectAnswer", s2);
		
		Result result = new Result();
		result.setIdTest(idTest);
		result.setIdAccount(idAccount);
		result.setPercent(correctAnswerPercent);
		result.setTestName(nameTest);
//		System.out.println("correct" + checkCorrect);
//		System.out.println("allCorrect" + checkAllCorrect);
//		System.out.println("correctAnswer" + s1);
//		System.out.println("incorrectAnswer" + s2);
		getStudentService().insertResult(result);
		forwardToPage("student/test_result.jsp", req, resp);
	}
}
