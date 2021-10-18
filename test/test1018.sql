create table client2(
	userID varchar(20) primary key,
	userPW varchar(20) not null,
	name varchar(20) not null
);

drop table client2;
select * from client2;

create table message2(
	mnum int primary key,
	userID varchar(20) not null,
    title varchar(15) not null,
    content varchar(50) not null,
    wdate date
);
drop table message2;







insert into client2 values('timo','1234','티모');
insert into message2 values(1,'timo','제목','글 내용입니다',sysdate);


select * from client2;
select * from message2;
