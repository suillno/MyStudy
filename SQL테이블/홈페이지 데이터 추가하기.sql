INSERT INTO FESTIVAL (AREA_CODE, ADDR, ADDR_2, MAPX, MAPY, START_DATE, END_DATE, TITLE, TEL, IMAGE, IMAGE_2)
VALUES (1, '서울특별시 송파구 양재대로 932 (가락동)',  '가락몰 3층 하늘공원', 127.1107693087, 37.4960786971, 
	'20250509', '20250511', '가락몰 빵축제 전국빵지자랑', '02-3435-0286', 
	'http://tong.visitkorea.or.kr/cms/resource/91/3484791_image2_1.jpg',
	 'http://tong.visitkorea.or.kr/cms/resource/91/3484791_image3_1.jpg');



INSERT INTO ACCOMMODATION (AREA_CODE, ADDR, MAPX, MAPY, TITLE, TEL, IMAGE, IMAGE_2)
VALUES (1, '경상북도 안동시 하회남촌길 69-5', 128.5175868107, 36.5376537450, '가경재', 054-855-8552, 
	'http://tong.visitkorea.or.kr/cms/resource/00/2626200_image2_1.jpg',
	'http://tong.visitkorea.or.kr/cms/resource/00/2626200_image3_1.jpg');


INSERT INTO MEMBER (
	USER_PW
	, USER_NAME
	, EMAIL
	, PHONE_NUM
	, USER_ADDR
	, EMAIL_AUTH_CODE
	, USER_ID)
VALUES (
	STANDARD_HASH('KIM', 'SHA256')
	, '김구'
	, 'kimgu@naver.com'
	, '010-1234-1456'
	, '서울시 용산구'
	, STANDARD_HASH('ye', 'SHA256')
	, 'KIMGU');


TRUNCATE TABLE MEMBER;

UPDATE MEMBER SET PHONE_NUM = NULL;

ALTER TABLE MEMBER MODIFY PHONE_NUM VARCHAR2(13);
