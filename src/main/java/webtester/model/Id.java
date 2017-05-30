package webtester.model;

import java.math.BigInteger;

import webtester.annotation.Column;

public class Id {

	@Column("GENERATED_KEY")
	private BigInteger id;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	
}
