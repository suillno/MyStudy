-- 최소 급여가 10000보다 큰 일자리의 세부 정보를 표시합니다.

SELECT 
*
FROM JOBS
WHERE min_salary > 10000;

-- 2002년부터 2005년 사이에 입사한 직원의 이름과 입사일을 표시하세요.

SELECT
-- 유저네임 합치기
CONCAT(FIRST_NAME,CONCAT(' ', LAST_NAME)) AS NAME, 
FIRST_NAME || ' ' || LAST_NAME AS NAME2,
HIRE_DATE,
-- 년도만 CHAR 형태로 자르기
TO_CHAR(HIRE_DATE, 'YYYY') AS DATE2
FROM EMPLOYEES 
-- 날짜를 년도만 비교하면되니 년도를 CHAR로 잘라 BETWEEN 명령문으로 비교해준다
WHERE TO_CHAR(HIRE_DATE, 'YYYY') BETWEEN '2002' AND '2005'
ORDER BY HIRE_DATE;

-- 직원들중 직군이 영업사원(SA_MAN) 또는 프로그래머(IT_PROG)
-- FIRST_NAME, HIRE_DATE 출력

SELECT
FIRST_NAME,
HIRE_DATE,
JOB_ID
FROM EMPLOYEES 
--WHERE JOB_ID = 'SA_MAN' OR JOB_ID = 'IT_PROG';
-- JOB_ID 열 안에 있는 문자 검색
WHERE JOB_ID IN ('SA_MAN' ,'IT_PROG');

-- 100단위의 급여를 반올림하여 출력하라
-- FIRST_NAME, MIN_SALARY, 반올림 한 SALARY로 출력

SELECT 
FIRST_NAME,
ROUND(SALARY, -3) AS SALARY
FROM EMPLOYEES
ORDER BY SALARY;

-- 사원들의 성이 S로 시작하거나 이름이 S로 시작하는 데이터 출력

SELECT
*
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'S%' OR LAST_NAME LIKE 'S%' ORDER BY employee_id;
-- WHERE FIRST_NAME LIKE '%' || 변수명 || '%' 변수명을 조건으로 검색할때

-- 수수료 비율이 null 이고 급여가 있는 직원 중
-- 급여의 범위가 5000~10000이고
-- 부서코드가 100인 데이터 출력
SELECT
*
FROM employees
-- commission_pct이 null 값 과 동일하고, salary 값이 5000에서 10000사이이고 department_id 가 100일때
WHERE commission_pct IS null AND salary BETWEEN 5000 AND 10000
AND department_id = 100;

-- jobs 테이블에서 job_title의 첫번째 단어만 출력
-- 예 : purchasing clerk --> purchasing
-- NVL, NVL2
-- NVL(컬럼, 0) NULL 일때 0, NULL이 아닐때 컬럼   
-- NVL2(컬럼, 0, 1) : NULL 일때 0, NULL이 아닐때 1


SELECT 
-- NULL일때 1, 문자열을 첫째자리부터 빈공간이 나올시 뒤의 문자열을 전부자른다
NVL(SUBSTR(job_title, 1,INSTR(job_title, ' ') -1),1) AS STR,
NVL2(SUBSTR(job_title, 1,INSTR(job_title, ' ') -1),1,2) AS STR2
FROM JOBS;


-- COUNTRIES, LOCATIONS, DEPARTMENTS 테이블을 이용해서
-- 국가 이름, 도시 및 부서 이름을 출력
SELECT 
c.country_name, l.CITY, d.department_name
FROM COUNTRIES C
INNER JOIN LOCATIONS L ON C.COUNTRY_ID = L.COUNTRY_ID
INNER JOIN DEPARTMENTS D ON L.LOCATION_ID = d.LOCATION_ID
;

-- EMPLOYEES 에는 사원의 정보
-- JOB_HISTORY 에는 이전 직장의 이력
-- EMPLOYEES_ID 값을 JOIN해서 이전 직장의 퇴사일과
-- EMPLOYEES_ID, FIRST_NAME 을 출력 (결과 7행)
SELECT 
--MAX 최대값 추출후 중복삭제
J.employee_id, E.FIRST_NAME, MAX(J.END_DATE) AS END
FROM EMPLOYEES E
INNER JOIN JOB_HISTORY J ON E.EMPLOYEE_ID = J.EMPLOYEE_ID
-- J.employee_id, E.FIRST_NAME을 기준으로 중복되는 값을 하나로 묶기
GROUP BY j.employee_id, e.first_name
ORDER BY END;

-- 각 직원이 관리하는 부하 직원 수를 구하되
-- 부하 직원이 한 명도 없는 직원도 결과에 포함되게 출력

SELECT
-- COUNT 부하직원의 수 (조인된 행 수를 셈)
E.employee_id,S.manager_id, E.FIRST_NAME, COUNT(s.employee_id) AS NUM
FROM EMPLOYEES E
-- 조건: S의 manager_id가 E의 employee_id와 같을 경우 (즉, E가 S의 매니저일 경우)
LEFT OUTER JOIN EMPLOYEES S ON S.manager_id = E.employee_id
group by E.employee_id, S.manager_id,E.FIRST_NAME
-- NUM을 역순으로 정렬
ORDER BY NUM DESC
;

-- 평균 급여보다 많은 급여를
-- 받는 직원들 중, 가장 최근에 입사한
-- 직원의 이름, 입시일, 급여를 출력

SELECT
    first_name || ' ' || last_name,
    hire_date,
    salary
FROM employees
    WHERE salary > (SELECT AVG(salary) FROM employees)
    AND hire_date = (SELECT MAX(HIRE_DATE) FROM employees 
    WHERE salary > (SELECT AVG(salary) FROM employees))
;

-- 자신의 매니저보다 더 많은 급여를 받는 직원의
-- 이름, 급여, 매니저이름, 매니저 급여 출력

SELECT
    s.first_name || ' ' || s.last_name AS MY
    , s.salary
    , E.first_name || ' ' || E.last_name AS MANAGER
    , e.salary
    FROM employees E
    JOIN employees S ON e.employee_id = s.manager_id 
    WHERE e.salary < s.salary;

-- 사원 테이블에서 사원번호, 사원명, 입사일,
-- 자신보다 먼저 입사한 직원수를 출력

SELECT
    E.FIRST_NAME
    , E.HIRE_DATE
    , (SELECT COUNT(*) FROM employees D WHERE d.hire_date < e.hire_date) AS ESF
FROM employees E;

    
