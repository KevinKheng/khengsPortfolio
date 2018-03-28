USE movie_ratings;
-- add sql queries under the appropriate comment

-- exercise 1
SELECT name,stars,ratingDate 
FROM Reviewer r JOIN Rating ra ON r.rID = ra.rID 
ORDER BY name;  
-- exercise 2
SELECT rID, title,stars,ratingDate 
FROM Movie m 
    JOIN Rating r ON m.mID = r.mID 
WHERE rID = 203 ;  
-- exercise 3
SELECT name, z.stars, m.title, z.ratingDate FROM Reviewer x 
    Right JOIN Rating z ON x.rID = z.rID 
    Right JOIN Movie m ON z.mID = m.mID 
WHERE x.name 
IS NULL ORDER BY name;
-- exercise 4
SELECT name, z.stars, m.title, z.ratingDate FROM Reviewer x 
  Right JOIN Rating z ON x.rID = z.rID 
  Right JOIN Movie m ON z.mID = m.mID 
WHERE m.title = "Snow White" ORDER BY name;
-- exercise 5
SELECT DISTINCT name, COUNT( name) AS numOfReviews, z.stars, m.title, z.ratingDate 
FROM Reviewer x 
   JOIN Rating z ON x.rID = z.rID 
   JOIN Movie m ON z.mID = m.mID 
GROUP BY name;

