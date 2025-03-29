package webtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Http기본구조연습 {

	public static void main(String[] args) {
		String tergetUrl = "https://jsonplaceholder.typicode.com/posts"; // 목표 url 변수 등록
		try { // 오류처리
			URL url = new URL(tergetUrl); // url 객체 생성
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Http 요청을 보내기위한 연결객체 생성
			
			conn.setRequestMethod("GET"); // Http 요청방식을 GET 방식으로 처리
			
			int responseCode = conn.getResponseCode(); // 서버로부터 받은 코드를 int형태로 저장
			
			if(responseCode == HttpURLConnection.HTTP_OK) { // Http 커넥션 코드 200 리턴받으면 이후의 코드 진행
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream())); // conn에서 inputStream(서버의 응답)을 바이트형태로 읽고
																									 // (InputStreamReader)을 통해 문자로 저장 저장한 값을 (BufferedReader)로 줄단위로 불러오기
			String inputLine;
			StringBuilder response = new StringBuilder();
			
			while ( (inputLine = in.readLine() ) != null) { // 문자 합치기
				response.append(inputLine);
			}
			in.close(); // 스트림 닫기
			
			
			
			
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
