-- SELECT : 데이터 조작 (SELECT, INSERT, DELETE, UPDATE : DML)
--  Data Manipulation Language
-- CREATE : 테이블 생성 (CREATE, ALTER, DROP, TRUNCATE : DDL)
--  Data Definition Language

-- CREATE의 구조
-- 테이블명, 컬럼명이 숫자로 시작하면 안된다.
-- 특수문자 : _, $, # 사용가능하나 _ 이외에는 사용하지 말것
/*CREATE TABLE 테이블명 (
    컬럼명 (열이름) 컬럼의 자료형
    , 컬럼명 (열이름) 컬럼의 자료형
);*/

CREATE TABLE EMP_DDL (
    EMPNO NUMBER(4)
    , ENAME VARCHAR2(10)
    , JOB VARCHAR2(9)
    , MGR NUMBER(4)
    , HIREDATE DATE
    , SAL NUMBER(7,2)
    , COMM NUMBER(7,2)
    , DEPTNO NUMBER(2)
);

DESC EMP_DDL;

SELECT * FROM EMP_DDL;

-- DROP : 테이블 삭제 명령어
DROP TABLE EMP_DDL2;

-- 테이블 구조와 데이터가 동일할때
CREATE TABLE EMP_DDL2 AS 
    SELECT * FROM EMP;
    
-- 테이블 일부분 구조와 데이터가 동일할때 WHERE문으로 조건을 걸어서 저장
CREATE TABLE EMP_DDL2 AS
    SELECT * FROM EMP
        WHERE DEPTNO = 30;
    
DESC EMP_DDL2;

SELECT * FROM EMP_DDL2;

-- COMMENT : 열 데이터를 코멘트달기
    COMMENT ON COLUMN EMP_DDL2.EMPNO IS '사원번호';
    COMMENT ON COLUMN EMP_DDL2.JOB IS '직책';
    COMMENT ON COLUMN EMP_DDL2.MGR IS '직속상관';
    COMMENT ON COLUMN EMP_DDL2.HIREDATE IS '입사일';
    COMMENT ON COLUMN EMP_DDL2.HP IS '폰번호';
    
-- COMMENT : 코멘트달기
    COMMENT ON TABLE EMP_DDL2 IS '직원목록';
    
-- ALTER : 변경작업시 사용
ALTER TABLE EMP_DDL2 ADD HP VARCHAR2(13); -- 테이블에 컬럼 추가

ALTER TABLE EMP_DDL2 RENAME COLUMN HP TO TEL; -- 컬럼면 변경

ALTER TABLE EMP_DDL2 MODIFY TEL NUMBER(11); -- 컬럼 자료형 변경

ALTER TABLE EMP_DDL2 MODIFY TEL NUMBER(11) NOT NULL; -- NULL 값 불가설정

ALTER TABLE EMP_DDL2 DROP COLUMN TEL; -- 컬럼 삭제

RENAME EMP_DDL2 TO EMP_TEST; -- 테이블명 변경

-- TRUNCATE : 테이블내부 데이터 모두 삭제
TRUNCATE TABLE EMP_HW;

DROP TABLE EMP_TEST; -- 테이블 삭제


