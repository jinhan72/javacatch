create table bank1(
	num int primary key,
	mname varchar(20) not null,
	money int
);	

create table bank2(
	num2 int primary key,
	mname2 varchar(20) not null,
	money2 int

);
select *from bank1;
select *from bank2;

drop table bank2;

insert into bank1 values (1,"아무무",10000);
insert into bank2 values (1,"티모",10000);
