# Assignment 7 - Data Definition and Views

1. Copy the URL for this repository and clone it to your Cloud9 workspace: `git clone url`  where `url` is the URL for this repository
3. Paste the solutions to the following exercises in the `assign7.sql` file
4.  When you've completed the exercises, save the `assign7.sql` file. Change directories to the assignment folder.   Commit and push your solutions to GitHub.
```
cd assign7 [tab]
git add .
git commit -m "completed assignment 6"
git push
```

## Data definition
**You are asked to create a database for a children's soccer league.  The database consists of the following tables:**

### Players

Column Name  | Type |  Attribute | Constraints
---|---|---|---
player_id | INT | AUTOINCREMENT| Primary Key
first_name |VARCHAR(35) | | No
last_name | VARCHAR(35) | | No
birthdate | DATE | | No
rating | CHAR(1) | | No
team | INT | | Foreign Key – references team.team_id

### Teams
Column Name  | Type |  Attribute | Constraints
---|---|---|---
team_id | INT | AUTOINCREMENT | Primary Key
team_name | VARCHAR(35) | | No

1. Write a query to create the soccer database (schema).
1. Write a query to create the teams table.
1. Write a query to create the players table. Be sure to include the constraints.
1. Alter the team table to add a column that stores the team color.  The data type for this column is `VARCHAR(20)`.
1. Write the SQL query to drop the players table.

---
## Views

Using the menagerie database that you created in assignment 6.

1. Write the SQL statement to create a view that shows the details for dogs only.
1. Add a comment in the assign7.sql file identifying this view as a horizontal view or a vertical view.
1. Write the SQL statement to create a view that shows the birthday events for pets. The view should include the owner's name, the pet's name, the event date and remarks.
