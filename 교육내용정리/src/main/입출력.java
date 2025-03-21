package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 입출력 {

	public static void main(String[] args) throws IOException {
		// 입출력 512p
		// System.in : 1바이트만 읽고 ascii code 형식의 값을 반환
		// InputStream : 바이트 단위의 데이터를 읽어 들일때 사용하는 내장 클래스
		
		InputStream in = System.in; 
		
//		int a = in.read(); // throws IOException 오류메세지를 추후 처리선언
//		System.out.println(a); // 출력시 아스키 코드 값 리턴
		
		// 사용자가 3바이트를 입력했을때 3바이트 모두 일고 싶다
//		int a;
//		int b;
//		int c;
//		a = in.read();
//		b = in.read();
//		c = in.read();
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
		
		// byte 3바이트를 가지는 변수 생성후 InputStream 변수.read()의 값에 지정해준다.
//		byte[] byteArr = new byte[3];
//		in.read(byteArr);
//		System.out.println(byteArr[0]);
//		System.out.println(byteArr[1]);
//		System.out.println(byteArr[2]);
		
		// InputStreamReader : 입력받은 그대로 출력
		InputStreamReader reader = new InputStreamReader(in);
		
//		char[] charArr = new char[3]; // 입력받는 값을 char 형태로 3개를 Array형태로 받는다
//		reader.read(charArr);
//		System.out.println(charArr);
		
		// BufferedReader : 문자열을 합쳐서 출력
		BufferedReader br = new BufferedReader(reader); 
		String brString = br.readLine();
		System.out.println(brString);
	}

}
