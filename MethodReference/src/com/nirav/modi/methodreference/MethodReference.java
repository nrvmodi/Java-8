/**
 * 
 */
package com.nirav.modi.methodreference;

import java.util.stream.Stream;

/**
 * @author Nimo
 *
 */
public class MethodReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Method reference -> Static Method
		// Stream.of(1,2,3,4,5,6).forEach(MRWithStaticMethod::squrt);
		
		//By Reference
		Stream.of(1, 2, 3, 4, 5, 6).map(MRWithStaticMethod::squrt)
				.forEach(System.out::println);

	}
}
