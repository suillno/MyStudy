package kr.co.kh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.kh.vo.BoardVO;


public class BoardDAO {
	/**
	 * 1, DB 연결
	 * 2, EMP 테이블 SELECT 메서드 만들고 테스트 (컨트롤러)
	 * 3, SELECT한 내용이 로그에 찍어지는지 확인
	 * 4, 연결해제
	 */
	// 접속 URL 및 ID PW 상수로 선언
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "scott";
	private static final String PW = "tiger";
	private Connection conn = null;
	
	private PreparedStatement pstmt = null; // 쿼리 실행
	private ResultSet rSet = null; // 값 담기
	private static List<BoardVO> board = null;

	public void connect() {
		try { // 드라이버를 JVM에 로딩 - Oracle 데이터베이스 드라이버를 로드하는 코드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 1. DB 접속
			conn = DriverManager.getConnection(URL, ID, PW);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 접속실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 접속 실패 : " + e.getMessage());
			e.printStackTrace();
		}
	}
	// 자원반환 클로즈 명령어
	public void connectClose() {
		try {
			if (rSet != null)
				rSet.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// BOARD insert 메서드
	public int insertBoard(BoardVO boardVO) {
		int rowsAffected = 0;
		try {
		this.connect();
		String query = "INSERT INTO BOARDS (BOARD_TITLE,BOARD_CONTENT,BOARD_WRITER)"
				+ "VALUES (?,?,?)";
			this.pstmt = conn.prepareStatement(query);
			this.pstmt.setString(1, boardVO.getBoardTitle());
			this.pstmt.setString(2, boardVO.getBoardContent());
			this.pstmt.setString(3, boardVO.getBoardWrite());
			// 영향받은 행갯수 리턴
			rowsAffected = this.pstmt.executeUpdate();
			return rowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connectClose();
		}
		return rowsAffected;
	}
	// BOARD 목록조회 메서드
	public List<BoardVO> selectList(HashMap<String, Object> requstMap) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			this.connect();	
			String query = "SELECT * FROM BOARDS";
			this.pstmt = this.conn.prepareStatement(query);
			this.rSet = this.pstmt.executeQuery();
			while(this.rSet.next()) {
				Long boardNo = this.rSet.getLong("BOARD_NO");
				String boardTitle = this.rSet.getString("BOARD_TITLE");
				String boardContent = this.rSet.getString("BOARD_CONTENT");
				String boardWriter = this.rSet.getString("BOARD_WRITER");
				Date boarRegDate = this.rSet.getDate("BOARD_REG_DATE");
				BoardVO nboard = new BoardVO();
				nboard.setBoardNO(boardNo);
				nboard.setBoardTitle(boardTitle);
				nboard.setBoardContent(boardContent);
				nboard.setBoardWrite(boardWriter);
				nboard.setRegDate(boarRegDate);
				list.add(nboard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connectClose();
		}
		return list;
	}
}