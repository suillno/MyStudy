-- PL / SQL , 프로시저

DECLARE
	실행시 필요한 요소 선언 (변수선언 및 값 대입)
BEGIN
	쿼리 명령어 작성
EXCEPTION
	오류 처리
END;


-- 실행결과 로그창에 출력
SET SERVEROUTPUT ON; 

-- DBMS_OUTPUT 해당값 출력
BEGIN
	DBMS_OUTPUT.PUT_LINE('Hello World');
END;
/

-- 변수 선언 및 값 대입
-- CONSTANT : 상수선언
DECLARE
    V_EMPNO NUMBER(4) := 7788;
    V_ENAME VARCHAR2(10) NOT NULL DEFAULT '학원';
    V_TAX CONSTANT NUMBER(1) := 3;
    -- 식별자는 중복불가, 대소문자 구별 안함, 숫자작 불가,
    -- 특수문자 불가 $#_ 제외
    -- 숫자 NUBER
    -- 문자 VARCHAR2, CHAR
    -- 날짜 DATE
    -- 논리 BOOLEAN : true, false, null
    /*
    참조형 : 
    변수명 테이블명.컬럼명%TYPE
    */
    V_DEPTNO DEPT.DEPTNO%TYPE := 50;
    /* 
    행 전체구조 참조 : 
    변수명 테이블명%ROWTYPE
    */
    V_DEPT_ROW DEPT%ROWTYPE;
BEGIN
    SELECT DEPTNO, DNAME, LOC INTO V_DEPT_ROW
    FROM DEPT WHERE DEPTNO = 40;
    DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || V_DEPT_ROW.DEPTNO);
    DBMS_OUTPUT.PUT_LINE('DNAME : ' || V_DEPT_ROW.DNAME);
    DBMS_OUTPUT.PUT_LINE('LOC : ' || V_DEPT_ROW.LOC);
END;
/


-- IF ELSE 사용
DECLARE
    V_NUMBER NUMBER := 12;
BEGIN
 /*
    IF 조건 THEN
    IF 조건 THEN-ELSE
    IF 조건 THEN-ELSIF
    IF 조건식 THEN 수행문;
    END IF;
    */
    IF V_NUMBER >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('A');
    ELSIF V_NUMBER >= 80 THEN
        DBMS_OUTPUT.PUT_LINE('B');
    ELSE
        DBMS_OUTPUT.PUT_LINE('누락');
    END IF;
END;
/

-- CASE 사용 : 값이 딱 떨어져야함
DECLARE
    V_NUMBER NUMBER := 12;
BEGIN
    CASE TRUNC(V_NUMBER / 10)
        WHEN 10 THEN DBMS_OUTPUT.PUT_LINE('A');
        WHEN 9 THEN DBMS_OUTPUT.PUT_LINE('A');
        WHEN 8 THEN DBMS_OUTPUT.PUT_LINE('B');
        ELSE DBMS_OUTPUT.PUT_LINE('누락');
    END CASE;
END;
/

-- 반복문
/*
LOOP
    반복할 내용
    EXIT WHEN 조건
END LOOP;
*/
DECLARE
    V_NUM NUMBER := 0;
BEGIN
    LOOP
    DBMS_OUTPUT.PUT_LINE('V_NUM : ' || V_NUM);
    V_NUM := V_NUM + 1;
    EXIT WHEN V_NUM > 4;
    /*
    IF V_NUM > 4 THEN
        EXIT;       IF문으로 반복문 종료선언도 가능
    */
    END LOOP;
END;
/

-- WHILE 문
DECLARE
    V_NUM NUMBER := 0;
BEGIN
    WHILE V_NUM < 4 LOOP -- WHILE은 조건을 미리 선언
    DBMS_OUTPUT.PUT_LINE('V_NUM : ' || V_NUM);
    V_NUM := V_NUM + 1;
    END LOOP;
END;
/

-- FOR 문
BEGIN
    /* FOR i IN 시작값..종료값 LOOP
        반복할 작업; REVERSE
    END LOOP; */
    FOR i IN 0 .. 9 LOOP -- IN 이후에 REVERSE 조건을 추가하면 역으로 순회
        CONTINUE WHEN MOD(i,2) = 1; -- 조건이 참일경우 건너뜀
        DBMS_OUTPUT.PUT_LINE(i);
    END LOOP;
