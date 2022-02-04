package com.test;

import java.util.Date;

public class Transaction {
	
	@Override
	public String toString() {
		return  accountNumber + "\t" + date
				+ "\t" + amount + "\t" + type;
	}
	private int accountNumber;
	private Date date;
	private int amount;
	private String type;
	
	
	
	
	public Transaction(int accountNumber, Date date, int amount, String type) {
		super();
		this.accountNumber = accountNumber;
		this.date = date;
		this.amount = amount;
		this.type = type;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
