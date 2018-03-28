USE menagerie;
-- add sql queries under the appropriate comment

-- exercise 1
INSERT INTO pet VALUES ('Nala','Jose','dog','f','2015-02-14',NULL);
-- exercise 2
INSERT INTO event VALUES ('Nala','2017-10-09','vet','Need shots');
-- exercise 3
UPDATE pet
    SET species = 'horse' 
    WHERE name = 'Nala';
-- exercise 4
DELETE FROM event 
     WHERE name = 'Nala';