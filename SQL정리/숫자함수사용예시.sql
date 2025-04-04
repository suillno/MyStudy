-- ROUND 반올림
SELECT 
	ROUND(1234.5678) AS R1,
	ROUND(1234.5678, 0) AS R2, -- 소수점 자리수 지정 반올림
	ROUND(1234.5678, 1) AS R3,
	ROUND(1234.5678, -1) AS R4 -- 실수 자리수 지정 반올림
FROM DUAL;	

-- TRUNC 버리기
SELECT 
	TRUNC(1234.5678) AS R1,
	TRUNC(1234.5678, 0) AS R2, -- 소수점 자리수 지정 반올림
	TRUNC(1234.5678, 1) AS R3,
	TRUNC(1234.5678, -1) AS R4 -- 실수 자리수 지정 반올림
FROM DUAL;	

-- CEIL : 가장 가까운 큰수 
-- FLOOR : 가장 가까운 작은수
-- MOD : 나눈 나머지 값
SELECT 
CEIL(3.14) AS C, 
FLOOR(3.14) AS F,
MOD(15, 6) AS M -- 15를 6으로 나눈 나머지 값
FROM DUAL;

-- COUNT : 행 갯수 확인
SELECT COUNT(*) FROM EMP;

-- AVG : 평균구하기
SELECT AVG(SAL) FROM EMP;