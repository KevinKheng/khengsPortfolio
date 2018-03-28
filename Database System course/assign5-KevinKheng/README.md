# Assignment5 - Multiple Table Queries


1. Copy the URL for this repository and clone it to your Cloud9 workspace: `git clone url`  where `url` is the URL for this repository
2. Using the movie_ratings database created for assignment 4, solve the exercises below.
3. Paste the solutions in the `assign5.sql` file
4.  When you've completed the exercises, save the `assign5.sql` file.  Commit and push your solutions to GitHub.

```
git add .
git commit -m "completed assignment 5"
git push
```


## Exercise 1
List the name of the reviewer, the rating and the date for each movie review.  Sort by reviewer name.

## Exercise 2
Find the reviews for reviewer 203.  Display the movie title, rating and date for all reviews by reviewer 203.

## Exercise 3
Find movies that have not been reviewed.  *Hint: use an outer join and return only those rows where the rID is null*


## Exercise 4
List the names of the people who reviewed "Snow White".  Use the movie title and not the mID in your WHERE clause. *Hint:  This requires 3 tables.*


## Exercise 5
Find the number of ratings made by each reviewer.  Your query result should display the name of the reviewer and the number of reviews for that reviewer.
