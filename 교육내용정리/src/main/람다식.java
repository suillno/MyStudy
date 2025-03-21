package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class 람다식 {
	
	// 기본구조 
	// (파라미터 n개) -> 표현식 / 한줄일때
	// (파라미터 n개) -> {상태;} / 한줄이상시
	
	
	public static void main(String[] args) {
		
		// 불필요한 클래스 선언을 줄이고 간결하게 코드 작성
		// 병렬처리가 가능
		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};
		
		
		Comparator<String> c = (o1, o2) -> o1.length() - o2.length();
		
		List<String> list = new ArrayList<>(Arrays.asList("apple","banna","orange"));
		list.stream().forEach(s -> System.out.println(s)); // 배열내 반복을돌려 조회후 s에 대입 s를 프린터
		list.parallelStream().forEach(s -> System.out.println(s)); // 병렬처리
		list.forEach(s -> System.out.println(s));
		
		list.stream().filter(s -> { // 조건을 걸어 문자를 조회
			System.out.println(s);
			return s.startsWith("o");
		}).map(String::toUpperCase).forEach(System.out::println); // 리턴받은 값을 대문자로 변환후 값을 프린터
		
		// 배열을 읽어 합과 평균을 구하는 공식
		int[] nums = {1,2,3,4,5};
		
		int sum = 0;
		
		int nums2 = Arrays.stream(nums).sum();
		Double nums3 = Arrays.stream(nums).average().orElse(0.0);
		int nums2 = Arrays.stream(nums).
		
		
		// 1, 파라미터 없는 람다식
		Runnable runnaable = () -> System.out.println("출력");
		
		// 2, 파라미터가 1개일때 람다식
		Consumer<String> consumer = s -> System.out.println("출력");
		
		// 3, 파라미터가 여러개일때 람다식
		BinaryOperator<Integer> add = (a,b) -> a + b;
		
		// 4. 여러 문장이있는 람다식
		Function<Integer, Integer> f = x -> {
			int r = x + 1;
			return r;
		};
		
		// 함수형 인터페이스
		Function<Integer, Integer> ff = x -> x*x;
		
		System.out.println(ff.apply(15));
	}

}
