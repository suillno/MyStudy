package abstractex;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class StringTest1 {

	public static void main(String[] args) {

		
		// 문제.5) 20250314 ==> 2025-03-14
		String ex2 = "20250314";
		String ex3 = ex2.substring(0,4) + "-" + ex2.substring(4,6) + "-" + ex2.substring(6);
		
		System.out.println(ex3);


		
		// 문제.4) https://www.naver.com/path 문자열에서 naver.com만 출력
		String url = "https://www.naver.com/path";
		String domain = url.substring(url.indexOf("www.")+4, url.indexOf(".com")+4);
		
		System.out.println(url.indexOf("www.")+4);
		System.out.println(url.indexOf(".com")+4);
		System.out.println(domain);
		System.out.println(url.substring(12,21));
		
		

		// 문제.3) 010-1234-5678 주어진 문자를 -를 제거하고 숫자만 출력
//		String ex1 = "010-1234-5678";
//		System.out.println(ex1.replace("-", ""));

		// 문제.2) 아래 문자열에서 첫번째 단어를 추출하라. 단어는 공백으로 구분된다

//		String ex2 = "I Love Java";
//		String ex1 = ex2.split(" ")[0];
//		
//		System.out.println(ex1);

		// 문제.1) 문자열의 길이가 홀수일 경우, 한 문자를 출력하고, 짝수일 경우 중간 두 문자를 출력
		// 입력 : java
		// 출력 : av
		// 입력 : programming
		// 출력 : a

//		Scanner scanner = new Scanner(System.in);
//		System.out.print("수정한 문자를 입력해주세요 : ");
//		String str3 = scanner.next();

//		String a = (String) str3.subSequence((str3.length()/2)-1, (str3.length()/2)+1);
//		String b = (String) (str3.subSequence((str3.length()/2), (str3.length()/2)+1));
//		
//		String result = str3.length()%2 == 0 ?  a : b;
//
//		System.out.println(result);

	}

}
