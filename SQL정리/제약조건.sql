-- 제약조건
-- NOT NULL : NULL을 허용하지 않는다
-- UNIQUE : 유일한 값 NULL 허용
-- PRIMARY KEY : 유일한 값 NULL 허용 안함
-- FOREIGN KEY : 다른 테이블을 참조하여 존재하는 값만 입력 가능
-- CHECK : 설정한 조건식을 만족하는 데이터만 입력

-- 무결성
-- 영역 무결성 : 값의 적정성 여부
-- 개체 무결성 : 테이블에서 유일하게 식별할 수 있는 기본키
-- 참조 무결성 : 참조 테이블의 외래키 값은 기본키로 존재해야 한다.

-- CONSTRAINT : 제약조건의 이름설정 
-- NOT NULL : NULL 비허용
CREATE TABLE USERS2 (
    USER_ID VARCHAR2(20) CONSTRAINT USER_ID_NN NOT NULL 
    , USER_PW VARCHAR2(20) CONSTRAINT USER_PW_NN NOT NULL
    , USER_TEL VARCHAR2(13) 
);

-- 데이터 입력
INSERT INTO USERS (USER_ID, USER_PW, USER_TEL)
VALUES ('USER', 'USER01', NULL);

-- 데이터 수정
UPDATE USERS SET
USER_ID = 'KIM'
WHERE USER_ID = 'USER2';

-- *현재 사용자(SCHEMA)*가 소유한 테이블에 대한 제약조건만 보여주는 뷰
SELECT 
    OWNER,
    CONSTRAINT_NAME,
    CONSTRAINT_TYPE
FROM user_constraints;

-- 제약조건 삭제
ALTER TABLE USERS DROP CONSTRAINT 제약조건명;
ALTER TABLE USERS DROP CONSTRAINT SYS_C008324;

-- UNIQUE : 유일한 값 NULL 허용
CREATE TABLE TBL_UNIQUE (
    USER_ID VARCHAR2(20) UNIQUE -- 사용자 아이디는 겹치면 안됨
    , USER_PW VARCHAR2(20) NOT NULL
    , USER_TEL VARCHAR2(13) 
);

INSERT INTO TBL_UNIQUE (USER_ID, USER_PW)
VALUES ('TEST01', '1234'); -- 중복생성시도시 UNIQUE 제약조건 위반으로 생성 불가능

INSERT INTO TBL_UNIQUE (USER_ID, USER_PW)
VALUES ('TEST02', '1234'); 
