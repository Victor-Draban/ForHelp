package webtester.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.annotation.Column;

public class LoginForm {

	private String login;
	private String firstName;
	private String lastName;
	private String secondName;
	private String email;
	private String password;
	private String passwordConfirm;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public void checkPassword(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(getPassword() == "" || !getPassword().equals(getPasswordConfirm())) {
			req.setAttribute("error", "password and confirm password not equals");
			forwardToPage("html/registration.jsp", req, resp);
		}
	}
	
	protected void forwardToPage(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("currentPage", page);
		req.getRequestDispatcher("/WEB-INF/view/page-template.jsp").forward(req, resp);
	}
	
	public void checkFields(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (getLogin().equals("")) {
			req.setAttribute("error", "field login is empty");
			req.setAttribute("point", "1");
			forwardToPage(page, req, resp);
		} else if (getFirstName().equals("")) {
			req.setAttribute("error", "field firstName is empty");
			req.setAttribute("point", "1");
			forwardToPage(page, req, resp);
		} else if (getLastName().equals("")) {
			req.setAttribute("error", "field lastName is empty");
			req.setAttribute("point", "1");
			forwardToPage(page, req, resp);
		} else if (getEmail().equals("")) {
			req.setAttribute("error", "field email is empty");
			req.setAttribute("point", "1");
			forwardToPage(page, req, resp);
		} else if (getPassword().equals("")) {
			req.setAttribute("error", "field password is empty");
			req.setAttribute("point", "1");
			forwardToPage(page, req, resp);
		} else if (getPasswordConfirm().equals("")) {
			req.setAttribute("error", "field confirmPassword is empty");
			req.setAttribute("point", "1");
			forwardToPage(page, req, resp);
		}
	}
}
