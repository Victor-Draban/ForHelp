package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/admin/del"})
public class AdminDel extends AbstarctServlet {
	private static final long serialVersionUID = 7707583036554930425L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		long id = Long.parseLong(req.getParameter("id"));
		getAdminService().deleteAccount(id);
		req.setAttribute("success", "account " + id + " was delete");
		req.setAttribute("point", "1");
		forwardToPage("/admin", req, resp);
	}
}
