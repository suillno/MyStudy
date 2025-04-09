-- 서브쿼리
-- 구조
SELECT * FROM 테이블명
WHERE 컬럼명 = (SELECT * FROM 테이블명);

-- 서브쿼리를 모를경우 존스의 월급을 찿고 
SELECT SAL FROM EMP
WHERE ENAME = 'JONES';

-- 그 월급보다 높은값을 겁색해야함
SELECT * FROM EMP
WHERE SAL > 2975;

-- 서브쿼리를 사용할경우 한개의 SELECT문 안에 조건을 한번더
-- SELECT문을 사용하여 준다 이경우 ORDER BY 정렬은 불가능하다
-- 또한 서브쿼리의 값이 1행만 출력되야만 사용가능하다 2행이상일경우 오류발생
SELECT * FROM EMP
WHERE SAL > (
        SELECT SAL FROM EMP
        WHERE ENAME = 'JONES');
        
-- 이름이 ALLEN인 사원의 추가 수당보다 많이 받는 사원정보 출력
SELECT * FROM EMP
WHERE COMM > (
        SELECT COMM FROM EMP
        WHERE ENAME = 'ALLEN');
        
-- 조인 상황에서 서브쿼리 사용
SELECT * FROM EMP E
INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO
WHERE E.DEPTNO = 20 AND E.SAL > (SELECT AVG(SAL) FROM EMP)
;

-- 부서번호 20, 30 인것만 출력
SELECT * FROM EMP E
INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO
WHERE E.DEPTNO IN (20,30) AND E.SAL > (SELECT AVG(SAL) FROM EMP)
;

-- 부서별 최고금여를 받는 사람 출력
-- 행이2개이상 출력시 IN 사용
SELECT * FROM EMP E
JOIN DEPT D ON e.deptno = d.deptno
-- 부서를 그룹으로 묶고 그룹중 최고 급여 출력
WHERE SAL IN (SELECT MAX(SAL) FROM EMP
    GROUP BY DEPTNO);
    
-- 서브쿼리 + UNION ALL + DUAL
-- IN을 미사용할시 행을 1개 밖에 못가져오므로 
-- DUAL은 오라클에서 1개의 행을 가지는 임시 테이블로, 상수값을 선택할 때 사용됨
-- 단일값 비교(=)는 여러 결과를 처리하지 못하므로 주의 필요
SELECT * FROM EMP
WHERE DEPTNO = (
    SELECT DEPTNO FROM DUAL WHERE DEPTNO = 10
    UNION ALL
    SELECT DEPTNO FROM DUAL WHERE DEPTNO = 20
);


-- EMPLOYEES 테이블에서 급여가 DEPARTMENTS 테이블의 IT 부서 보다많은
-- 평균 급여 이상인 직원들의 이름과 급여 조회
SELECT * FROM EMPLOYEES E
JOIN departments D ON d.department_id = e.department_id
WHERE e.salary >= (
    SELECT AVG(SALARY) FROM EMPLOYEES A
    WHERE D.DEPARTMENT_NAME = 'IT'
    );
    
