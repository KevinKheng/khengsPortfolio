USE movie_ratings;
-- add sql queries under the appropriate comment

-- exercise 1
SELECT COUNT(DISTINCT rID) AS movie_rating 
FROM Rating;
-- exercise 2
SELECT COUNT(stars) AS 4starRatings 
FROM Rating 
WHERE stars = 4;
-- exercise 3
SELECT COUNT(ratingDate) AS mostRecentReview 
FROM Rating;
-- exercise 4
SELECT COUNT(ratingDate) AS 4starRatingDates  
FROM Rating 
WHERE stars = 4;
-- exercise 5
 SELECT rID,COUNT(stars) AS numOfMoviesReview 
 FROM Rating 
 GROUP BY rID DESC ;
-- exercise 6
SELECT rID, COUNT(rID) AS numOfReviewsGreaterThan1 
FROM Rating 
GROUP BY rID 
HAVING COUNT(rID) > 1;
-- exercise 7
SELECT *  
FROM Rating  
WHERE mID IN(SELECT mID FROM Movie  WHERE title = "Gone with the Wind");
-- exercise 8
SELECT * FROM Reviewer 
WHERE rID IN(SELECT rID FROM Rating WHERE stars >=4);