USE dreamhome;
-- add sql queries under the appropriate comment

-- exercise 1

SELECT LOCATE("-",telNo)-1 FROM client;
SELECT LEFT(telNo, locate("-",telNo)-1) FROM client;   
-- exercise 2
SELECT rent,FORMAT(rent,2)FROM propertyForRent;
SELECT rent, FORMAT(rent,2) FROM propertyForRent;
--exercise 3
SELECT Date_Format(current_timestamp, "%m/%d/%y") AS Now;
SELECT Date_Format(current_timestamp, "%M %e %Y") AS Now;
SELECT Date_Format("2017-10-2", "%M %e %Y") AS Now;
SELECT Date_Format(current_timestamp, "%W %M %D") AS Now; 
--exercise 4
SELECT TIME_FORMAT(current_timestamp,"%H:%i:%S ") AS Now; 
SELECT TIME_FORMAT(current_timestamp,"%H:%i:%S ") AS Now; 