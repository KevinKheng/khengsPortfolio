-- add sql queries under the appropriate comment
-- Data Definition
-- exercise 1
CREATE DATABASE soccer;
-- exercise 2
CREATE TABLE teams  (team_id INT PRIMARY KEY AUTO_INCREMENT,  team_name VARCHAR(35)); 
-- exercise 3
CREATE TABLE players (
player_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(35),
last_name VARCHAR(35),
birthdate DATE,
rating CHAR(1),
team INT,
CONSTRAINT players_fk_team FOREIGN KEY (team) REFERENCES teams(team_id)
ON DELETE SET NULL ON UPDATE CASCADE
);
-- exercise 4
ALTER TABLE teams ADD color VARCHAR(20);
-- exercise 5
DROP TABLE players;
-- Views
-- exercise 1
CREATE VIEW type AS 
SELECT * FROM pet 
WHERE species = "dog"; 
-- exercise 2
-- horizontal
-- exercise 3
CREATE VIEW Birthday AS SELECT owner, p.name, type,date, remark 
   FROM pet p JOIN event e ON p.name = e.name WHERE type = "birthday";