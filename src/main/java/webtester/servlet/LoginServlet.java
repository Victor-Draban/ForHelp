package webtester.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.Constants;
import webtester.exception.ValidationException;
import webtester.form.LoginForm;
import webtester.model.Account;
import webtester.model.AccountRole;

@WebServlet(urlPatterns={"/login"})
public class LoginServlet extends AbstarctServlet {
	private static final long serialVersionUID = 5698529372032989806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getSession().getAttribute(Constants.CURRENT_ACCOUNT) != null) {
			resp.sendRedirect("/admin");
		} else {
			forwardToPage("login.jsp", req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String role = req.getParameter("role_field");
		LoginForm form = createForm(LoginForm.class, req);
		
		try {
			Account account = getCommonService().login(form.getLogin(), form.getPassword(), 4);
			List<AccountRole> listRole = getAccountRoleService().findRoleById(account.getId());
			
			long haveRole = listRole.stream().filter(i -> role.equals(i.getName())).count();

			if (haveRole > 0) {
				req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, account);
				req.getSession().setAttribute("IdCurrentAccount", account.getId());
				req.getSession().setAttribute("role", req.getParameter("role_field"));
				if (req.getParameter("role_field").equals("admin")) {
					resp.sendRedirect("/admin");
				} else if (req.getParameter("role_field").equals("tutor") || req.getParameter("role_field").equals("advance tutor")) {
					resp.sendRedirect("/tutor");
				} else if (req.getParameter("role_field").equals("student")) {
					resp.sendRedirect("/student/all-test-for-students");
				}
			} else {
				req.setAttribute("error", "you have not this role");
				forwardToPage("login.jsp", req, resp);
			}
		} catch (ValidationException e) {
			req.setAttribute("error", e.getMessage());
			forwardToPage("login.jsp", req, resp);
		}
		
	}

}
