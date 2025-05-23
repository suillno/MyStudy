package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.EmpDAO;
import dao.ShopDAO;
import vo.EmpVO;

public class main {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "scott";
	private static final String PW = "tiger";
	private static Connection conn = null;
	
	public static void main(String[] args) {
		/**
		 * 1. DB 연결 설정 - EmpDAO.connect(); 2. 객채 생성 3. SELECT 해보기 - EmpDAO.getQuery();
		 * 테이블 데이터 조회 EmpDAO.selectListByEname(); 이름으로 데이터 검색 4. SELECT 파라미터 넣기 5.
		 * INSERT 해보기 6. UPDATE 해보기 7. DELETE 해보기
		 */

		/**
		 * 트랜잭션 Transaction : 데이터베이스의 논리적 단위 1. 하나의 트랜잭션은 여러개의 SQL문으로 구성가능 2. 모두 성공 또는
		 * 실패해야 가능
		 * 
		 * // conn.setAutoCommit(false); // 자동 커밋 해제
		 * 
		 * // 롤백 // conn.rollback();
		 * 
		 * // 커밋 // conn.commit();
		 */


		
	
			try { 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(URL, ID, PW);
				System.out.println("접속성공");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버를 접속 실패 : " + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB 접속 실패 : " + e.getMessage());
				e.printStackTrace();
			}
		
		
		
		System.out.println(ShopDAO.searchUser(conn,"kim"));
		
		
	}
}