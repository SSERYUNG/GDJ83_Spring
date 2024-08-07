package com.sse.app.accounts;

import java.sql.Date;

public class AccountInfoDTO {

	private String bank_id;
	private String bank_pw;
	private String account_u;
	private Integer balance;
	private Integer difference;
	private Date timepoint;
	private Integer resultbalance;

	public Integer getResultbalance() {
		return resultbalance;
	}

	public void setResultbalance(Integer resultbalance) {
		this.resultbalance = resultbalance;
	}

	public Date getTimepoint() {
		return timepoint;
	}

	public void setTimepoint(Date timepoint) {
		this.timepoint = timepoint;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_pw() {
		return bank_pw;
	}

	public void setBank_pw(String bank_pw) {
		this.bank_pw = bank_pw;
	}

	public String getAccount_u() {
		return account_u;
	}

	public void setAccount_u(String account_u) {
		this.account_u = account_u;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getDifference() {
		return difference;
	}

	public void setDifference(Integer difference) {
		this.difference = difference;
	}

}
