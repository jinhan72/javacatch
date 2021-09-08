CREATE TABLE MESSAGE(
	MNUM INT PRIMARY KEY,
	WRITER varchar(15) NOT NULL,
	TITLE varchar(15) NOT NULL,
	CONTENT varchar(100) NOT NULL,
	WDATE DATE DEFAULT SYSDATE
);

SELECT * FROM MESSAGE;
DROP TABLE MESSAGE;
/* 샘플데이터 : 일반적으로 서비스 될때에는 샘플데이터가 있다! */
insert into MESSAGE(MNUM, WRITER, TITLE, CONTENT) values (1, 'kim', 'title111', 'content111');
insert into MESSAGE(MNUM, WRITER, TITLE, CONTENT) values (2, 'kim', 'title222', 'content222');
insert into MESSAGE(MNUM, WRITER, TITLE, CONTENT) values (3, 'kim', 'title333', 'content333');
insert into MESSAGE(MNUM, WRITER, TITLE, CONTENT) values (4, 'kim', 'title444', 'content444');

CREATE TABLE MEMBER (
	MEMNUM INT PRIMARY KEY,
	MID VARCHAR(15),
	MPW VARCHAR(15)
);

DROP TABLE MEMBER;

SELECT * FROM MEMBER;

INSERT INTO MEMBER VALUES (1, 'young', '1234');
INSERT INTO MEMBER VALUES (2, 'jin', '1234');

SELECT * FROM MEMBER;
delete member where mnum=3;