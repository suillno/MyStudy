-- TCL : Transaction Control Language
CREATE TABLE DEPT_TCL AS SELECT * FROM DEPT;
    
-- 데이터 입력시 비밀번호는 복호화가 불가능한 암호화를하여 저장하여야한다.
INSERT INTO USERS (USERNAME, PASSWORD)
VALUES ('kh', STANDARD_HASH('kh', 'SHA256'));

SELECT * FROM USERS
WHERE USERNAME = 'kh' -- AND PASSWORD = STANDARD_HASH('kh', 'SHA256');

-- SQL Injection
-- 사용자가 입력한 데이터를 통해 쿼리의 구조를 조작하거나 공격하는 

