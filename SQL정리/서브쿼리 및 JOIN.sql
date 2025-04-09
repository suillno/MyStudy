-- employees 테이블 부서명이 sales 인 부서에서
-- 근무하는 직원 중 급여가 5000 이상인 직원들의 이름과 급여를 조회

SELECT
    e.first_name
    || ' '
    || e.last_name AS name,
    e.salary
FROM
    employees e
WHERE
        salary >= 5000
    AND department_id = (
        SELECT
            department_id
        FROM
            departments
        WHERE
            department_name = 'Sales'
    );
    
-- JOIN으로
SELECT
    e.first_name
    || ' '
    || e.last_name AS name,
    e.salary
FROM
         employees e
    JOIN departments d ON e.department_id = d.department_id
WHERE
        salary >= 5000
    AND d.department_name = 'Sales';

-- EMPLOYEES 테이블에서 DEPARTMENT_ID가
-- 'IT' 또는 'HUMAN RESOURCES'인 
-- 직원들의 이름과 급여를 조회

SELECT
    e.first_name
    || ' '
    || e.last_name AS name,
    e.salary,
    e.department_id
FROM
    employees e
WHERE
    department_id IN (
        SELECT
            department_id
        FROM
            departments d
        WHERE
            department_name IN ( 'IT', 'Human Resources' )
    );
    
-- join
SELECT
    e.first_name
    || ' '
    || e.last_name AS name,
    e.salary,
    e.department_id
FROM
         employees e
    JOIN departments d ON e.department_id = d.department_id
WHERE
    d.department_name IN ( 'IT', 'Human Resources' );

-- employees 테이블에서 급여가 7000 이상 직원중
-- 그들의 부서에서 일하는 직원수가 5명 이상인 직원들의 이름과 급여를 조회 : 39

SELECT
    first_name
    || ' '
    || last_name AS name,
    salary,
    department_id
FROM
    employees
WHERE
        salary >= 7000
    AND department_id IN (
        SELECT
            department_id
        FROM
            employees
        GROUP BY
            department_id
        HAVING
            COUNT(*) >= 5
    );

/* 직급(Job ID)이 'SA_REP'인 직원들 중에서,
자신이 속한 부서의 평균 급여가 6000 이상인 부서에 소속된
직원들의 이름과 급여, 부서ID를 조회하세요. */
SELECT
    first_name
    || ' '
    || last_name AS name,
    salary,
    department_id,
    SALARY
FROM
    EMPLOYEES
WHERE JOB_ID = 'SA_REP' AND department_id IN (
SELECT department_id FROM EMPLOYEES
GROUP BY department_id
HAVING AVG(SALARY) >= 6000
);

/* 급여가 3000 이상인 직원만 포함해서,

부서별 평균 급여가 6000 이상인 부서만 출력! */

SELECT
    first_name
    || ' '
    || last_name AS name,
    salary,
    department_id
FROM
    EMPLOYEES
WHERE SALARY > 3000
AND department_id IN (
SELECT
department_id
FROM EMPLOYEES
GROUP BY department_id
HAVING AVG(SALARY) >= 6000
);

/* EMPLOYEES 테이블과 DEPARTMENTS 테이블을 이용해서,
**"부서명이 'Sales'인 부서에 소속된 직원들의 이름, 급여, 부서명"**을 조회하는 SQL 문을 작성하세요.*/
SELECT
    E.first_name
    || ' '
    || E.last_name AS name,
    E.salary,
    E.department_id
FROM
    EMPLOYEES E
JOIN DEPARTMENTS D ON e.department_id = d.department_id
WHERE D.department_NAME = 'Sales';

