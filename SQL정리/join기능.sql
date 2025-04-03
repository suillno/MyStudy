-- JOIN : 두개 이상의 테이블을 연결하여 하나의 테이블처럼 출력한다

-- 등가 조인 (INNER JOIN) 
SELECT 
	A.EMPNO, A.ENAME, B.DEPTNO -- 출력하고싶은 컬럼명 입력
FROM EMP A, DEPT B -- EMP, DEPT 연결하여 출력 변수명을 정하여 사용할수있음
WHERE A.DEPTNO = B.DEPTNO -- DEPTNO 가 동일하게 맞춰 출력
	AND A.SAL >= 3000 -- 추가조건문
ORDER BY EMPNO -- EMPTNO 오름차순 정렬
;

-- 현실적인 사용법
SELECT A.EMPNO, A.ENAME, B.DEPTNO -- 출력하고싶은 컬럼명 입력
FROM EMP A -- EMP 테이블
INNER JOIN DEPT B ON A.DEPTNO = B.DEPTNO -- DEPTNO 가 동일하게 맞춰 출력
WHERE A.SAL >= 3000 -- 추가조건문
ORDER BY EMPNO -- EMPTNO 오름차순 정렬

-- 외부조인 (OUTER JOIN)
-- 테이블내 비교하여 출력
SELECT  
A.EMPNO, A.ENAME, B.EMPNO, B.ENAME
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+) -- 직속상관 번호와 내 번호가 일치하는값이 있는것만 출력 (+) 입력시 조건에 없는 A의 값 전부출력
ORDER BY A.EMPNO
; -- 이너조인을 사용할 경우 직속상관이 없는 사장은 출력이 안되는 오류가 발생함

--실무 사용
SELECT A.EMPNO, A.ENAME, B.EMPNO, B.ENAME
FROM EMP A
LEFT OUTER JOIN EMP B ON A.MGR = B.EMPNO -- 비교하는 왼쪽 테이블을 주테이블로하여 A의 상사번호와 B의 사원번호가 일치할때와 A테이블의 전체데이터를 출력한다
ORDER BY A.ENAME
;

-- INTER JOIN 일치하는 값만 출력
-- OUTER JOIN 일치하는 값도 출력하고 주테이블의 데이터를 전부 출력한다

-- 표준 문법
-- NATURAL JOIN
-- EMP, DEPT 
SELECT 
E.EMPNO, E.ENAME, E.JOB, E.HIREDATE, E.SAL, E.COMM
,DEPTNO, D.DNAME, D.LOC
FROM EMP E
NATURAL JOIN DEPT D
ORDER BY E.EMPNO;

-- 실사용 예제
SELECT -- 동일한 조건을 기준으로 데이터 출력
E.EMPNO, E.ENAME, E.JOB, E.HIREDATE, E.SAL, E.COMM
,DEPTNO, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D USING (DEPTNO) -- FROM EMP E JOIN DEPT D ON (E.DEPTNO = D.DEPTNO)
ORDER BY E.EMPNO;