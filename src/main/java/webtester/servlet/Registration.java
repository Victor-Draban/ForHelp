package webtester.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.LoginForm;
import webtester.model.Account;

@WebServlet(urlPatterns={"/registration"})
public class Registration extends AbstarctServlet {
	private static final long serialVersionUID = -5222497429376687358L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		forwardToPage("registration.jsp", req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LoginForm form = createForm(LoginForm.class, req);
		
		form.checkFields("registration.jsp", req, resp);
		form.checkPassword("registration.jsp", req, resp);
		
		Account accLogin = getCommonService().findByLogin(form.getLogin());
		if (accLogin != null) {
			req.setAttribute("error", "account with this login is exist");
			forwardToPage("registration.jsp", req, resp);
		}
		
		Account accEmail = getCommonService().findByEmail(form.getEmail());
		if (accEmail != null) {
			req.setAttribute("error", "account with this email is exist");
			forwardToPage("registration.jsp", req, resp);
		}
		
		Account account = new Account.Builder().login(form.getLogin())
				.firstName(form.getFirstName())
				.lastName(form.getLastName())
				.secondName(form.getSecondName())
				.email(form.getEmail())
				.password(form.getPassword()).build();
		
		getCommonService().insertAccount(account);
		
		req.setAttribute("success", "account was create");
		forwardToPage("registration.jsp", req, resp);
	}
}
