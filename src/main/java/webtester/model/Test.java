package webtester.model;

import java.io.Serializable;

import webtester.annotation.Column;

public class Test implements Serializable {
	private static final long serialVersionUID = 386830578402508555L;

	private Long id;
	@Column("id_account")
	private Long idAccount;
	private String name;
	private String description;
	@Column("duration_per_question")
	private int durationPerQuestion;
	
	public Test() {
		
	}

	public Test(Long id, Long idAccount) {
		super();
		this.id = id;
		this.idAccount = idAccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationPerQuestion() {
		return durationPerQuestion;
	}

	public void setDurationPerQuestion(int durationPerQuestion) {
		this.durationPerQuestion = durationPerQuestion;
	}
	
}
