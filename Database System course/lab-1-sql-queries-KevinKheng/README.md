# Lab 1 - SQL and MySQL

**Create a script file `lab1.sql` that contains the SQL statements for the following lab exercises.  Copy an paste the sql statement for each of the exercises into your script. Commit and push your changes to GitHub.  Submit the assignment in Blackboard including a link to your GitHub repository.**

## Exercise 1 - Basic `SELECT` statements
- Select the property number, type and rent from the `propertyForRent` table
- Select all fields from the `branch` table
- Select the name and phone of all clients

## Exercise 2 - Calculated Values
Write a `SELECT` statement that returns this data from the `propertyForRent` table
- property number
- street address
- city
- type
- rent (alias monthlyRent)
- rent * 12 (alias annualRent)

## Exercise 3 - String Manipulation
Write a `SELECT` statement that returns one column from the `staff` table named fullName that joins the staff member's first name and last like this:
`Doe, John`

## Exercise 4 - Comparison
Write queries to:
- Find all property for rent with rent less than  or equal to $400
- Find all clients looking to rent a house
- Select all viewings since `2015-05-15`

## Exercise 5 - Compound Comparisons
Write queries to:
- Find the first name, last name and branch number of all assistants whose salary is $9,000
- Find property for rent in Glasgow with rent less than $400
- Select all viewings in the month of April 2015

## Exercise 6 - Sorting
Write queries to:
- Select viewings in ascending order by `viewDate`
- Select viewings in descending order by `viewDate`
- Select viewings and display by client and within each client display by `viewDate`
