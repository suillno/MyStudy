package main;

import java.util.Arrays;

public class 예외처리 {

	public static void main(String[] args) {
		// 예외 : 프로그램 실행중에 발생할수 있는 예상하지 못한 오류 또는 문제
		// ex : 0으로 나누기를 시도, 배열의 index 범위를 초과하는걸 조회한다.
		// 예외 발생시 프로그램이 중단, 따라서 이를 처리하는 법을 배운다.
		
		int a = 5;
		int b = 0;
		
		try {
			// 예외가 발생할수 있는 코드
			System.out.println(a / b);
		} catch (ArithmeticException | NullPointerException e) { // 오류코드를 catch에 입력 해당오류발생시 {}안에 구문실행
			// 예외처리 코드
			System.out.println(e.getMessage());
		} finally {
			System.out.println("예외가 발생하던 말던 항상 실행되는 코드");
		}
		

		int[] arr = new int[5];
		arr[0] = 1;
		
		
		try {
			for(int i = 0; i <= 5; i++) {
				arr[i] = i;
				System.out.println(Arrays.toString(arr));
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위를 벗어났습니다.");
		}
		
		
		
	}

}
