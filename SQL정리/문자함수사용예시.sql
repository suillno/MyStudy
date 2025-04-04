-- 사용 예시

SELECT  
ENAME AS name 
, UPPER(ENAME) AS upperName
, LOWER(ENAME) AS LowerCase
, INITCAP(ENAME) AS InCase 
, LENGTH(ENAME) AS nameLength
FROM EMP
WHERE LOWER(ENAME) LIKE '%s%' -- 사용자 검색시 모두 소문자로 변경하여 검색
;

SELECT  
ENAME AS name
, SUBSTR(ENAME, 1, 3) -- 첫번째자리에서 3번째자리까지 잘라줘
, SUBSTR(ENAME, 4) -- 시작위치에서 4번째 자리까지 잘라줘
, SUBSTR(ENAME, -LENGTH(ENAME), 2) -- 마이너스 문자는 문자의 뒤에서부터 시작한다는 뜻
FROM EMP
;

SELECT  
INSTR('HELLO ORACLE', 'L') -- 문자에 포함된 숫자 세기
, INSTR('HELLO ORACLE', 'L', 5)
, INSTR('HELLO ORACLE', 'L', 2, 2)
FROM EMP;

SELECT
'010-4065-4618' AS TEL,
REPLACE('010-4065-4618', '-', '=') AS TEL2, -- 특정 문자를 변경
REPLACE('010-4065-4618', '-') AS TEL3 -- 특정 문자를 제거
FROM EMP;

SELECT 
'Oracle' AS org,
LPAD('Oracle', 10, '#') AS PAD --자리수 미달시 자리수에 도달할때까지 특정 문자열 추가 (LPAD : 왼쪽에 추가) (RPAD : 오른쪽에 추가)
FROM EMP;

SELECT		--전화번호 뒷 4자리 지우고									전화번호의 자리수만큼 #을 채워라
RPAD(SUBSTR('010-4515-1845', 1, LENGTH('010-4515-1845')-4), LENGTH('010-4515-1845'),'#') AS TEL2 
FROM DUAL;

SELECT 
EMPNO, ENAME, CONCAT(EMPNO, CONCAT(EMPNO, ENAME)) AS A -- 문자열합치기 2개 이상 합치려면 CONCAT을 한번서 사용해야함
, EMPNO || ':' || ENAME AS B -- 위와 동일하나 표준문법이 아니라 권장하지는 않음
FROM EMP;

--[__ORACLE__]
-- 문자열 합치기 및 공백 제거
SELECT
'[' || '__ORACLE__' || ']' AS ORG -- 문자열 합치기
, '[' || TRIM(LEADING FROM ' _ _ORACLE_ _ ') || ']' AS T1 -- 앞의공백제거
, '[' || TRIM(TRAILING FROM ' _ _ORACLE_ _ ') || ']' AS T2 -- 뒤의공백제거
, '[' || TRIM(BOTH FROM ' _ _ORACLE_ _ ') || ']' AS T3 -- 앞뒤공백 제거
, '[' || TRIM(' _ _ORACLE_ _ ') || ']' AS T4 -- 앞뒤공백 제거
, '[' || LTRIM(' _ _ORACLE_ _ ') || ']' AS T5 -- 앞의공백제거
, '[' || RTRIM(' _ _ORACLE__', '-') || ']' AS T6 -- 앞뒤공백 제거
FROM DUAL;