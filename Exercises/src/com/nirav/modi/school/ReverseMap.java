package com.nirav.modi.school;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReverseMap {
	public static void main(String[] args) {

		Map<Standard, Set<Subject>> map = new HashMap<Standard, Set<Subject>>();
		Map<Subject, Set<Standard>> reverseMap = new HashMap<Subject, Set<Standard>>();
		
		HashSet<Subject> std1Subjects = new HashSet<Subject>();
		std1Subjects.add(new Subject("English"));
		std1Subjects.add(new Subject("Maths"));
		std1Subjects.add(new Subject("Science"));

		HashSet<Subject> std2Subjects = new HashSet<Subject>();
		std2Subjects.add(new Subject("Hindi"));
		std2Subjects.add(new Subject("Gujarati"));
		std2Subjects.add(new Subject("Maths"));

		HashSet<Subject> std3Subjects = new HashSet<Subject>();
		std3Subjects.add(new Subject("Sanskrit"));
		std3Subjects.add(new Subject("Science"));
		std3Subjects.add(new Subject("Maths"));
		
		map.put(new Standard("1"), std1Subjects);
		map.put(new Standard("2"), std2Subjects);
		map.put(new Standard("3"), std3Subjects);
		
		/*for(Standard std:map.keySet()){
			for(Subject sub: map.get(std)){
				if(reverseMap.containsKey(sub)){
					reverseMap.get(sub).add(std);
				}else{
					HashSet<Standard> standardSet = new HashSet<Standard>();
					standardSet.add(std);
					reverseMap.put(sub, standardSet);
				}
			}
		}*/
		

		//1.
		map.keySet().forEach((std) -> map.get(std).forEach((sub)->{
			reverseMap.computeIfAbsent(sub,standard-> new HashSet<>()).add(std);
			reverseMap.computeIfPresent(sub, (subject,stdSet) -> reverseMap.get(subject)).add(std);
		}));
		
//		Collectors.groupingBy(map.values().stream().forEach((set)->set.stream().);


		map.entrySet().parallelStream()
		        .<Map.Entry<Subject, Standard>> flatMap(
		                e -> e.getValue().stream()
		                    .map(sub -> new AbstractMap.SimpleEntry<>(sub, e.getKey())))
		        .collect(Collectors.groupingBy(e -> e.getKey(), 
		                 Collectors.mapping(e -> e.getValue(), 
		                 Collectors.toSet())));
		
		
//		map.forEach((standard, subjectSet) -> subjectSet.stream().forEach(
//				(subject) -> reverseMap.putIfAbsent(subject,
//						new HashSet<Standard>())));

		// reverseMap.forEach((subject,standardSet)-> map.);

		// reverseMap.merge(key, value, Hashset::add);
		reverseMap
				.forEach((k, v) -> System.out.println("k-" + k + " , v-" + v));
		// Map -> values

	}
}
