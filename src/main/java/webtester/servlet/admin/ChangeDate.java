package webtester.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.LoginForm;
import webtester.model.Account;
import webtester.model.Account.Builder;
import webtester.model.AccountRole;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/admin/edit"})
public class ChangeDate extends AbstarctServlet {
	private static final long serialVersionUID = -1053804270047696014L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long idAccount = Long.parseLong(req.getParameter("id"));
		req.getSession().setAttribute("idForChange", idAccount);
		Account account = getCommonService().findById(idAccount);
		List<AccountRole> roles = getAccountRoleService().findRoleById(idAccount);
		req.setAttribute("account", account);
		req.setAttribute("roles", roles);
		forwardToPage("admin/change_date.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LoginForm form = createForm(LoginForm.class, req);
		long id = (long) req.getSession().getAttribute("idForChange");
		String active = req.getParameter("active_field");
		
		String roleStudent = req.getParameter("role_user");
		String roleTutor = req.getParameter("role_tutor");
		String roleAdvanceTutor = req.getParameter("role_adv_tutor");
		String roleAdmin = req.getParameter("role_admin");
		
		form.checkFields("admin/change_date.jsp", req, resp);
				
		if (form.getPassword() == "" || !form.getPassword().equals(form.getPasswordConfirm())) {
			req.setAttribute("error", "password and confirm password not equals");
			req.setAttribute("point", "1");
			forwardToPage("html/change_date.jsp", req, resp);
		} else {
			Account account = new Account.Builder(id, form.getLogin())
					.firstName(form.getFirstName())
					.lastName(form.getLastName())
					.secondName(form.getSecondName())
					.email(form.getEmail())
					.password(form.getPassword())
					.active((active == null) ? false : true).build();
			
			List<Integer> listRole = new ArrayList<>();
			if (roleStudent != null) listRole.add(1);
			if (roleTutor != null) listRole.add(2);
			if (roleAdvanceTutor != null) listRole.add(3);
			if (roleAdmin != null) listRole.add(4);
			getAdminService().updateAccount(account, listRole);
			req.setAttribute("success", "account was update");
			req.setAttribute("point", "1");
			forwardToPage("admin/change_date.jsp", req, resp);
		}
	}
}