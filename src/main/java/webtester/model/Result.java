package webtester.model;

import java.io.Serializable;
import java.sql.Timestamp;

import webtester.annotation.Column;

public class Result implements Serializable {
	private static final long serialVersionUID = -6450669887045205359L;

	private long id;
	@Column("id_test")
	private long idTest;
	@Column("id_account")
	private long idAccount;
	private double percent;
	private Timestamp created;
	@Column("test_name")
	private String testName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdTest() {
		return idTest;
	}
	public void setIdTest(long idTest) {
		this.idTest = idTest;
	}
	public long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
}
