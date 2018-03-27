CREATE DATABASE IF NOT EXISTS caseStudy2
USE caseStudy2

DROP TABLE IF EXISTS book; 

CREATE TABLE book
(ISBN char(11) PRIMARY KEY,
title varchar(10),
arthur varchar(20),
genre varchar (30)
);

CREATE INDEX readBooks
on book (title,arthur);

CREATE UNIQUE INDEX distinctISBN
on book (ISBN);


INSERT INTO book VALUES('1628971819','The Last Libraian','Osdany Morales','fiction');
INSERT INTO book VALUES('1632453677','Hidden Kingdom','Amanda Hocking','fiction');
INSERT INTO book VALUES('159514823X','Crystal Storm','Morgan Rhodes','fiction');

DROP TABLE IF EXISTS bookRead;

CREATE TABLE bookRead(
ISBN char(11),
dateStarted Date,
dateEnded  Date,
Summary varchar(50),
FOREIGN KEY bookRead(ISBN) REFERENCES book(ISBN)
);



INSERT INTO bookRead VALUES('1628971819','2015-10-12','2015-11-12','A great book');
INSERT INTO bookRead VALUES('1632453677','2011-08-09','2012-01-08','4 out of 5 stars');
INSERT INTO bookRead VALUES('159514823X','2014-02-14','2014-03-26','Exciting adventures');