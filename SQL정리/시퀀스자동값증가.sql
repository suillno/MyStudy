-- 자동값 증가 SEQUENCE
CREATE SEQUENCE 시퀀스명 
INCREMENT BY N -- N값만큼 호출할때마다 자동증가
START WITH N -- N값부터 시작 (초기값)
MAXVALUE N -- 시퀀스로 생성 가능한 최대 값
MINVALUE N -- 생성 가능한 최소 값
CYCLE 또는 NOCYCLE -- 최대값 도달시 (CYCLE : 반복, NOCYCLE : 오류)              
CACHE 또는 -- 시퀀스가 생성할 번호를 메모리에 미리 올려둔다.
;

CREATE TABLE DEPT_SEQUENCE AS 
 SELECT * FROM DEPT WHERE 1 <> 1;
 
SELECT * FROM DEPT_SEQUENCE;

-- 시퀀스 생성
CREATE SEQUENCE SEQ_DEPT
INCREMENT BY 10
START WITH 10
MAXVALUE 90
MINVALUE 0
NOCYCLE 
CACHE 2;

-- 시퀀스 수정
ALTER SEQUENCE SEQ_DEPT
INCREMENT BY 3
MAXVALUE 99
CYCLE;

-- 시퀀스 설정 조회
SELECT * FROM USER_SEQUENCES;


SELECT SEQ_DEPT.CURRVAL FROM DUAL;

-- 시퀀스 삭제
DROP SEQUENCE SEQ_DEPT;

INSERT INTO DEPT_SEQUENCE (DEPTNO, DNAME, LOC)
VALUES (SEQ_DEPT.NEXTVAL, 'DATE', 'SEOUL');