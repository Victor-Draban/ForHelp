package webtester.model;

import java.io.Serializable;

import webtester.annotation.Column;

public class AccountRole implements Serializable {
	private static final long serialVersionUID = -3572460782038416656L;
	
	private Long id;
	@Column("id_account")
	private Long accountId;
	@Column("id_role")
	private int idRole;
	private String name;
	
	public AccountRole() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
