# Assignment 6 - insert, update and delete queries


1. Copy the URL for this repository and clone it to your Cloud9 workspace: `git clone url`  where `url` is the URL for this repository
2. Change directories to the new folder and create the menagerie database: `mysql -u username < menagerie.sql`
3. Paste the solutions to the following exercises in the `assign6.sql` file
4.  When you've completed the exercises, save the `assign6.sql` file.  Commit and push your solutions to GitHub.
```
git add .
git commit -m "completed assignment 6"
git push
```

## Exercise 1
Insert a new, living pet into the pet table. Be sure to set the death date as NULL.

## Exercise 2
Insert an event for your pet for the current date.

## Exercise 3
Write an UPDATE statement that modifies the row you added to the pet table. This statement should change the species column to “horse". Be sure to use a where clause so that you do not change the species of all pets in the table.


## Exercise 4
Delete the event that you added to the table.  Be careful not to delete all events in the table.
