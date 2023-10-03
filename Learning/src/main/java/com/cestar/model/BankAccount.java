package com.cestar.model;

import java.sql.Date;

public class BankAccount {

	private int account_id;
	
	private String accont_type;
	
	private String accountHolderName;
	
	private String accountHolderContact;
	
	private String accountBalance;
	
	private Date accountSetupDate;

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccont_type() {
		return accont_type;
	}

	public void setAccont_type(String accont_type) {
		this.accont_type = accont_type;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderContact() {
		return accountHolderContact;
	}

	public void setAccountHolderContact(String accountHolderContact) {
		this.accountHolderContact = accountHolderContact;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getAccountSetupDate() {
		return accountSetupDate;
	}

	public void setAccountSetupDate(Date accountSetupDate) {
		this.accountSetupDate = accountSetupDate;
	}

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int account_id, String accont_type, String accountHolderName, String accountHolderContact,
			String accountBalance, Date accountSetupDate) {
		super();
		this.account_id = account_id;
		this.accont_type = accont_type;
		this.accountHolderName = accountHolderName;
		this.accountHolderContact = accountHolderContact;
		this.accountBalance = accountBalance;
		this.accountSetupDate = accountSetupDate;
	}

	@Override
	public String toString() {
		return "BankAccount [account_id=" + account_id + ", accont_type=" + accont_type + ", "
				+ "accountHolderName="
				+ accountHolderName + ", accountHolderContact=" + accountHolderContact + ", "
						+ "accountBalance="
				+ accountBalance + ", accountSetupDate=" + accountSetupDate + "]";
	}
	
	
}
