select * from all_tables;

create table board(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);
create table member(
	id varchar(15) primary key,
	password varchar(10),
	name varchar(15),
	role varchar(15)
);
insert into member values('kim','1234','�达','USER');
insert into member values('admin','1234','������','ADMIN');
select * from member;
insert into board (id,title,writer,content) values(1,'����','�达','�� ����');
select * from board;