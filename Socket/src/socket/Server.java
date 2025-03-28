package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		/**
		 * 소켓 통신 : Socket Communication
		 * 네트워크를 통해 데이터를 주고 받을수 있게 하는 방법
		 * 네트워크상에 N개의 컴퓨터간 연결을 설정하고 데이터를 송수신하는 추상화된 인터페이스
		 * 
		 * 소켓 : 2대가 교신을 한다고 가정할시
		 * 2대의 컴퓨터가 데이터를 주고 받기위한 논리적 연결점
		 * 기본적으로 TCP/IP 프로토콜을 사용
		 * 
		 * 서버, 클라이언트 
		 * 서버 : 소켓 통신에서 클라이언트의 연결요청을 기다리고 수락한후 클라이언트와 데이터를 주고 받는다
		 * 클라이언트 : 서버와 연결을 기다리고 서버와 데이터를 주고 받는다.
		 * 
		 * 통신 흐름
		 * 1. 서버 소켓 생성 : 서버는 특정 포트에서 클라이언트의 연결을 기다린다.
		 * 	(Port : 데이터를 특정 프로그램이나 서비스로 전달하는 문과 같은 역활을함)
		 * 	(아파치 > html 구동 80포트, 스프링 8080)
		 * 포트 : ip 주소화 함께 사용됨. 0 ~ 65535
		 * ex : 192.168.0.10:80
		 * 
		 * 2. 클라이언트 소켓 생성 : 클라이언트는 서버의 IP주소 + 포트번호를 사용해서 서버와 연결시도
		 * 
		 * 3. 연결 수립 : 클라이언트가 서버에 연결하면, 서버는 클라이언트의 연결을 수락하고 데이터 교신 가능
		 * 
		 * 4. 데이터 송수신 : 데이터를 주고 받으며 동신을 진행 
		 * 
		 * 5. 연결 종료 : 종료
		 */
		
		try {
			// 1. 소켓 생성
			ServerSocket serverSocket = new ServerSocket(12345);
			System.out.println("클라이언트 연결 대기 중");
			
			// 3. 연결수락
			Socket clientSocket = serverSocket.accept();
			System.out.println("클라이언트 연결 완료");
			
			// 4. 데이터 송수신
			BufferedReader in = new BufferedReader(new InputStreamReader((clientSocket.getInputStream())));
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			// 메시지 수신코드
			String message = in.readLine();
			System.out.println("클라이언트 메시지 : " + message);
			
			// 클라이언트 응답 메시지 전송
			out.println(message);
			
			// 5. 연결종료
			serverSocket.close();
			clientSocket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
