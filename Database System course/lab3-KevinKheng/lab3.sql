USE dreamhome;
-- add sql queries under the appropriate comment

-- exercise 1
SELECT street, city, type,fName,lName 
FROM propertyForRent p JOIN privateOwner o ON p.ownerNo = o.ownerNo 
ORDER BY lName;

SELECT fName, lName, position, city 
FROM staff s JOIN branch b ON s.branchNo = b.branchNo 
ORDER BY lName;  

-- exercise 2
SELECT fName, lName, viewDate, comment
FROM client c JOIN viewing v ON c.clientNo = v.clientNo
    JOIN propertyForRent p ON v.propertyNo = p.propertyNo;


SELECT street, city, type, o.lName AS owner, s.lName AS staff  
FROM propertyForRent p 
    JOIN privateOwner o ON p.ownerNo = o.ownerNo 
         JOIN staff s ON p.staffNo = s.staffNo;