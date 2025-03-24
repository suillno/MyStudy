package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import vo.PostVo;

public class Http형식 {

	public static void main(String[] args) {
		// 요청할 URL
		String targetUrl = "https://jsonplaceholder.typicode.com/posts";
		
		// 1, URL객체 생성
		try {
			URL url = new URL(targetUrl);
		
		// 2, HttpURLConnection 객체 생성 및 설정
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET"); // GET으로 Request설정
		/**
		 *  추가 옵션이 필요할경우
		 *  conn.setRequestProperty("User-Agent", "Mozilla/5.0"); // 키,값을 지정하여 옵션 추가 
		 */
		
		// 3, 응답 코드 확인
		int responseCode = conn.getResponseCode(); // 오류코드 확인은 Http이론에
		
		System.out.println(responseCode);
		
		// 4, 응답이 성공이면 데이터 읽기 (아래 두가지 모두 작동하는 코드
		// if(responseCode == 200) {}
		if(responseCode == HttpURLConnection.HTTP_OK) { // responseCode가 200 일때
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream())); // 출력을위해 
			String inputLine; 
			// inputLine += str; // 메모리낭비심함
			StringBuilder response = new StringBuilder();
			
			while ( (inputLine = in.readLine() ) != null) { // 문자 합치기
				response.append(inputLine);
			}
			in.close(); // 스트림 닫기
			
			// 5, 응답 출력
//			System.out.println(response.toString()); // 제이슨 문자열을 String형태로 출력
			
			// Json 문자열을 Object로 변환
			
		
//			String responseStr = response.toString(); // String 형태의 제이슨을 변수에 담는다
			
			JSONArray jsonArray = new JSONArray(response.toString()); // 값을 여려개로 받을때 arrayList의 형태로 받기
			PostVo pov = new PostVo();
			HashMap<String, Object> postMap = new HashMap<String, Object>();
			List<HashMap<String, Object>> postList = new ArrayList<>();
			
//			for(int i = 0; i < jsonArray.length(); i++) { // postVo에 값넣기
//				JSONObject obj = jsonArray.getJSONObject(i);
//				int userId = obj.getInt("userId");
//				int id = obj.getInt("id");
//				String title = obj.getString("title");
//				String body = obj.getString("body");
//				pov.setUserId(userId);
//				pov.setId(id);
//				pov.setTitle(title);
//				pov.setBody(body);
////				pov.setBody(obj.getString("body")); 이런 형태로도 가능함
//				System.out.println(pov);
//			}
			
//			for(int i = 0; i < jsonArray.length(); i++) { // 해쉬맵에 값 넣기
//				HashMap<String, Object> map = new HashMap<String, Object>(); // 
//				JSONObject obj = jsonArray.getJSONObject(i);
//				int userId = obj.getInt("userId");
//				int id = obj.getInt("id");
//				String title = obj.getString("title");
//				String body = obj.getString("body");
//				map.put("userId", userId);
//				map.put("id", id);
//				map.put("title", title);
//				map.put("body", body);
//				postList.add(map);
//			}
//			
//			System.out.println(postList);
			
			// body에서 officiis 키워드를 포함하는 요소를 찿아서 다음과 같은 규격으로 출력
			
			List<Object> fileredList = new ArrayList<>();
			HashMap<String, Object> fileredMap = new HashMap<String, Object>();
			 
			for(int i = 0; i < jsonArray.length(); i++) { // 
				JSONObject obj = jsonArray.getJSONObject(i);
				
				String body = obj.getString("body") != null ? obj.getString("body") : ""; // null일때 빈값을 가지는 방어구문
				if(body.contains("officiis")) {
					fileredList.add(obj);
				}
			}
			fileredMap.put("list", fileredList);
			fileredMap.put("count", fileredList.size());
			System.out.println(fileredMap.toString());
			
			
//			JSONObject JsonObject = new JSONObject(responseStr); // 제이슨 오브젝트를 통해 키 벨류로 표기
//			System.out.println(JsonObject.toString()); // 표기 확인
			
//			String title = JsonObject.getString("title"); // 키를 변수로 설정하고 제이슨에서 값을가져와 변수에 담는다
//			String body = JsonObject.getString("body");
//			int id = JsonObject.getInt("id"); // 인터형태의 경우
//			int userId = JsonObject.getInt("userId");
			
//			PostVo pov = new PostVo(); // PostVo에 객체생성후 정보담기
			
//			pov.setTitle(title); // PostVo에 정보담기
//			pov.setBody(body);
//			pov.setId(id);
//			pov.setUserId(userId);
//			
//			System.out.println(pov.getId());
//			
//			HashMap<String, Object> map = new HashMap<String, Object>(); // 해쉬맵으로 정보저장
//			map.put("id", id);
//			map.put("userId", userId);
//			map.put("title", title);
//			map.put("body", body);
//			
//			System.out.println(map.get("id")); // 해쉬 맵 값 조회법 (추후 값을가져올때 형변환핊요)
			
			// PostVo 객체 생성
			
			
		} else {
			System.out.println(responseCode + " 오류 발생");
		}
		// 6, 연결 종료
		conn.disconnect();
		
		}
		catch (Exception e) {
			e.printStackTrace(); // err메세지 출력
		}
		
		
	}

}
