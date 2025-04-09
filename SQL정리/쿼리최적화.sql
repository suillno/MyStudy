-- 쿼리 최적화
-- 오라클 옵티마이저
-- Nested Loop Join(Loop Join) : 
--      첫번째 테이블(Outer Table)의 각 행에 
--      두번째 테이블(inner Table)을 한번씩 조회한다,
--      두번째 테이블이 작고, 인덱스가 있을경우 유리하다 // 장점
--      두번째 테이블이 큰경우 성능저하 // 단점

-- Hash Join : 해시함수를 사용해서 첫번째 테이블의 모든 데이터를
--      해시 테이블로 만든 후 두번째 테이블의 각 행을 비교한다.
--      두번째 테이블에 인덱스가 없고, 두 테이블이 모드 큰경우 사용
--      두 테이블이 모두 크거나 모두 정렬할 필요가 없을때 // 장점
--      메모리 사용량이 많아지고, 해시 테이블을 만드는 시간이 걸린다. // 단점
 
 
-- Mere Join : 두 테이블이 정렬된 상태에서 병합.
--      두 테이블을 정렬 후 정렬된 데이터를 차례로 비교하면서 조인
--      정렬 후 join이라 성능 향상이 있을수 있음
--      두 테이블이 정렬되어있거나 정렬할 비용이 적을때 효과적
--      위 두 조인방식보다 메모리가 효율적이다 // 장점

-- 실행계획 F10
-- EXPLAIN PLAN FOR (테이블저장)
-- Nested Loop Join 강제 실행 : /*+ USE_NL(C D L) */
-- Hash Join : /*+ USE_HASH(C D L) */
-- Merge JOIN : /*+ USE_MERGE(C D L) */
SELECT /*+ USE_MERGE(C D) USE_HASH(D L) */
    COUNTRY_NAME, CITY, DEPARTMENT_NAME
FROM COUNTRIES L
    JOIN LOCATIONS C USING (COUNTRY_ID)
    JOIN DEPARTMENTS D USING (LOCATION_ID)
;

-- 저장된 실행계획 테이블 출력
SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);