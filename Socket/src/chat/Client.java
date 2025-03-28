package chat;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Client extends JFrame {

	private JTextField chatText;
	private JTextArea localText;

	public Client() {
		setTitle("채팅 프로그램");
		
		setSize(600, 400);

		// 닫는 구문생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();

		JLabel chatTextLabel = new JLabel("채팅 입력 : ");

		chatText = new JTextField(20);

		JButton btn1 = new JButton("확인");

		inputPanel.add(chatTextLabel);
		inputPanel.add(chatText);
		inputPanel.add(btn1);

		localText = new JTextArea();
		localText.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(localText);

		add(inputPanel, BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.CENTER);

		// 버튼동작
		btn1.addActionListener(e -> {
			String chat = chatText.getText();

			String result = "";

			result = Client.getChat(chat);

			localText.setText(result);
		});

	}
	
	public static String getChat(String chat) {
		try {
			// 1. 서버와 연결 : "localhost" or 127.0.0.1 자기자신과 연결시
			Socket socket = new Socket("localhost", 1546);
			
			// 2. 서버와 데이터 송수신을 위한 스트림 설정
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			// 서버로 보내는 메세지
			out.println(chat);

			// 서버에서 응답 수신
			String response = in.readLine();
			System.out.println("서버로부터 받은 메세지 : " + response);
			
			// 연결종료
			socket.close();
			
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chat;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			// Frame 메서드 생성
			Client frame = new Client();
			// 생성한 프레임이 표시되도록 설정
			frame.setVisible(true);

		});
	}

}
