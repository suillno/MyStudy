package webtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Http기본구조연습 {

	public static void main(String[] args) {
		// 요청할 URL
		String targetUrl = "https://jsonplaceholder.typicode.com/posts";
		
		// 1, URL객체 생성
		try {
			URL url = new URL(targetUrl);
		
		// 2, HttpURLConnection 객체 생성 및 설정
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();	
		
		// Get 형태로 Request 선언
		conn.setRequestMethod("GET");
			
		// 3, 응답 코드 확인
		int reponseCode = conn.getResponseCode();
		
		// 4, 응답이 성공이면 데이터 읽기 (아래 두가지 모두 작동하는 코드
//		if(reponseCode == 200) {}
		if(reponseCode == HttpURLConnection.HTTP_OK) {
			/**
			 * conn.getInputStream() → 서버 응답을 받아오고, 
			 * InputStreamReader → 바이트를 문자로 바꾸고
			 * BufferedReader → 한 줄씩 읽을 수 있게 도와줌
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream())); // 
			String input;
			StringBuilder inputAdd = new StringBuilder();
			
			while((input = in.readLine()) != null) {
				inputAdd.append(input);
			}
			in.close();
		
		
		// 5, 응답 출력
		JSONArray jArray = new JSONArray(inputAdd.toString());
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		for(int i = 0; i < jArray.length(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			JSONObject obj = jArray.getJSONObject(i);
			map.put("in", obj.get("in"));
			map.put("userId", obj.get("userId"));
			map.put("body", obj.get("body"));
			map.put("title", obj.get("title"));
			
			list.add(map);	
			System.out.println(list);
		}
		
		
		}
		} catch (Exception e) {
			e.printStackTrace(); // err메세지 출력
		}
		
		// 6, 연결 종료

	}

}
