package com.sse.app.trades;

import java.sql.Date;

public class TradeDTO {

	private String bank_id;
	private String bank_pw;
	private Date timepoint;
	private Integer difference;
	private String account_u;
	private Integer resultbalance;

	public String getBank_pw() {
		return bank_pw;
	}

	public void setBank_pw(String bank_pw) {
		this.bank_pw = bank_pw;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public Date getTimepoint() {
		return timepoint;
	}

	public void setTimepoint(Date timepoint) {
		this.timepoint = timepoint;
	}

	public Integer getDifference() {
		return difference;
	}

	public void setDifference(Integer difference) {
		this.difference = difference;
	}

	public String getAccount_u() {
		return account_u;
	}

	public void setAccount_u(String account_u) {
		this.account_u = account_u;
	}

	public Integer getResultbalance() {
		return resultbalance;
	}

	public void setResultbalance(Integer resultbalance) {
		this.resultbalance = resultbalance;
	}

}
