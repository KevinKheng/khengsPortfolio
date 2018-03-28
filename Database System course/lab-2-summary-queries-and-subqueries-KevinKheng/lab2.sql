USE dreamhome;
-- add sql queries under the appropriate comment

-- exercise 1
SELECT COUNT(clientNo) AS numClients 
FROM client;

SELECT COUNT(DISTINCT city) AS cityCount 
FROM propertyForRent;

SELECT COUNT(propertyNo) AS numProperties 
FROM propertyForRent 
WHERE city = "Glasgow";

SELECT MIN(rent) AS miniRent 
FROM propertyForRent;
-- exercise 2
SELECT city,  COUNT(propertyNo)AS numProperties 
FROM propertyForRent 
Group By city;

SELECT type, AVG(rooms) AS avgRooms, AVG(rent) AS avgRent 
FROM propertyForRent 
GROUP by type;
-- exercise 3
SELECT city,AVG(rent) AS avgRent, count(propertyNo) 
FROM propertyForRent 
GROUP BY city 
HAVING COUNT(propertyNo) > 1;

SELECT position, avg(salary) 
FROM staff 
GROUP BY position 
HAVING avg(salary) > 10000 ;
-- exercise 4
SELECT COUNT(clientNo) AS numClients 
FROM client;

SELECT COUNT(staffNo)AS numLess10 
FROM staff 
WHERE salary < 10000; 

SELECT MAX(salary)AS maxSalary 
FROM staff;

SELECT city, COUNT(branchNo) AS numBranches 
FROM branch 
GROUP BY city;

SELECT city, AVG(rent) AS avgRent 
FROM propertyForRent 
GROUP BY city; 

SELECT branchNo, AVG(salary) AS avgSalary 
FROM staff 
WHERE salary > 12000 
GROUP BY branchNo;

SELECT branchNo, AVG(salary) AS avgSalary 
FROM staff  
GROUP BY branchNo 
HAVING AVG(salary) > 12000 ;
-- exercise 5
SELECT *  
FROM viewing 
WHERE propertyNo =
    (SELECT propertyNo from propertyForRent WHERE city = "Aberdeen");
    
SELECT street, city, type 
FROM propertyForRent 
WHERE ownerNo = 
    (SELECT ownerNo FROM privateOwner WHERE lname = "Farrel" AND fname = "Carol");
    
SELECT street,city,type,rent 
FROM propertyForRent 
WHERE rent < 
    (SELECT AVG(rent) FROM propertyForRent);

-- exercise 6
SELECT * 
FROM viewing 
WHERE propertyNo IN (SELECT propertyNo FROM  propertyForRent WHERE city = "Glasgow");

SELECT street,city,type,rent 
FROM propertyForRent 
WHERE rent < ANY(SELECT rent FROM propertyForRent WHERE city = "Glasgow");