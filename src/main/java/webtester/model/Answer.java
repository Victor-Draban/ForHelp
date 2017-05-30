package webtester.model;

import java.io.Serializable;

import webtester.annotation.Column;

public class Answer implements Serializable {
	private static final long serialVersionUID = -5296530733961219059L;

	private Long id;
	@Column("id_question")
	private Long idQuestion;
	private String name;
	private boolean correct;
	
	public Answer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
}
