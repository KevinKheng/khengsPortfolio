CREATE DATABASE IF NOT EXISTS labWorks;
USE labWorks;

DROP TABLE IF EXISTS chemist;

CREATE TABLE chemist (
   employeeId char(10) ,
   assignId int,
   chemistName varchar(40),
   position varchar(40),
   PRIMARY KEY (employeeId)
);


CREATE INDEX  employeePositions
on chemist(chemistName,position);

INSERT INTO chemist VALUES('E134','1','Tom Jerry','chemist aprentice');                                                                                                 
INSERT INTO chemist VALUES('E266','2','John Perry','chemist master');
INSERT INTO chemist VALUES('E897','3','Naruto Uzumaki','analytical chemist');

DROP TABLE IF EXISTS project;

CREATE TABLE project (
   projectId  char(10) , 
   projectName varchar(30),
   projectRisk varchar(30),
   projectDate Date,
   PRIMARY KEY (projectId)
 
);

CREATE INDEX projectShortcut
on project (projectName,projectRisk);

INSERT INTO project VALUES('P001','T-Cells','high','2017-03-03');
INSERT INTO project VALUES('P002','Best Meth','low','2013-02-14');
INSERT INTO project VALUES('P003','O-Cells','medium','2017-05-06');

DROP TABLE IF EXISTS equipment;

CREATE TABLE equipment (
   serialNoId varchar(12),
   description varchar(60),
   cost float,
   PRIMARY KEY (serialNoId)
);

CREATE INDEX  equipmentPrice
on equipment(description,cost);

INSERT INTO equipment VALUES('146467x','libey bar','80');
INSERT INTO equipment VALUES('245689w','Beaker','120');
INSERT INTO equipment VALUES('147893e','therometer','200');

DROP TABLE IF EXISTS assignment;

CREATE TABLE assignment (
  assignId int,
  assignmentName varchar (30),
  employeeId char(10),
  projectId char(10),
  serialNoId varchar(12),
  PRIMARY KEY AUTO_INCREMENT (assignID),
  KEY FK (employeeId, projectId, serialNoId)
);




INSERT INTO assignment VALUES('1','T-Virus','E134','P001','146467x' );
INSERT INTO assignment VALUES('2','BlueDream','E266','P002','245689w');
INSERT INTO assignment VALUES('3','SuperSoldier','E897','P003','147893e'); 


SELECT chemistName ,position FROM chemist c JOIN assignment a on c.employeeId = a.employeeId;


CREATE VIEW AssignmentDetails AS
SELECT chem.chemistName, chem.position,a.assignmentName, e.description, e.cost FROM chemist chem  
JOIN  assignment a ON chem.assignID = a.assignId
JOIN equipment e ON a.serialNoId = e.serialNoId;