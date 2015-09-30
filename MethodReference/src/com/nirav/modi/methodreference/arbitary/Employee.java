/**
 * 
 */
package com.nirav.modi.methodreference.arbitary;

/**
 * @author Nimo
 *
 */
public class Employee {
	
	public Employee(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}
	private String name;
	private Account account;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", account=" + account + "]";
	}
	
	
	
	
	
}
