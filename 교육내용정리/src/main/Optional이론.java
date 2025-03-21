package main;

import java.util.Optional;

public class Optional이론 {

	// Optional<자료형의 객채>
	public static Optional<String> getUserByid(int id) {
		return Optional.ofNullable(null);
	}

	public static void main(String[] args) throws IllegalAccessException {

		// Optional
		// null 체크 : java 8 이전에는 없다.
		// NullPointException : NPE 값이 없을때 발생하는 애러
		
		String optional5 = "hello";
		
		if (optional5 != null) {
			System.out.println(optional5);
		}
		// 뭔가 연산후 null 추가 체크
		if (optional5 != null) {
			optional5.toUpperCase();
		}
		// 추가 연산후
		if (optional5 == null) {
			System.out.println(optional5);
		}
		
		// Optional 사용
		Optional<String> optional4 = Optional.of("Hello");
		optional4.ifPresent(System.out::println); //
		optional4.ifPresent(String::toUpperCase); // 대문자로 변경
		
		String msg = optional4.orElseThrow(()-> new IllegalArgumentException("값이 없다"));
		System.out.println(msg);
		
		Optional<String> user = getUserByid(12);
//		String safeName = user != null ? "" : ""; 3항연산자로 NPE 처리 가능
		
		// Optional 을 통한 NPE 방지, 람다식으로 구현함
		System.out.println( 
				user.map(String::toUpperCase).orElse("이름이 없습니다.")
				);

		// null이 아닌 값을 가지는 optional 객체 생성
		Optional<String> optional = Optional.of("안녕");
		
		// null 일수도 있는 optional 객체 생성
		Optional<String> optional2 = Optional.ofNullable(null);
		
		// 값이 비어있는 optional 객체 생성
		Optional<String> optional3 = Optional.empty();
		
		// optional 객체가 값을 포함하고 있는지 확인하는 매서드
		if(optional.isPresent()){
			System.out.println(optional.get());
		}
		
		// optional 객체가 값을 포함하고 있을때 특정한 작업을 수행 (람다식)
		optional.ifPresent(v -> System.out.println(v));
		
		// ofElse >> optional 객체가 값을 포함하고 있으면 그 값을 반환하고 그렇지 않으면 기본 값을 반환한다.
		String v = optional2.orElse("기본값");
		System.out.println(v);
		
		// orElseget >> optional 객체가 값을 포함하고 있으면 그 값을 반환하고 그렇지 않으면
		// 람다표현식이나 메서드를 참초하여 기본값을 반환한다.
		v = optional2.orElseGet(() -> "기본값");
		
		// orElseget >> optional 객체가 값을 포함하고 있으면 그 값을 반환하고 그렇지 않으면 예외를 던진다
		v = optional2.orElseThrow(()-> new IllegalAccessException("오류"));
		
		
	}

}
