package webtest0;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class 입출력시험 {
	
	public void output1() {
		
		
	}

	public static void main(String[] args) {
		
		// 파일입력시 오류가 발생하는 이유를 찿고 설멍하시오
		FileOutputStream fow = null;
		// 파일 아웃스트림의 경우 바이트 배열로 입력하는 기능이어서 입력시 이상한 기호가 입력됨
		FileWriter fw = null;
		// 파일라이터나 프린트라이터를 사용해야함
		try {
			fow = new FileOutputStream("C:/java/test.txt");
			fw = new FileWriter("C:/java/test2.txt");
			
			String str = "안녕하세요!";
			
			fw.write(str);
			
//			for(int i = 0; i <str.length(); i++) {
//				fw.write(str.charAt(i));
//				fow.write(str.charAt(i));
//			}
			
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				// 파일을 닫는 명령어는 오류가 발생해도 실행되어야하므로 finally 안에 try catch문으로 감싸야한다.
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}


