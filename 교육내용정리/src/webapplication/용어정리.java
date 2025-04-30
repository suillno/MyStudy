package webapplication;

public class 용어정리 {

	public static void main(String[] args) {
		/**
		 * 서블릿 (Servlet) - 실행
		 * 자바 웹 개발에서 핵심 역할을 하는 서버 측 프로그램
		 * 클라이언트(웹 브라우저)의 요청을 받아 처리하고, 그 결과를 응답하는 자바 클래스입니다.
		 * 요청을 분석하고,데이터 처리(DB 조회 등)하고,결과를 HTML이나 JSON으로 만들어서
		 * **응답(response)**으로 돌려주는 역할을 담당
		 */
		
		/**
		 * JSP (JavaServer Pages) - view 
		 * HTML인데 JAVA 코드를 같이 쓸수 있는 HTML
		 * JSP도 내부적으로는 서블릿으로 변환되서 실행
		 * UI 중심 로직에 적함
		 */
		
		/**
		 * 톰캣 (TOMCAT) - tomcat10 zip (pgp, sha512)
		 * 서블릿과 JSP를 실행하는 웹서버 WAS (Web Application Server)
		 * Server 컨테이너 역활을 한다.(요청- 응답 처리하는 환경제공)
		 * HTTP 요청을 받고, 해당 URL에 맞는 서블릿이나 JSP에게 전달
		 */
		
		/** jsp 처리 순서
		 * 사용자 => 브라우저 hello.jsp 요청
		 * 톰캣 http 요청을 받고 => 적절한 jsp를 찿는다 =>
		 * jsp > 자바의 서블릿 코드로 변환 > 컴파일 > 클래스 > 클래스가 메모리에 올라감 > 그후 요청은 이 클래스가 처리
		 */
		
		/**
		 * 서블릿>... class로 컴파일되서 존재 > 바로실행
		 * get, post doGet(), doPost
		 */
	}

}
