-- FOREIGN KEY, 외래키, 외부키
-- 테이블간의 관계 정의
CREATE TABLE 테이블명 (
	DEPTNO NUMBER CONSTRAINT DEPTNO_FK REFERENCES DEPT (DEPTNO)
);

-- CHECK : 데이터 형태, 범위 지정
CREATE TABLE CHK (
	VBC VARCHAR2(10) CONSTRAINT	ABC_CHK CHECK( LENGTH(ABC)>3 ) -- 3글자 이상만 입력가능
);

-- DEFAULT : 기본값
CREATE TABLE CHK (
	ABC VARCHAR2(10) DEFAULT '1234' -- 값 미입력시 기본값 입력
);
