CREATE TABLE IMGFILE(
PK INT auto_increment PRIMARY KEY,
TITLE VARCHAR(50),
FILENAME VARCHAR(50)
);

DROP TABLE IMGFILE;

INSERT INTO IMGFILE(PK,TITLE) VALUES(1,'����2');
SELECT * FROM IMGFILE;
DELETE * FROM IMGFILE;
