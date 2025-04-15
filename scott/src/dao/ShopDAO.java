package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import vo.EmpVO;
import vo.ShopMember;




public class ShopDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "scott";
	private static final String PW = "tiger";
	private static Connection conn = null;
	
	public static void connect() {
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
	}
	
public static ShopMember searchUser(String memberId) {
	connect();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	ShopMember sm = null;
	
	try {
		String query = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			String mId = rset.getString("MEMBER_ID");
			String memberPw = rset.getString("MEMBER_PW");
			String phone = rset.getString("PHONE");
			char gender = rset.getString("GENDER").charAt(0);
			sm = new ShopMember(mId,memberPw,phone,gender);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	System.out.println("체크3");
	return sm;
}
}
