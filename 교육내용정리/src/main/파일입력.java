package main;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class 파일입력 {

	public static void main(String[] args) throws IOException {
		// 파일 입출력
		// 파일 쓰기
		// input stream >> 읽기
		// output stream >> 쓰기

		// FileOutputStream : 지정경로에 파일생성.
		FileOutputStream output = new FileOutputStream("C:/java/out.txt");
		
		// \r\n 줄바꿈 문자
		// 유닉스 계열에서는 \n만 있어도 된다.
		// 윈도우는 \r\n으로 작성해야 개행된다.
		for (int i = 1; i < 11; i++) {
			String data = i + "번째 줄입니다.\r\n";
			// outputStream : InputStream 처럼 byte 단위로 데이터를 처리하는 클래스 이다
			// FileOutputStream : outputStream 클래스를 상속받는다
			// 따라서 데이터를 바이트 단위로 처리한다.
			output.write(data.getBytes());
		}

		// 사용한 파일 객체를 닫아주는 매서드
		output.close();

		// FileWriter
		// 파일을 쓸때 byte 배열대신 문자열을 사용 할 수 있다. == BufferedReader 과 동일
		FileWriter fw = new FileWriter("C:/java/out2.txt");

		for (int i = 1; i < 11; i++) {
			String data = i + "번째 줄입니다.\r\n";
			fw.write(data);
		}
		fw.close();

		// printWriter 작성한 그대로 입력
		// 개행문자 \r\n를 안써도 된다
		PrintWriter pw = new PrintWriter("C:/java/out3.txt");
		for (int i = 1; i < 11; i++) {
			String data = i + "번째 줄입니다";
			pw.println(data);
		}
		pw.close();

		// 파일을 닫고 추가할때 사용 경로에, true 추가
		FileWriter fw2 = new FileWriter("C:/java/out2.txt", true);
		for (int i = 11; i < 21; i++) {
			String data = i + "번째 줄입니다.\r\n";
			fw2.write(data);
		}
		fw2.close();
		
		// printWriter 도 추가할때는 FileWriter를 새로 생성해 true 값을 추가해줘야함
		PrintWriter pw2 = new PrintWriter(new FileWriter("C:/java/out3.txt", true));
		for (int i = 11; i < 21; i++) {
			String data = i + "번째 줄입니다";
			pw2.println(data);
		}
		pw2.close();
	}

}
