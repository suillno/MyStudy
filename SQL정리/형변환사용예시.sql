-- 형변환
-- TO_CHAR : 문자형으로 형변환
-- TO_NUMBER : 숫자로 형변환
-- TO_DATE : 날짜로 형변환
SELECT 
	EMPNO, ENAME, EMPNO + '100' -- 문자열로 더해도 자동으로 값을 형변환하여 숫자처럼 인식한다
FROM EMP;

SELECT
	-- '4,000' + 50 문자와 숫자가 같이 있으면 자동으로 형변환 불가
	TO_NUMBER('4,000', '999,999') + 50 AS NUM -- 숫자로 형변환후 계산수행
FROM DUAL;

SELECT
 	SYSDATE
 	, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS A -- 날짜를 문자형으로 변경하고 형식에 맟춰 출력
 	, TO_CHAR(SYSDATE, 'MON DAY HH A.M.', 'NLS_DATE_LANGUAGE = KOREAN') AS B -- 날짜를 문자형으로 변경하고 양식에 맞게 한글로 출력
 FROM DUAL;

-- 9 : 숫자의 자리수표기
-- $ : 달러 기호 표기
-- L : 각 국가의 화폐단위 기호 표기
-- 0 : 빈자리를 0으로 채운다
SELECT
	TO_CHAR(SAL, 'L999,999') AS A
	, TO_CHAR(SAL, 'L999,999.00') AS B -- 소수점 자리수 표기시
FROM EMP;

SELECT 
 	'2025-04-04' AS DT
 	, TO_DATE('2025-04-04', 'YYYY/MM/DD') -- 문자르 날짜 형태로 변환
FROM DUAL;
