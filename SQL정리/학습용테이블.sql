-- 주석
-- DEPT : 부서정보
-- DEPTNO : 부서번호 / 소수점없는 2자리 숫자
-- DNAME : 부서이름 / 14바이트의 가변형 문자열
-- LOC : 부서가 위치한 지역 / 13바이트의 가변경 문자열

-- EMP : 사원정보
-- EMPNO : 사원번호 / 소수점없는 4자리 숫자
-- ENAME : 이름 / 10바이트 크기의 가변형 문자열
-- JOB : 직책 / 9바이트 크기의 가변형 문자열
-- MGR : 직속상관사원번호 / 소수점없는 4자리숫자
-- HIREDATE : 입사일 / 날짜형식
-- SAL : 급여 / 소수2자리포함하는 7자리 숫자
-- COMM : 급여외 수당 / 소수2자리포함하는 7자리 숫자
-- DEPTNO 사원이 속한 부서 / 2자리 숫자

-- SALGRADE : 급여등급
-- GRADE : 급여 등급 / 숫자
-- LOSAL : 급여의 최소 금액 / 숫자
-- HISAL : 급여의 최대 금액 / 숫자

-- SALGRADE : 각 사원의 판매량
SELECT
    *
FROM
    emp