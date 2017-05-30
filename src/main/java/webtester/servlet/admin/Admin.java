package webtester.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;
import webtester.model.AccountRole;
import webtester.servlet.AbstarctServlet;

@WebServlet(urlPatterns={"/admin"})
public class Admin extends AbstarctServlet {
	private static final long serialVersionUID = 2350238625633003379L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Account> accounts = getAdminService().findAll();
		List<AccountRole> roles = getAccountRoleService().findRole();
		req.setAttribute("accounts", accounts);
		req.setAttribute("roles", roles);
		forwardToPage("admin/admin.jsp", req, resp);
	}
}
