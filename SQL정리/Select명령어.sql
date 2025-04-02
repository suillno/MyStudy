--SELECT

-- SELECT 조회할 열(컬럼) 이름, 이름..... 
-- FROM 테이블이름;

SELECT
    empno -- 사원번호
    , ename -- 사원명
    , mgr -- 직속상관 사원번호
    , sal -- 급여
    , comm -- 급여외수당
FROM EMP;

-- DISTINCT : 중복제거, 단 행이여러개일경우 둘다 동일해야 됨

SELECT DISTINCT
    deptno 
FROM emp;

-- (컬럼 AS 별칭) 셀렉트한 컬럼의 이름을 재정의함 (별칭)
-- 연산이후 연산된 컬럼의 이름을 재정의
SELECT 
    EMPNO AS id-- 사원번호
    , ENAME AS name -- 이름
    , DEPTNO AS partNo-- 부서번호
    , SAL -- 급여
    , COMM -- 보너스
    , SAL * 12 + COMM AS yearSal
FROM EMP
-- ORDER BY 정렬할 컬럼이름, 정렬방식 n개 .....
-- 정렬 옵션 ASC 오름차순, DESC 내림차순
ORDER BY deptno ASC, SAL DESC
;

-- 위와 아래가 동일한거라고 생각하면 됨(아래는 자바 명령문)
/* class EMP {
    private int EMPNO;
    private String ENAME;
    private int partNo;
    } */
    
-- WHERE : 필요한 데이터만 출력, 연산식이 들어갈수도 있음
-- AND : 추가 조건 입력 (WHERE 과 AND 가 둘다 일치해야 출력)
-- OR : 추가 조건 입력 (WHERE 과 OR 둘중하나가 일치하면 출력)
SELECT * FROM emp
WHERE DEPTNO = 30 AND JOB = 'SALESMAN'
;

SELECT * FROM emp
WHERE SAL <= 1000 OR SAL * 12 = 36000
;

-- 급여가 2500 이상 직업이 ANALYST인 정보만 출력
SELECT * FROM EMP
WHERE SAL >= 2500 AND JOB = 'ANALYST';

-- IN () : N 개의 쉼표로 구분 내부에 OR 추가조건 입력
-- NOT IN () :  N 개의 쉼표로 구분 내부에 OR 추가조건 입력 조건과 다를때 출력
SELECT * FROM EMP
WHERE SAL >= 2500 AND JOB IN ('ANALYST','SALESMAN');

-- BETWEEN 은 AND로 구분하고 최소값과 최대값을 조건으로 작성한다.
SELECT * FROM EMP
WHERE SAL >= 2000 AND SAL <= 3000;

SELECT * FROM EMP
WHERE SAL BETWEEN 2000 AND 3000;

-- LIKE 연산자 : 특정한 문자열을 포함하는 내용을 검색 
-- % : 특정한 문자열의 포함 여부 (길이 상관없음)
-- _ : 한개의 문자열
SELECT * FROM EMP
WHERE ENAME LIKE '_AR%';

-- LIKE로 검색할때 특수문자가 있을 경우
-- ESCAPE : 찿을 특수문자 표기
SELECT * FROM EMP
WHERE ENAME LIKE 'A\_a%' ESCAPE '\';

-- NULL 값은 값이 없어서 비교연산자를 쓸수없음
-- IS 나 NOT IS를 써서 NULL 이거나 아닌 값을 출력할수있음
SELECT
    ENAME
    , COMM
    , SAL * 12 + COMM AS sum
FROM EMP
WHERE COMM IS NOT NULL
;