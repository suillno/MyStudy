-- 날짜출력
SELECT 
	SYSDATE - 1, -- 어제 날짜 간단한 계산식이 들어갈수있음
	ADD_MONTHS(SYSDATE, 3) -- 지금으로 부터 3개월 후
FROM DUAL;

SELECT 
	ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 120) -- 입사일의 10년후
FROM EMP;

SELECT
	NEXT_DAY(SYSDATE, '월요일'), -- 다음 월요일은 언제냐
	LAST_DAY(SYSDATE) -- 지정한 날에 마지막 날은 언제냐
FROM DUAL;

SELECT 
	SYSDATE,
	ROUND(SYSDATE, 'CC'), -- CC 4자리연도의 끝 2자리를 기준, 반올림
	ROUND(SYSDATE, 'YYYY'), -- 년도를 제외한 나머지는 반올림
	ROUND(SYSDATE, 'Q'), -- 월까지 표기 나머지는 반올림
	ROUND(SYSDATE, 'DDD'), -- 오늘 날짜의 정오기준
	ROUND(SYSDATE, 'HH') -- 오늘 시간을 기준으로
FROM DUAL;