create table test(
tpk int primary key,
content varchar(50)
);

drop table test;
select * from test;


SELECT * FROM(SELECT A.*, ROWNUM AS RNUM FROM(SELECT * FROM TEST ORDER BY TPK) A WHERE ROWNUM <= 30) WHERE RNUM >20;

SELECT * FROM TEST ORDER BY TPK ASC;
SELECT * FROM (SELECT * FROM TEST ORDER BY TPK ASC) WHERE ROWNUM > 10;
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');

insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');

insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');

insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');

insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');
insert into test values(nvl((select max(tpk) from test),0)+1, '내용');


