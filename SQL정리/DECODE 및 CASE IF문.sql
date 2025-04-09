-- DECODE(컬럼이름, 값, 결과, 값, 결과, ......): 쌍을 이루어 IF문

-- CASE : CASE 컬럼이름
--          WHEN 값 THEN 결과
--          WHEN 값 THEN 결과
--          WHEN 값 THEN 결과
--          END 

-- DECODE 를 사용한 IF 문
SELECT  
    EMPNO, ENAME, JOB, SAL,
    DECODE( JOB, 'MANAGER', SAL * 1.1 
            , 'SALESMAN', SAL * 1.05
            , 'ANALIST', SAL
            , SAL * 1.03 
            ) AS SAL
FROM EMP;

-- CASE 문을 사용한 IF 문
SELECT  
    EMPNO, ENAME, JOB, SAL, COMM
-- 1번째 형식 
    , CASE JOB
        WHEN 'MANAGER' THEN SAL * 1.1
        WHEN 'SALESMAN' THEN SAL * 1.05
        WHEN 'ANALIST' THEN SAL
        ELSE SAL * 1.03
        END AS SAL3
-- 2번째 형식
     , CASE 
        WHEN COMM IS NULL THEN '해당없음'
        WHEN COMM = 0 THEN '수당없음'
        WHEN COMM > 0 THEN '수당 : ' || COMM
        END AS COMM_TEXT
FROM EMP;

SELECT  
    EMPNO, ENAME, JOB, SAL

FROM EMP;