package main;

public class 데이터베이스 {

	public static void main(String[] args) {
		// 설치 프로그램
		// 오라클 21c xe 다운
		// pass : root
		// SQL Developer : Windows 32-bit/64-bit
		// DBeaver
		
		/**
		 * sql 명령어
		 * 접속 : sqlplus sys/oracle as sysdba
		 * 아이디생성 조건 변경: alter session set "_oracle_script"=true;
		 * 아이디생성 : create user scott identified by tiger default tablespace users quota unlimited on users;
		 * 권한부여 :  grant create session, create table to scott;
		 * 아이디 접속 :  conn scott/tiger ==> conn 아이디/패스워드
		 * 세션변경 : alter session set "_oracle_script"=true;
		 * 			alter session set nls_date_language='american';
		 * 			alter session set nls_date_format='dd-MON-rr';
		 * 파일연결 : @c:\scott.sql = > @경로\파일명
		 * 연결확인 : desc emp; / desc dept; / desc salgrade;
		 */
		
		/**
		 * SQL디벨로퍼
		 * 접속후 JDK 설치위치 설정
		 */
		
		/**
		 * SQL 명령어의 종류 DQL(Data Query Language) : RDBMS에 저장한 테이터를 원하는 방식으로 조회하는 명령어
		 * DML(Data Manipulation Language) : RDBMS내 테이블의 데이터를 저장, 수정, 삭제 하는 명령어 DDL(Data
		 * Definition Language) : RDBMS내 데이터 관리를 위헤 테이블을 포함한 여러 객체를 생성,수정,삭제 하는 명령어
		 * TCL(Transaction Control Language) : 트랜잭션 데이터의 영구 저장, 취소 등과 관련된 명령어 DCL(Data
		 * Control Language) : 데이터 사용 권한과 관련된 명령어
		 */

		/**
		 * 관계형 데이터베이스의 구성요소 테이블이 중심이고, 그 안에 **행(레코드)**과 **열(필드)**이 있음
		 * **키(Primary, Foreign)**를 통해 데이터 간 관계 설정
		 * 키 ==> 기본키, 
		 * 
		 * 스키마는 전체 구조를 정의
		 * 
		 * 뷰, 인덱스, 제약 조건은 효율성과 무결성을 위해 사용됨
		 */
	}

}
