/*
트랜잭션(Transaction):
데이터베이스에서 **하나의 작업 단위(논리적 처리 단위)**를 말해요.
예:

A가 B에게 계좌이체 → A 잔액 감소 + B 잔액 증가는 하나의 트랜잭션!

✔️ 트랜잭션이란
**"이 작업을 전부 성공시키든지, 아니면 하나도 하지 말자!"**는 개념입니다.
*/

INSERT INTO DEPT_TCL (DEPTNO,DNAME,LOC)
VALUES (50, 'DATABASE', 'SEOUL');

UPDATE DEPT_TCL SET LOC = 'BUSAN' WHERE DEPTNO = 40;

DELETE FROM DEPT_TCL WHERE DNAME = 'RESEARCH';

-- 세션이 있는동안 입력한 명령문을 초기화한다
ROLLBACK;

-- 데이터를 영구히 반영 롤백을 입력해도 복구 불가능하다
COMMIT;

-- 로그인하거나 새창에서 여는등 세션이 발생되며 COMMIT을 하기전까지는
-- 다른세션에는 변경된 값이 적용되지 않는다

-- LOCK : 데이터를 수정하는 동안 다른 세션에서 해당 데이터를 변경하지 못하도록 막는 것

-- HANG : 락이 걸린 데이터를 다른 세션에서 수정 시도 시, 락이 풀릴 때까지 대기
SELECT * FROM DEPT_TCL;

UPDATE DEPT_TCL SET LOC = 'SEOUL' WHERE DEPTNO = 30;