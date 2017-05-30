package webtester.model;

import java.io.Serializable;
import webtester.annotation.Column;

public class AccountInsert implements Serializable {
	private static final long serialVersionUID = -1097201623460027675L;

	private String login;
	private String password;
	@Column("first_name")
	private String firstName;
	@Column("last_name")
	private String lastName;
	@Column("second_name")
	private String secondName;
	private String email;
	
	public AccountInsert() {
		
	}

	public String getLogin() {
		return login;
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

	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
