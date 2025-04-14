-- 부서별 평균 급여보다 많이 받는 직원 조회 - 부서를 그룹으로 지정하면 해당그룹을 기준으로 정리된다.
SELECT
    a.employee_id,
    a.first_name,
    a.last_name,
    a.salary,
    b.avg_sal
FROM
         employees a
    JOIN (
        SELECT
            AVG(salary) AS avg_sal,
            department_id
        FROM
            employees
        GROUP BY
            department_id
    ) b ON a.department_id = b.department_id
WHERE
    a.salary > b.avg_sal;

-- WITH (Subquery Factoring) : 복잡한 쿼리에서 공통으로 사용되는
--      서브쿼리 또는 중간결과를 한번 정의하고 여러번 사용할수 있게
--      해주는 기능, with로 정의된 서브쿼리는 임시 테이블처럼 사용 가능

WITH 서브쿼리명 AS (쿼리)
SELECT
    *
FROM
    테이블;

WITH avg_salary AS (
    SELECT
        department_id,
        AVG(salary) AS avg_sal
    FROM
        employees
    GROUP BY
        department_id
)
SELECT
    *
FROM
    employees  a,
    avg_salary b
WHERE
        a.salary > b.avg_sal
    AND a.department_id = b.department_id;

-- 직원수가 5명 이상인 부서의 부서 ID와 직원수 조회
--일반 쿼리
SELECT
    department_id,
    emp_cnt
FROM
    (
        SELECT
            department_id,
            COUNT(*) AS emp_cnt
        FROM
            employees
        GROUP BY
            department_id
    )
WHERE
    emp_cnt >= 5;

-- WITH 쿼리
WITH counts AS (
    SELECT
        department_id,
        COUNT(*) AS emp_cnt
    FROM
        employees
    GROUP BY
        department_id
)
SELECT
    department_id,
    emp_cnt
FROM
    counts
WHERE
    emp_cnt >= 5;


-- 가장 많은 부하를 둔 매니저 ID 조회
SELECT
    manager_id,
    cnt
FROM
    (
        SELECT
            manager_id,
            COUNT(*) AS cnt
        FROM
            employees
        WHERE
            manager_id IS NOT NULL
        GROUP BY
            manager_id
    )
WHERE
    cnt = (
        SELECT
            MAX(cnt)
        FROM
            (
                SELECT
                    manager_id,
                    COUNT(*) AS cnt
                FROM
                    employees
                WHERE
                    manager_id IS NOT NULL
                GROUP BY
                    manager_id
            )
    );

-- 카운터후 그 카운터 숫자의 맥스값을 찿아 표기
WITH manager_counts AS (
    SELECT
        manager_id,
        COUNT(*) AS cnt
    FROM
        employees
    WHERE
        manager_id IS NOT NULL
    GROUP BY
        manager_id
),
max_mgr AS (
    SELECT
        MAX(cnt) AS max_cnt
    FROM
        manager_counts
)
SELECT
    m.manager_id,
    m.cnt
FROM
         manager_counts m
    JOIN max_mgr b ON m.cnt = b.max_cnt;


-- 부서별로 입사일이 가장 빠른 직원 조회

SELECT
    *
FROM
    employees
WHERE
    hire_date IN (
        SELECT
            MIN(hire_date) AS min_date
        FROM
            employees
        WHERE
            department_id IS NOT NULL
        GROUP BY
            department_id
    );

WITH min_dates AS (
    SELECT
        MIN(hire_date) AS min_date,
        department_id
    FROM
        employees
    WHERE
        department_id IS NOT NULL
    GROUP BY
        department_id
)
SELECT
    *
FROM
         employees a
    JOIN min_dates b ON a.department_id = b.department_id
WHERE
    a.hire_date = b.min_date;


-- 각 매니저 밑에서 가장 오래일한 직원
WITH max_manager_date AS (
    SELECT
        manager_id,
        MIN(hire_date) AS min_date
    FROM
        employees
    WHERE
        manager_id IS NOT NULL
    GROUP BY
        manager_id
)
SELECT
    *
FROM
         employees a
    JOIN max_manager_date b ON a.manager_id = b.manager_id
WHERE
    a.hire_date = b.min_date;
    
    
    
SELECT B.manager_id, B.hire_date FROM (
    SELECT
        manager_id,
        MIN(hire_date) AS min_date
    FROM
        employees
    WHERE
        manager_id IS NOT NULL
    GROUP BY
        manager_id
) A JOIN employees B ON B.MANAGER_ID = A.MANAGER_ID
WHERE B.HIRE_DATE = A.MIN_DATE;
