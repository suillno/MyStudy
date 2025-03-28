package main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URL {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * URL encoding
		 * 
		 * 서버를 공격하기위해 url의 파라미터를 이용한다 이를 방어하기 위해
		 * 좋아! URL Encoding은 우리가 웹에서 데이터를 전송할 때, 특수문자나 한글 같은 문자들을 안전하게 전달할 수 있게 바꿔주는 과정
		 * 
		 */
		
		String str = "hello";
		String encodedstr = URLEncoder.encode(str, "UTF-8");
		System.out.println(encodedstr);
	}

}
