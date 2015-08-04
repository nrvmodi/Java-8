package com.nirav.modi.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterList {

	/**
	 * {@link http://stackoverflow.com/questions/31808893/filter-elements-from-a-list-based-on-another-list}
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Boolean> boolList = Arrays.asList(true, false, true, true, false);

		List<Integer> collect = IntStream.range(0, intList.size())
				.filter(i -> boolList.get(i)).mapToObj(i -> intList.get(i))
				.collect(Collectors.toList());
		System.out.println(collect);
		
		
		
	}

}
