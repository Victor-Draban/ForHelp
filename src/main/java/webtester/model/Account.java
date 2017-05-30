package webtester.model;

import java.io.Serializable;
import java.sql.Timestamp;

import webtester.annotation.Column;

public class Account implements Serializable {
	private static final long serialVersionUID = 6368216901864535945L;
	
	private Long id;
	private String login;
	private String password;
	@Column("first_name")
	private String firstName;
	@Column("last_name")
	private String lastName;
	@Column("second_name")
	private String secondName;
	private String email;
	private boolean active;
	private Timestamp created;
	
	public Account() {
		super();
	}
	
	public Account(Builder builder) {
		id = builder.id;
		login = builder.login;
		password = builder.password;
		firstName = builder.firstName;
		lastName = builder.lastName;
		secondName = builder.secondName;
		email = builder.email;
		active = builder.active;
	}
	
	public Account(Long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
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
	
	public static class Builder {
		private Long id = 0l;
		private String login = "";
		private String password = "";
		private String firstName = "";
		private String lastName = "";
		private String secondName = null;
		private String email = "";
		private boolean active = false;
		
		public Builder() {
			
		}
		
		public Builder(long id, String login) {
			this.id = id;
			this.login = login;
		}
		
		public Builder id(long id) {
			this.id = id;
			return this;
		}
		
		public Builder login(String login) {
			this.login = login;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Builder secondName(String secondName) {
			this.secondName = secondName;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder active(boolean active) {
			this.active = active;
			return this;
		}
		
		public Account build() {
			return new Account(this);
		}
	}
	
}
