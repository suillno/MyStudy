package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		System.out.println("Server connect");
		try {
			ServerSocket serverSocket = new ServerSocket(1546);
			System.out.println("클라이언트 연결 대기 중");
			while (true) {
				new ClientHandler(serverSocket.accept()).start();
				System.out.println("클라이언트 연결됨");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 쓰레드 설정
	private static class ClientHandler extends Thread {
		private Socket socket;

		public ClientHandler(Socket socket) {
			// do something
			this.socket = socket;
		}

		
		// 클라이언트 연결 후, 쓰레드가 시작되면서 자동으로 실행되는 메서드
		public void run() {
			try {
				// 서버 입출력에 동작 정의
				BufferedReader in = new BufferedReader(new InputStreamReader((socket.getInputStream())));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				
				// 메시지 수신코드
				String message = in.readLine();
				System.out.println("클라이언트 메시지 : " + message);
				
				// 클라이언트 응답 메시지 전송
				out.println(message);
				
				// 5. 연결종료
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
