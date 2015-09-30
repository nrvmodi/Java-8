/**
 * 
 */
package com.nirav.modi.methodreference.arbitary;

import java.util.stream.Stream;

/**
 * @author Nimo
 *
 */
public class MethodReferenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out
				.println("**** Method Reference With instance Method of an arbitary type ****");
		
		//By Lambda
		Stream.of(new Employee("Nirav Modi", new Account(1000l)),
				new Employee("Sonam Modi", new Account(2000l)))
				.map(employee->employee.getAccount()).forEach(System.out::println);

		//By Method Reference
		Stream.of(new Employee("Nirav Modi", new Account(1000l)),
				new Employee("Sonam Modi", new Account(2000l)))
				.map(Employee::getAccount).forEach(System.out::println);

	}
}
