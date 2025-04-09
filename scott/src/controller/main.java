package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.EmpVO;

public class main {
	
	// DB 접속경로, ID, PW 는 계속써야하므로 상수선언
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "scott";
	private static final String PW = "tiger";
	
	private static Connection conn = null;
	private static PreparedStatement pstmt = null; // 쿼리 실행
	private static ResultSet rSet = null; // 값 담기
	private static List<EmpVO> emp = new ArrayList<EmpVO>();

	public static void main(String[] args) {
		/**
		 * 1. DB 연결 설정
		 * 2. 객채 생성
		 * 3. SELECT 해보기
		 * 4. SELECT 파라미터 넣기
		 * 5. INSERT 해보기
		 * 6. UPDATE 해보기
		 * 7. DELETE 해보기
		 */
		
		/**
		 * DB 접속
		 * URL, username, password
		 */
		try { // 드라이버를 JVM에 로딩 - Oracle 데이터베이스 드라이버를 로드하는 코드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			/**
			 * DB 접속시도 ("경로", "아이디", "패스워드")
			 * jdbc : Java Database connectivity (자바에서 jdbc를 사용 선언)
			 * oracle : 오라클 데이터 베이스 사용선언
			 * thin : 오라클에서 thin이라는 드라이버를 사용하겠다.
			 * localhost : 접속 ip
			 * 1521 : 접속 포트
			 * xe : express edition 기본 서버명 (개인, 학습, 테스트용) 무료 버젼, 성능 제한
			 * orcl : 기업, 상업, 대규모 시스템 (유료, 고성능)
			 * 
			 * 오라클에서는 계정 > 스키마, db역활을 포함 / 물리적으로 하나의 db 인스턴스에서 동작
			 * mysql, mssql : 공통 db안에 여러 사용자 존재
			 */
			
			/**
			 * Connection class
			 * DB 연결 + SQL 실행
			 * prepareStatement(SQL문 string 형태로 작성) : SQL이 담긴 prepareStatement라는 객체 생성
			 * createStatement() : 기본 Statement 객체 생성
			 * setAutoCommit(bool) : 자동 커밋 여부
			 * commit() : 수동 커밋
			 * rollback() : 수동 롤백
			 * close() : 연결종료 (자원 반환)
			 */
			
			/**
			 * DriverManager : JDBC 드라이버 관리, DB 연결 생성 클래스
			 */
			
			//1. DB 접속
			conn = DriverManager.getConnection(URL, ID, PW);
			
			//2. 쿼리 실행
			// 값 오류 방지를위해 초기값 설정
			
			
			String query = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP"; // 쿼리문 선언
			
			pstmt = conn.prepareStatement(query); // 쿼리문을 입력
			rSet = pstmt.executeQuery(); // 응답받은 값을 담기
			
			//3. 결과출력
			while(rSet.next()) {
				/**
				 * 컬럼 유형
				 * 문자 : getString(컬럼명)
				 * 숫자 : getLong(컬럼명), getInt(컬럼명)
				 * 소숫점 : getDouble(컬럼명), getFloat(컬럼명)
				 * 날짜 : getDate(컬럼명)
				 * boolean : getBoolean(컬럼명)
				 */
				Long empNo = rSet.getLong("EMPNO");
				String eName = rSet.getString("ENAME");
				String job = rSet.getNString("JOB");
				Long mgr = rSet.getLong("MGR");
				Date hireDate = rSet.getDate("HIREDATE");
				Double sal = rSet.getDouble("SAL");
				Double comm = rSet.getDouble("COMM");
				Long deptNo = rSet.getLong("DEPTNO");
				EmpVO nEmp = new EmpVO();
				nEmp.setEmpNo(empNo);
				nEmp.seteName(eName);
				nEmp.setJob(job);
				nEmp.setMgr(mgr);
				nEmp.setHireDate(hireDate);
				nEmp.setSal(sal);
				nEmp.setComm(comm);
				nEmp.setDeptNo(deptNo);
				emp.add(nEmp);
			}
			
			// 리스트를 돌아 출력
			for(EmpVO tEmp : emp) {
				System.out.println(tEmp);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 못 찿았다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (rSet != null) rSet.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}


}