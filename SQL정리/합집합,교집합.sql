-- 추가 select문 합집합 교집합
-- UNION 결과를 합해서 묶는다. 중복은 X 두개의 테이블을 결과를 하나로 합침 대신 컬럼이 동일해야함
-- UNION ALL : 유니온과 동일하나 중복 O
-- MINUS : 우선작성한 쿼리의 결과중 나중에 작성한 쿼리에서 없는 데이터만 출력
-- INTERSECT : 교집합 두개의 태이블 전부다 있는 값만 출력
SELECT * FROM EMP
WHERE DEPTNO IN (10, 20);

SELECT EMPNO, ENAME, DEPTNO FROM EMP
WHERE DEPTNO = 10
UNION
SELECT EMPNO, ENAME, DEPTNO FROM EMP
WHERE DEPTNO = 20;

-- 부서번호가 10인 부서의 급여 평균
-- 부서번호가 20인 부서의 급여 평균

SELECT 10 AS DEPTNO, AVG(SAL) FROM EMP WHERE DEPTNO = 10
UNION
SELECT 20, AVG(SAL) FROM EMP WHERE DEPTNO = 20
UNION
SELECT 30, AVG(SAL) FROM EMP WHERE DEPTNO = 30;

-- GROP BY로 처리
-- 특정그룹을 기준으로 평균값 구하기
SELECT AVG(SAL), DEPTNO FROM EMP WHERE DEPTNO IN (10,20) group by DEPTNO
ORDER BY DEPTNO;

-- HAVING : 그룹화한 결과의 범위 제한
-- WHERE의 경우 컬럼에대한 결과 필터링이어서 그룹화된 값 필터링은 불가하다
SELECT AVG(SAL), DEPTNO, JOB FROM EMP GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000;
