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
import java.util.Optional;

import kr.co.kh.vo.BoardVO;
import kr.co.kh.vo.SearchHelper;

public class BoardDAO {
	/**
	 * 1. DB 연결
	 * 2. EMP 테이블 SELECT 메서드 만들고 테스트 (컨트롤러)
	 * 3. SELECT한 내용이 로그에 찍어지는지 까지만 확인
	 * 4. 연결 해제
	 */
	
	// 1. DB 접속 상수 선언
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rSet = null;
	
	// DB 접속
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// DB 접속 해제
	private void disConnect() {
		try {
			if (pstmt != null) pstmt.close();
			if (rSet != null) rSet.close();
			if (connection != null) connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Optional<BoardVO> selectOne(HashMap<String, Object> requestMap) {
		Optional<BoardVO> result = Optional.ofNullable(new BoardVO());
		try {
			this.connect();
			String query = "SELECT * FROM BOARDS WHERE BOARD_NO = ?";
			this.pstmt = this.connection.prepareStatement(query);
			this.pstmt.setLong(1, (Long) requestMap.get("boardNo"));
			this.rSet = this.pstmt.executeQuery();
			if (this.rSet.next()) {
				result.get().setBoardNo(this.rSet.getLong("BOARD_NO"));
				result.get().setBoardTitle(this.rSet.getString("BOARD_TITLE"));
				result.get().setBoardContent(this.rSet.getString("BOARD_CONTENT"));
				result.get().setBoardWriter(this.rSet.getString("BOARD_WRITER"));
				result.get().setRegDate(this.rSet.getDate("BOARD_REG_DATE"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			this.disConnect();
		}
		return result;
	}
	
	/**
	 * BOARD 목록 메서드
	 * @param requestMap
	 * @return
	 */
	public List<BoardVO> selectList(SearchHelper searchHelper) {
		List<BoardVO> list = new ArrayList<>();
		try {
			this.connect();
			
//			SELECT * FROM (
//					SELECT B.*, 
//						ROW_NUMBER() OVER (ORDER BY BOARD_NO) AS RN
//						FROM BOARDS B
//			where title =''
			
			
//					ORDER BY B.BOARD_NO DESC
//				) OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY
			
			StringBuilder query = new StringBuilder("SELECT * FROM (");
			query.append("SELECT B.*, ");
			query.append("ROW_NUMBER() OVER (ORDER BY BOARD_NO) AS RN ");
			query.append("FROM BOARDS B");
			
			if (searchHelper.getSearchType().equals("title") && !searchHelper.getSearchKeyword().isEmpty()) {
				query.append("AND B.BOARD_TITLE LIKE '%' || ? || '%'");
			} else if (searchHelper.getSearchType().equals("content") && !searchHelper.getSearchKeyword().isEmpty()) {
				query.append("AND B.BOARD_CONTENT LIKE '%' || ? || '%'");
			}
			
			query.append(" ORDER BY B.BOARD_NO DESC");
			query.append(") OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
			
			System.out.println(query.toString());
			this.pstmt = this.connection.prepareStatement(query.toString());
			System.out.println(searchHelper.getSearchKeyword().isEmpty());
			if (
				(searchHelper.getSearchType().equals("title") || searchHelper.getSearchType().equals("content"))
				&& !searchHelper.getSearchKeyword().isEmpty()
			) {
				this.pstmt.setString(1, searchHelper.getSearchKeyword());
				this.pstmt.setLong(2, (searchHelper.getPage() - 1) * searchHelper.getPageSize());
				this.pstmt.setLong(3, searchHelper.getPageSize());
			} else {
				this.pstmt.setLong(1, (searchHelper.getPage() - 1) * searchHelper.getPageSize());
				this.pstmt.setLong(2, searchHelper.getPageSize());
			}
			
			this.rSet = this.pstmt.executeQuery();
			while (this.rSet.next()) {
				Long boardNo = this.rSet.getLong("BOARD_NO");
				String boardTitle = this.rSet.getString("BOARD_TITLE");
				String boardContent = this.rSet.getString("BOARD_CONTENT");
				String boardWriter = this.rSet.getString("BOARD_WRITER");
				Date boardRegDate = this.rSet.getDate("BOARD_REG_DATE");
				BoardVO vo = new BoardVO();
				vo.setBoardNo(boardNo);
				vo.setBoardTitle(boardTitle);
				vo.setBoardContent(boardContent);
				vo.setBoardWriter(boardWriter);
				vo.setRegDate(boardRegDate);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			this.disConnect();
		}
		return list;
	}
	
	// BOARD에 INSERT
	public int insertBoard(BoardVO boardVO) {
		// 영향 받은 행 갯수
		int rowsAffected = 0;
		try {
			// DB 접속
			this.connect();
			String query = "INSERT INTO BOARDS (BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER) VALUES (?,?,?)";
			this.pstmt = connection.prepareStatement(query);
			this.pstmt.setString(1, boardVO.getBoardTitle());
			this.pstmt.setString(2, boardVO.getBoardContent());
			this.pstmt.setString(3, boardVO.getBoardWriter());
			// 쿼리 실행
			rowsAffected = this.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB 접속 해제 및 자원 반환
			this.disConnect();
		}
		return rowsAffected;
	}
	
	/**
	 * 게시물 수정
	 * @param boardVO
	 * @return
	 */
	public int update(BoardVO boardVO) {
		int rowsAffected = 0;
		try {
			this.connect();
			String query = "UPDATE BOARDS SET BOARD_TITLE = ? , BOARD_CONTENT = ? WHERE BOARD_NO = ? ";
			this.pstmt = this.connection.prepareStatement(query);
			this.pstmt.setString(1, boardVO.getBoardTitle());
			this.pstmt.setString(2, boardVO.getBoardContent());
			this.pstmt.setLong(3, boardVO.getBoardNo());
			rowsAffected = this.pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			this.disConnect();
		}
		return rowsAffected;
	}
	
	/**
	 * 게시물 삭제
	 * @param nos
	 * @return
	 */
	public int delete(String[] nos) {
		int rowsAffected = 0;
		try {
			this.connect();
			
			StringBuilder query = new StringBuilder("DELETE FROM BOARDS WHERE BOARD_NO IN (");
			
			for (int i = 0; i < nos.length; i++) {
				query.append("?");
				if (i < nos.length - 1) query.append(",");
			}
			query.append(")");
			this.pstmt = this.connection.prepareStatement(query.toString());
			
			for (int i = 0; i < nos.length; i++) {
				this.pstmt.setLong(i + 1, Long.parseLong(nos[i]));
			}
			
			rowsAffected = this.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
		} finally {
			this.disConnect();
		}
		return rowsAffected;
	}
	
//	public void getEmpList() {
//		this.connect();
//		try {
//			String query = "SELECT * FROM EMP";
//			pstmt = this.connection.prepareStatement(query);
//			rSet = pstmt.executeQuery();
//			while (rSet.next()) {
//				Long empNo = rSet.getLong("EMPNO");
//				System.out.println(empNo);
//			}
//			this.disConnect();
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	
}
