-- 부서별 평균 급여보다 많이 받는 직원 조회 - 부서를 그룹으로 지정하면 해당그룹을 기준으로 정리된다.
SELECT
    a.employee_id
    , a.first_name
    , a.last_name
    , a.salary
    , B.avg_sal
FROM
         employees a
    JOIN (
        SELECT
            AVG(salary) AS avg_sal
            , department_id
        FROM
            employees
        GROUP BY
            department_id
    ) b ON a.department_id = B.department_id
    WHERE a.salary > B.avg_sal;

-- WITH (Subquery Factoring) : 복잡한 쿼리에서 공통으로 사용되는
--      서브쿼리 또는 중간결과를 한번 정의하고 여러번 사용할수 있게
--      해주는 기능, with로 정의된 서브쿼리는 임시 테이블처럼 사용 가능

WITH 서브쿼리명 AS (쿼리)
SELECT * FROM 테이블;

WITH avg_salary AS (
    SELECT department_id,AVG(salary) AS AVG_SAL FROM employees GROUP BY department_id
)
SELECT * FROM employees A, avg_salary B
WHERE A.SALARY > B.AVG_SAL AND A.department_id = B.department_id