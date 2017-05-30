package webtester.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.LoginForm;
import webtester.model.Account;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/admin/create-account"})
public class CreateNewAccount extends AbstarctServlet {
	private static final long serialVersionUID = -1944556623431437385L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		forwardToPage("admin/create_new_account.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LoginForm form = createForm(LoginForm.class, req);
		String active = req.getParameter("active");
		
		String roleStudent = req.getParameter("user");
		String roleTutor = req.getParameter("tutor");
		String roleAdvanceTutor = req.getParameter("adv_tutor");
		String roleAdmin = req.getParameter("admin");
		
		form.checkFields("admin/create_new_account.jsp", req, resp);
		form.checkPassword("admin/create_new_account.jsp", req, resp);
		
		Account accLogin = getCommonService().findByLogin(form.getLogin());
		if (accLogin != null) {
			req.setAttribute("error", "account with this login is exist");
			forwardToPage("admin/create_new_account.jsp", req, resp);
		}
		
		Account accEmail = getCommonService().findByEmail(form.getEmail());
		if (accEmail != null) {
			req.setAttribute("error", "account with this email is exist");
			forwardToPage("admin/create_new_account.jsp", req, resp);
		}
		
		Account account = new Account.Builder().login(form.getLogin())
				.firstName(form.getFirstName())
				.lastName(form.getLastName())
				.secondName(form.getSecondName())
				.email(form.getEmail())
				.password(form.getPassword())
				.active((active == null) ? false : true).build();
		
		List<Integer> roles = new ArrayList<>();
		if (roleStudent != null) roles.add(1);
		if (roleTutor != null) roles.add(2);
		if (roleAdvanceTutor != null) roles.add(3);
		if (roleAdmin != null) roles.add(4);
		
		getAdminService().insertAccount(account, roles);
		req.setAttribute("success", "account was create");
		forwardToPage("admin/create_new_account.jsp", req, resp);
	}
}
