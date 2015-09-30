package com.nirav.modi.methodreference.arbitary;

public class Account {
	
	public Account(long amount) {
		super();
		this.amount = amount;
	}

	private long amount;

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + "]";
	}
	
}
