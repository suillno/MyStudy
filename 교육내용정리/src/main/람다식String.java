package main;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class 람다식String {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("john", "jane", "jack", "doe", "sam", "sara");

		// 1, 이름이 j로 시작하는것만 선택
		// 2, 정렬
		// 3, 대문자로 변환
		// 4, 리스트로 수집

		// 람다 사용시
		List<String> result = names.stream() // 배열 순회
				.filter(x -> x.startsWith("j")) // 조건 필터
				.sorted() // 오름차순 배열
				.map(String::toUpperCase) // 필터된 값 대문자로 변환
				.collect(Collectors.toList()); // 변경된 값 리스트에 추가
		System.out.println(result);

		// 익명 클래스 람다 안쓸때
		Predicate<String> startsWithJ = new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				return t.startsWith("j");
			}
		};Comparator<String> natualOrder = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		Function<String, String> toUpperCase = new Function<String, String>() {
			
			@Override
			public String apply(String t) {
				// TODO Auto-generated method stub
				return t.toUpperCase();
			}
		};
		List<String> result4 = names.stream()
				.filter(startsWithJ)
				.sorted(natualOrder)
				.map(toUpperCase)
				.collect(Collectors.toList());

		// 리스트에서 짝수만 필터링해서 출력
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> result1 = nums.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());

		System.out.println(result1);

		// 1, Predicate : 조건 검사 true,false
		Predicate<Integer> isEven = n -> n % 2 == 0;
		System.out.println(isEven.test(4)); // integer형태일때 값 출력

		// 2, Function : 변환함수
		Function<String, Integer> str = s -> s.length();
		System.out.println(str.apply("hello")); // String 형태일때 출력

		// 3, Consumer : 값을 소비
		Consumer<String> consumer = s -> System.out.println(s); // 값을 확인하고 계산필요없음
		consumer.accept("hello world");

	}

}