END;
/

-- cursor 커서 : 오라클에서 SELECT 문의 결과를 한 행씩 처리할때 사용
/*
    커서의 종류
    암시적 커서 (Implict Cursor) : SELECT INTO, INSERT, UPDATEM DELETE등 오라클이 자동실행
    명시적 커서 (Explict Cursor) : 프로그래머가 직접 선언하고 사용
    커서 for 루프 (Cusor FOR Loop) : 커서 열고 FETCH하고 닫는 과정을 자동으로 처리
    1. 커서 선언 : CURSOR 커서명 IS SELECT * FROM EMP;
    2. 커서 열기 : OPEN 커서명;
    3. 반복 작업 : FETCH 커서명 INTO 변수들;
    4. 커서 닫기 : CLOSE 커서명;
*/
DECLARE
    CURSOR c IS SELECT ENAME, SAL FROM EMP; -- 커서 선언
    V_ENAME EMP.ENAME%TYPE; -- 자료형 선언을 해야하므로 EMP 태이블의 ENAME TYPE을 참조설정
    V_SAL EMP.SAL%TYPE;
BEGIN
    OPEN c;
    LOOP
        FETCH c INTO V_ENAME, V_SAL; -- 선언에서 사용한 변수의 동일하게 선언해야함
        EXIT WHEN c%NOTFOUND; -- c의 커서가 더이상 자료가 없을때 빠져나감
        DBMS_OUTPUT.PUT_LINE(V_ENAME || ' : ' || V_SAL);
    END LOOP;
    CLOSE c;
END;
/

-- 프로시저를 매서드처럼 호출가능하게 만들기
-- CREATE OR REPLACE PROCEDURE 프로시저명(변수값을 받을때) IS
CREATE OR REPLACE PROCEDURE PRINT_EMP_DATA(P_DEPTNO IN NUMBER) IS
    CURSOR c IS SELECT ENAME, SAL FROM EMP WHERE DEPTNO = P_DEPTNO; -- 커서 선언
    V_ENAME EMP.ENAME%TYPE; -- 자료형 선언을 해야하므로 EMP 태이블의 ENAME TYPE을 참조설정
    V_SAL EMP.SAL%TYPE;
BEGIN
    OPEN c;
    LOOP
        FETCH c INTO V_ENAME, V_SAL; -- 선언에서 사용한 변수의 동일하게 선언해야함
        EXIT WHEN c%NOTFOUND; -- c의 커서가 더이상 자료가 없을때 빠져나감
        DBMS_OUTPUT.PUT_LINE(V_ENAME || ' : ' || V_SAL);
    END LOOP;
    CLOSE c;
END;
/

-- 매서드형태로 만든 프로시저 호출
EXEC PRINT_EMP_DATA(10);
-- DBever 사용시
CALL PRINT_EMP_DATA();

-- 프로시저에 값입력후 호출시 EMP 태이블에 데이터 입력
CREATE OR REPLACE PROCEDURE INSERT_EMP (
    P_EMPNO EMP.EMPNO%TYPE,
    P_ENAME EMP.ENAME%TYPE,
    P_JOB EMP.JOB%TYPE,
    P_MGR EMP.MGR%TYPE,
    P_HIREDATE EMP.HIREDATE%TYPE,
    P_SAL EMP.SAL%TYPE,
    P_COMM EMP.COMM%TYPE,
    P_DEPTNO EMP.DEPTNO%TYPE
) IS
BEGIN
    INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
    VALUES (P_EMPNO, P_ENAME, P_JOB, P_MGR, P_HIREDATE, P_SAL, P_COMM, P_DEPTNO);
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('성공');
    
    EXCEPTION WHEN OTHERS THEN ROLLBACK; -- 값입력 실패시 롤백
    
    DBMS_OUTPUT.PUT_LINE('오류');
END;
/

-- 프로시저 호출 사용
EXEC INSERT_EMP(9999, 'NAME', 'JOB', 7902, '2020-01-01', 800, 100, 20);