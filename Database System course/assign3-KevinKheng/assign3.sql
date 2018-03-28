USE assign3;
-- add sql queries under the appropriate comment

-- exercise 1
SELECT name, city, country, height  FROM skyscrapers;
-- exercise 2
SELECT name, completed_year, height FROM skyscrapers WHERE city = "Peoria";
-- exercise 3
SELECT name, city, floors_above FROM skyscrapers WHERE height > 400;
-- exercise 4
SELECT name, is_completed FROM skyscrapers WHERE city = "Nashville";
-- exercise 5
SELECT name, city 
FROM skyscrapers WHERE material = "steel" OR material = "concrete" 
ORDER BY name ASC;
-- exercise 6
SELECT name, city, floors_above 
FROM skyscrapers WHERE completed_year < 1900 AND completed_year > 0 
ORDER BY height ASC;
-- exercise 7
SELECT name, city, abandoned FROM skyscrapers 
ORDER BY city, completed_year ASC;
-- exercise 8
SELECT DISTINCT material FROM skyscrapers 
ORDER BY material ASC;
