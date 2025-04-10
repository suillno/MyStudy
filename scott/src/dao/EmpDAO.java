package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vo.EmpVO;

public class EmpDAO {

	/**
	 * DB 접속 URL, username, password
	 */

	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "scott";
	private static final String PW = "tiger";
	private static Connection conn = null;

	private static PreparedStatement pstmt = null; // 쿼리 실행
	private static ResultSet rSet = null; // 값 담기
	private static List<EmpVO> emp = null;

	private static int resultInt;

	private static Scanner sc = new Scanner(System.in);

	/**
	 * DB 접속
	 */
	public static void connect() {
		try { // 드라이버를 JVM에 로딩 - Oracle 데이터베이스 드라이버를 로드하는 코드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			/**
			 * DB 접속시도 ("경로", "아이디", "패스워드") jdbc : Java Database connectivity (자바에서 jdbc를
			 * 사용 선언) oracle : 오라클 데이터 베이스 사용선언 thin : 오라클에서 thin이라는 드라이버를 사용하겠다. localhost
			 * : 접속 ip 1521 : 접속 포트 xe : express edition 기본 서버명 (개인, 학습, 테스트용) 무료 버젼, 성능 제한
			 * orcl : 기업, 상업, 대규모 시스템 (유료, 고성능)
			 * 
			 * 오라클에서는 계정 > 스키마, db역활을 포함 / 물리적으로 하나의 db 인스턴스에서 동작 mysql, mssql : 공통 db안에 여러
			 * 사용자 존재
			 */

			/**
			 * Connection class DB 연결 + SQL 실행 prepareStatement(SQL문 string 형태로 작성) : SQL이
			 * 담긴 prepareStatement라는 객체 생성 createStatement() : 기본 Statement 객체 생성
			 * setAutoCommit(bool) : 자동 커밋 여부 commit() : 수동 커밋 rollback() : 수동 롤백 close() :
			 * 연결종료 (자원 반환)
			 */

			/**
			 * DriverManager : JDBC 드라이버 관리, DB 연결 생성 클래스
			 */

			// 1. DB 접속
			conn = DriverManager.getConnection(URL, ID, PW);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 접속 실패 : " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패 : " + e.getMessage());
			e.printStackTrace();
		}
	}

	// 자원반환 클로즈 명령어
	public static void connectClose() {
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

	/**
	 * 사원 몽록 출력
	 */
	public static List<EmpVO> getQuery() {
		emp = new ArrayList<>();
		// DB연결 매서드 실행
		connect();
		try {
			String query = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP"; // 쿼리문 선언

			pstmt = conn.prepareStatement(query); // 쿼리문을 입력
			rSet = pstmt.executeQuery(); // 응답받은 값을 담기

			// 3. 결과출력
			while (rSet.next()) {
				/**
				 * 컬럼 유형 문자 : getString(컬럼명) 숫자 : getLong(컬럼명), getInt(컬럼명) 소숫점 :
				 * getDouble(컬럼명), getFloat(컬럼명) 날짜 : getDate(컬럼명) boolean : getBoolean(컬럼명)
				 */
				EmpVO nEmp = new EmpVO(); // 객체 생성

				// 응답받은 값을 자료형에 담기
				Long empNo = rSet.getLong("EMPNO");
				String eName = rSet.getString("ENAME");
				String job = rSet.getString("JOB");
				Long mgr = rSet.getLong("MGR");
				Date hireDate = rSet.getDate("HIREDATE");
				Double sal = rSet.getDouble("SAL");
				Double comm = rSet.getDouble("COMM");
				Long deptNo = rSet.getLong("DEPTNO");

				// 값을 EmpVO 객체에 담기
				nEmp.setEmpNo(empNo);
				nEmp.seteName(eName);
				nEmp.setJob(job);
				nEmp.setMgr(mgr);
				nEmp.setHireDate(hireDate);
				nEmp.setSal(sal);
				nEmp.setComm(comm);
				nEmp.setDeptNo(deptNo);

				// 객체는 리스트에 저장
				emp.add(nEmp);
			}

		} catch (SQLException e) {
			System.out.println("쿼리 실행 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원반환 매서드 실행
			connectClose();
		}
		return emp;
	}

	/**
	 * 사원 목록 출력 (이름으로 검색)
	 */
	public static List<EmpVO> selectListByEname(String name) {
		connect();
		try {
			// 쿼리 입력
			String query = "SELECT * FROM EMP WHERE ENAME = ?";

			// 쿼리 등록
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);

			// 응답값 리턴
			rSet = pstmt.executeQuery();

			while (rSet.next()) { // 응답받은 값을 리스트에 입력

				EmpVO nEmp = new EmpVO(); // 객체 생성

				// 응답받은 값을 자료형에 담기
				Long empNo = rSet.getLong("EMPNO");
				String eName = rSet.getString("ENAME");
				String job = rSet.getString("JOB");
				Long mgr = rSet.getLong("MGR");
				Date hireDate = rSet.getDate("HIREDATE");
				Double sal = rSet.getDouble("SAL");
				Double comm = rSet.getDouble("COMM");
				Long deptNo = rSet.getLong("DEPTNO");

				// 값을 EmpVO 객체에 담기
				nEmp.setEmpNo(empNo);
				nEmp.seteName(eName);
				nEmp.setJob(job);
				nEmp.setMgr(mgr);
				nEmp.setHireDate(hireDate);
				nEmp.setSal(sal);
				nEmp.setComm(comm);
				nEmp.setDeptNo(deptNo);

				// 객체는 리스트에 저장
				emp.add(nEmp);
			}

		} catch (SQLException e) {
			System.out.println("쿼리 실행 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원반환 매서드 실행
			connectClose();
		}
		return emp;
	}

	/**
	 * 테이블 데이터 등록 : 메서드 호출시 값을 입력받아 등록
	 */
	public static void setQuery() {
		connect(); // DB 연결

		try {
			String query = "INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) "
					+ "VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)"; // 쿼리문 선언

			System.out.print("사원번호 : ");
			String empNo = sc.nextLine();
			System.out.print("이름 : ");
			String eName = sc.nextLine();
			System.out.print("직책 : ");
			String job = sc.nextLine();
			System.out.print("관리자 사원 번호 : ");
			String mgr = sc.nextLine();
			System.out.print("입사일 : ");
			String hireDate = sc.nextLine();
			System.out.print("급여 : ");
			String sal = sc.nextLine();
			System.out.print("성과급 : ");
			String comm = sc.nextLine();
			System.out.print("부서 번호 : ");
			String deptNo = sc.nextLine();

			pstmt = conn.prepareStatement(query); // 쿼리문을 입력
			pstmt.setString(1, empNo);
			pstmt.setString(2, eName);
			pstmt.setString(3, job);
			pstmt.setString(4, mgr);
			pstmt.setString(5, hireDate);
			pstmt.setString(6, sal);
			pstmt.setString(7, comm);
			pstmt.setString(8, deptNo);

			int resurt = pstmt.executeUpdate(); // 응답받은 값을 담기 (update는 결과가 0이면 아무 것도 안 바뀐 것, 1 이상이면 성공적으로 실행된 것)

			System.out.println(query);

			if (resurt == 1) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}

		} catch (SQLException e) {
			System.out.println("쿼리 실행 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원반환 매서드 실행
			connectClose();
		}
	}

	/**
	 * 테이블 데이터 등록2 : 값을 미리 입력받아 등록 등록할 사원 정보를 담고 있는 EmpVO 객체 영향받은 행의 갯수 리턴
	 */
	public static int insertEemp(EmpVO empvo) {
		connect(); // DB 연결
		resultInt = 0; // 응답값 저장 초기화
		try {
			// conn.setAutoCommit(false);
			
			String query = "INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, empvo.getEmpNo());
			pstmt.setString(2, empvo.geteName());
			pstmt.setString(3, empvo.getJob());
			pstmt.setLong(4, empvo.getMgr());
			pstmt.setDate(5, empvo.getHireDate());
			pstmt.setDouble(6, empvo.getSal());
			pstmt.setDouble(7, empvo.getComm());
			pstmt.setLong(8, empvo.getDeptNo());

			// 쿼리 실행 결과 : 영향받은 행의 갯수 리턴
			resultInt = pstmt.executeUpdate();
			
			// 롤백 
			// conn.rollback();
			
			// 커밋
			// conn.commit();

		} catch (SQLException e) {
			System.out.println("쿼리 실행 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원반환 매서드 실행
			connectClose();
		}
		return resultInt;
	}

	/**
	 * 사원 수정
	 * 영향받은 행 리턴
	 */
	public static int updateEmp(EmpVO empvo) {
		connect(); // DB 연결
		resultInt = 0; // 응답값 저장 초기화
		try {
			String query = " UPDATE EMP SET ENAME = ?, SAL = ? WHERE EMPNO = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empvo.geteName());
			pstmt.setDouble(2, empvo.getSal());
			pstmt.setLong(3, empvo.getEmpNo());
			
			resultInt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("쿼리 실행 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원반환 매서드 실행
			connectClose();
		}
		return resultInt;
	}

	/**
	 * 테이블 데이터 삭제
	 */
	public static void Delete() {
		connect(); // DB 연결

		try {
			System.out.print("삭제조건(1.사원번호, 2.이름) : ");
			int del = sc.nextInt();
			sc.nextLine(); // 버퍼 비우기

			String query = "";
			String delValue = "";

			if (del == 1) {
				System.out.print("사원번호를 입력해주세요 : ");
				delValue = sc.nextLine();
				query = "DELETE FROM EMP WHERE EMPNO = ?";
			} else if (del == 2) {
				System.out.print("이름을 입력해주세요 : ");
				delValue = sc.nextLine();
				query = "DELETE FROM EMP WHERE ENAME = ?";
			} else {
				System.out.println("잘못된 번호입니다.");
				return;
			}

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, delValue);

			int resurt = pstmt.executeUpdate(); // 응답받은 값을 담기 (update는 결과가 0이면 아무 것도 안 바뀐 것, 1 이상이면 성공적으로 실행된 것)

			if (resurt == 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}

		} catch (SQLException e) {
			System.out.println("쿼리 실행 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원반환 매서드 실행
			connectClose();
		}
	}

	public static int DeleteEmpno(EmpVO empvo) { // 삭제
		connect(); // DB 연결
		resultInt = 0; // 응답값 저장 초기화
		
		try {
			String query = " DELETE FROM EMP WHERE EMPNO = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, empvo.getEmpNo());
			
			resultInt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("쿼리 실행 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원반환 매서드 실행
			connectClose();
		}
		return resultInt;
	}

	public static void Login() { // 로그인 시도
		// DB접속
		connect();

		String query = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = STANDARD_HASH(?, 'SHA256')";
		Scanner sc = new Scanner(System.in);
		System.out.print("ID : ");
		String userName = sc.nextLine();
		System.out.print("PW : ");
		String password = sc.nextLine();

		try {
			PreparedStatement stmt = conn.prepareStatement(query); // 쿼리 입력받기
			stmt.setString(1, userName); // query 문에 사용한 ? 에 값 대입, DB는 1부터 배열이 시작되므로 0이아니라 1부터 사용하여야한다.
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}
		} catch (SQLException e) {
			System.out.println("쿼리 실행 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 자원반환 매서드 실행
			connectClose();
		}
	}

}
