package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class 파일출력 {

	public static void main(String[] args) throws IOException {
		// FileInputStream : 파일 읽기
		// 바이트배열로 읽어야하는데 배열의 길이를 모를경우 불편함
		// 따라서 예제는 [1024바이트만 일게 설정] 하자
		
		byte[] b = new byte[1024];
		FileInputStream input = new FileInputStream("C:/java/out.txt");
		input.read(b);
		System.out.println(new String(b)); // 바이트 배열을 문자열로 출력 new String(b)
		input.close();
		
		// BufferedReader : 파일을 한줄단위로 읽을때사용
		// 대신 FileReader 도 같이 사용해야한다. 
		BufferedReader br = new BufferedReader(new FileReader("C:/java/out2.txt"));
		
		// 줄의 길이를 모르므로 값이 없는줄을 만날때까지 반복문을 돌수있게 while문으로 구성
		while(true) {
			String line = br.readLine();
			if(line == null) break; // 라인에 입력값이 없으면 반복문을 빠져나감.
			System.out.println(line);
		}
		br.close();
		
	}

}
