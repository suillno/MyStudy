package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
			
		try {
			// 1. 서버와 연결 : "localhost" or 127.0.0.1 자기자신과 연결시
			Socket socket = new Socket("localhost", 12345);
			
			// 2. 서버와 데이터 송수신을 위한 스트림 설정
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			// 서버로 보내는 메세지
			out.println("반갑다");
			
			// 서버에서 응답 수신
			String response = in.readLine();
			System.out.println("서버로부터 받은 메세지 : " + response);
			
			// 연결종료
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
