//멤버 테이블 생성
CREATE TABLE member(
	nickname VARCHAR2(30) PRIMARY KEY NOT NULL,
	email VARCHAR2(50) NOT NULL,
	password VARCHAR2(30) NOT NULL
); 

//멤버 테이블 확인
SELECT * FROM member;
