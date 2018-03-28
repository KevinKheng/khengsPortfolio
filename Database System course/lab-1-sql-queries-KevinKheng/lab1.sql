USE dreamhome;
-- add sql queries under the appropriate comment

-- exercise 1
 SELECT propertyNo,type,rent FROM propertyForRent;
 SELECT * FROM branch;
 SELECT lName, telNo FROM client;
-- exercise 2
SELECT propertyNo,street,city,type,rent AS monthlyRent,
    rent *12 AS annualRent 
FROM propertyForRent ;
-- exercise 3
SELECT CONCAT(fName," ",lname)AS fullName FROM staff;
-- exercise 4
SELECT * FROM propertyForRent WHERE  rent <= 400;
SELECT clientNo, fname, lName FROM client where prefType = "house";
SELECT * FROM viewing WHERE viewDate > "2015-05-15";
-- exercise 5
SELECT fName, lName,branchNo FROM staff WHERE salary = 9000 AND position = "assistant";
SELECT * FROM propertyForRent WHERE rent < 400 AND city="Glasgow"; 
SELECT * FROM viewing WHERE viewDate >= "2015-04-01" AND viewDate <= "2015-04-30";
---excercise 6
SELECT * FROM viewing ORDER BY viewDate
SELECT * FROM viewing ORDER BY viewDate DESC ;
SELECT * FROM viewing ORDER BY clientNo, viewDate;