package abstractex;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringExam {

	public static void main(String[] args) {
		
		String a = "hello world";
		
		System.out.println(a.charAt(0)); // n번째 문자열 가져오기
		
		System.out.println(a.concat("!!")); // 문자열 합치기
		
		System.out.println(a.contains("w")); // a 변수에 w라는 값이있는지 true, false로 반환
		
		System.out.println(a.length()); // 문자의 길이
		
		System.out.println(a.substring(2)); // 문자열의 index번호 부터 끝까지의 문자열 반환(문자열 자르기)
		
		System.out.println(a.subSequence(3, 8)); // index번호 부터 index번호까지 문자열 반환
		
		System.out.println(a.replace("world", "java")); // 문자열에서 해당문자를 찿아 변환
		
		System.out.println(a.toUpperCase()); // 문자열을 대문자로 변환
		
		System.out.println(a.toLowerCase()); // 문자열을 소문자로 변환
		
		System.out.println(a.startsWith("he")); // 문자열이 지정된 접두어로 시작하는지 확인 true, false
		
		System.out.println(a.endsWith("ld")); // 문자열이 지정된 접미어로 끝나는지 확인 true, false
		
		System.out.println(a.repeat(3)); // 문자열 반복하기
		
		
		String b = "hello world world";
		
		System.out.println(b.indexOf("world")); // 문자열에서 주어진 문자열이 처음 나오는 index 반환

		System.out.println(b.lastIndexOf("world")); // 문자열에서 주어진 문자열이 마지막으로 나타나는 index 반환
		
		System.out.println(a.compareTo(b)); // 문자크기비교 같으면 0 크면 + 작으면 - 반환
		

		
		
		
		String d = " hello ";
		
		System.out.println(d.trim()); // 앞뒤 공백 제거
		
		
		String e = "apple, banana, cherry";
		
		String[] fruits = e.split(","); // 지정한 구분자를 기준으로 문자열을 배열로 반환

		char[] fruits2 = e.toCharArray(); // 문자열을 char 형태로 변환
		
		System.out.println(String.join("/", fruits)); // 배열의 연결을 ""안의 형태로 변환
		
		System.out.println(fruits2.length);
		
		System.out.println(Arrays.toString(fruits));
		
		
		String f = " ";
		
		System.out.println(f.isEmpty()); // 문자열이 비어있는지 확인 (길이 0인지 확인) true, false
		
		System.out.println(f.isBlank()); // 문자열이 비어있거나 공백만 있는지 확인 (공백까지 확인) true, false
		
		
		int num = 123;
		String g = String.valueOf(num); // 객체를 문자열로 변환
		
		
		String str100 = "abc123"; 
		boolean match = str100.matches("[a-z]+\\d+"); // 문자열이 주어진 정규식과 일치하는지 확인 (문자열이 특정한 패턴을 가지고있는가) true, false
		
		
		String str1 = "hello";
		String str2 = "Hello";
		
		System.out.println(str1.equals(str2)); // 문자열 동일여부 비교 true, false 반환
		
		System.out.println(str1.equalsIgnoreCase(str2)); // 대소문자 구별하지 않고 동일여부 비교 true, false
		
	}

}
