CREATE DATABASE IF NOT EXISTS menagerie;
use menagerie;

--  drop the pet table if it exists, then recreate it

DROP TABLE IF EXISTS pet;

CREATE TABLE pet
(
  name    VARCHAR(20) PRIMARY KEY,
  owner   VARCHAR(20),
  species VARCHAR(20),
  sex     CHAR(1) DEFAULT "f",
  birth   DATE,
  death   DATE
);

INSERT INTO pet VALUES("Fluffy", "Harold","cat","f","2010-02-04",	null);
INSERT INTO pet VALUES("Claws",	"Gwen",		"cat",	"m",	"2011-03-17",	null);
INSERT INTO pet VALUES("Buffy",	"Harold",	"dog",	"f",	"2006-05-13",	null);
INSERT INTO pet VALUES("Fang",		"Benny",	"dog",	"m",	"2007-08-27",	null);
INSERT INTO pet VALUES("Bowser",	"Diane",	"dog",	"m",	"1996-08-3",	"2012-07-29");
INSERT INTO pet VALUES("Chirpy",	"Gwen",		"bird",	"f",	"2015-09-11",	null);
INSERT INTO pet VALUES("Whistler",	"Gwen",		"bird",	null, 	"2014-12-09",	null);
INSERT INTO pet VALUES("Slim",		"Benny",	"snake","m",	"2013-04-29",	null);
INSERT INTO pet VALUES ('Puffball','Diane','hamster','f','2016-03-30',NULL);

-- drop the event table if it exists, then recreate it

DROP TABLE IF EXISTS event;

CREATE TABLE event
(
  name   VARCHAR(20),
  date   DATE,
  type   VARCHAR(15),
  remark VARCHAR(255),
  CONSTRAINT PRIMARY KEY(name, date)
);

INSERT INTO event VALUES ("Fluffy",	"2012-05-15",	"litter",	"4 kittens, 3 female, 1 male");
INSERT INTO event VALUES ("Buffy",	"2010-06-23",	"litter",	"5 puppies, 2 female, 3 male");
INSERT INTO event VALUES ("Buffy",	"2011-06-19",	"litter",	"3 puppies, 3 female");
INSERT INTO event VALUES ("Chirpy",	"2016-03-21",	"vet",	"needed beak straightened");
INSERT INTO event VALUES ("Slim",		"2014-08-03",	"vet",	"broken rib");
INSERT INTO event VALUES ("Bowser",	"2008-10-12",	"kennel", null);
INSERT INTO event VALUES ("Fang",		"2008-10-12",	"kennel", null);
INSERT INTO event VALUES ("Fang",		"2015-08-28",	"birthday",	"Gave him a new chew toy");
INSERT INTO event VALUES ("Claws",	"2015-03-17",	"birthday",	"Gave him a new flea collar");
INSERT INTO event VALUES ("Whistler",	"2015-12-09",	"birthday",	"First birthday");
