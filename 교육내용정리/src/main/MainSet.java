package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class MainSet {

	public static void main(String[] args) {
		// 집합 Set : 중복 허용 불가, 순서가 없음
		// Set : HashSet, LinkedHashSet, TreeSet 등등

		HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
		// System.out.println(set); 순서가 없음

		HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

		// retainAll : 교집합 구하기 (새로운 HashSet 생성후 생성된 변수에 값을 추가)
		HashSet<Integer> s3 = new HashSet<>(s1);
		s3.retainAll(s2);
		System.out.println(s3);

		// addAll : 합집합 구하기 (새로운 HashSet 생성후 생성된 변수에 값을 추가)
		HashSet<Integer> s4 = new HashSet<>(s1);
		s4.addAll(s2);
		System.out.println(s4);

		// removeAll 차집합 구하기 (새로운 HashSet 생성후 생성된 변수에 값을 추가)
		HashSet<Integer> s5 = new HashSet<>(s1);
		s5.removeAll(s2);
		System.out.println(s5);
		
		// add, addAll, remove
		s1.add(10); // 값 하나 추가
		System.out.println(s1);
		s1.addAll(s2); // 값 여러개 추가 (배열등)
		System.out.println(s1);
		s1.remove(1);
		System.out.println(s1);
		
		// 

	}

}
