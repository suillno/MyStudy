package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmpDAO;
import vo.EmpVO;

public class main {

	public static void main(String[] args) {
		/**
		 * 1. DB 연결 설정 - EmpDAO (connect) 
		 * 2. 객채 생성 
		 * 3. SELECT 해보기 - EmpDAO (getQuery) 
		 * 4. SELECT 파라미터 넣기
		 * 5. INSERT 해보기 
		 * 6. UPDATE 해보기 
		 * 7. DELETE 해보기
		 */

		/**
		 * DB 접속 URL, username, password
		 */
		
		for(EmpVO item : EmpDAO.getQuery()) {
			System.out.println(item);
		}
		
		
	}
}