package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/admin/home"})
public class HomeServlet extends AbstarctServlet {
	private static final long serialVersionUID = -1188002707079047374L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		forwardToPage("home.jsp", req, resp);
	}
	
}
