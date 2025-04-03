-- 인덱스
-- USER_INDEXES : 인덱스 조회
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_IND_COLUMNS;

-- 인덱스 설정 : 검색할때 성능에 도움이됨
CREATE INDEX 인덱스이름 ON 테이블명 (열이름, 열이름2,...)

CREATE INDEX IDX_EMP_SAL ON EMP (SAL);

-- 유저 저장시 비밀번호 암호화필요
CREATE TABLE MEM ( -- 가입자정보
	USER_ID NVARCHAR2(10) UNIQUE NOT NULL -- 사용자 아이디 유니크, NULL 불가
	, USER_PW NVARCHAR2(100) NOT NULL -- 패스워드, NULL 불가
);
	
-- 비밀번호 암호화하여 저장 / 복호화 불가
INSERT INTO  MEM (USER_ID, USER_PW)
VALUES ('NO2', STANDARD_HASH('1234', 'SHA256'));


SELECT '1234' AS PW, STANDARD_HASH('1234', 'SHA256') AS aa 
FROM DUAL;

-- 자바로 KISA SEED 소스코드를 통해 복호화도 가능한 암호화를 사용할수있다.