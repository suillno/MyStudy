-- 표준함수 (호환)
-- 1, 숫자
-- ABS() : 절대값
-- CEIL() : 주어진 숫자 이상으로 가장 적은 정수
-- FLOOR() : CEIL 반대
-- ROUND(X,Y) : 값이 소수점일때 Y자리를 반올림
-- MOD(X,Y) : 나머지 값
-- POWER(X,Y) : X의 Y제곱
-- SQRL() : 제곱근

-- 2, 문자
-- CONCAT(X,Y) : 두 문자열 합치기
-- LENGTH() : 문자열 길이
-- LOWER() : 소문자로 변환
-- UPPER() : 대문자로 변환
-- TRIM() : 문자열의 양쪽 끝 공백 제거
-- SUBSTR(X, START, LENGTH) : X 문자열에서 START부터 LENGTH 만큼 문자열 추출
-- INSTR(X,Y) : 특정문자 위치 찾기

-- 3, 날짜
-- CURRNET_DATE : 현재 날짜 반환
-- CURRNET_TIMESTAMP : 현재 날짜 + 시간 반환

-- 4, 집계 함수
-- COUNT() : 행의 갯수
-- SUM() : 합계
-- AVG() : 평균
-- MIN() : 최소값
-- MAX() : 최대값


-- 비표준함수 (호한x)
-- 오라클 전용
-- TO_DATE(날짜, 날짜의 패턴) : 문자열을 날짜 변환
-- TO_CHAR(SYSDATE, 'YYYY-MM-DD') : 날짜를 문자로 변환
-- SYSDATE : 현재 날짜와 시간 반환
-- NVL(X, 0) : if문 X값 연산에 따라 true일 경우 두번째 파라미터값 출력
-- DECODE(X, 1, 'ONE', 'OTHER') : IF / ELSE 구문 X의 값이 1이 맞으면 ONE 아니면 OTHER
-- ROWNUM : 쿼리 결과에서 행 번호를 만들어서 반환
-- LISTAGG(X, ',') : 그룹화된 데이터의 값을 하나의 문자열로 결합

