/*
데이터 사전 : 데이터 딕셔너리(Data Dictionary)
USER_xxxxx : DB 접속한 사용자가 소유한 객체 정보
ALL_XXXXX : DB 접속한 사용자가 소유한 객체 또는 다른 사용자가 소유한 객체 중 사용 허가를 받은 객체 정보
DBA_XXXXX : DB 관리에 관련된 정보 (관리권한 필요)
V$_XXXXX : DB 성능정보
*/

-- 모든 데이터 딕셔너리 뷰 목록을 확인
SELECT * FROM dictionary;

SELECT * FROM dictionary WHERE TABLE_NAME = 'ALL_TABLES';

-- 모든 테이블명 출럭
SELECT * FROM USER_TABLES;

-- 사용가능한 모든 태이블 조회
SELECT * FROM ALL_TABLES;

-- DB 관리에 관련된 정보
SELECT * FROM DBA_TABLES;