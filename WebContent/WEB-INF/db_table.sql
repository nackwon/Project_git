//��� ���̺� ����
CREATE TABLE member(
	nickname VARCHAR2(30) PRIMARY KEY NOT NULL,
	email VARCHAR2(50) NOT NULL,
	password VARCHAR2(30) NOT NULL
); 

//��� ���̺� Ȯ��
SELECT * FROM member;

// �Խ��� ���̺� #1
CREATE TABLE board(
	article_no number primary key,
	writer_id VARCHAR2(50) not null,
	writer_name VARCHAR2(50) not null,
	title VARCHAR2(255) not null,
	regdate timestamp not null,
	moddate timestamp not null,
	read_cnt number
);

DROP TABLE board;

CREATE TABLE board_content(
	article_no number primary key,
	content VARCHAR2(2000)
);
//article_no �ڵ� 1�� ����
CREATE sequence board_cnt
increment by 1
start with 1
nocache;

SELECT * FROM board;