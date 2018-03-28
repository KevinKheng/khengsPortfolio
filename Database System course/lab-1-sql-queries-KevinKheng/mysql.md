# MySQL

## Overview
*  Developed in 1985 by MySQL AB
*  Became open source in 2000
    *  Was acquired by Sun Microsystems in 20
*  Sun was acquired by Oracle in 2010
*  Runs on a server and provides multi-user access
    *  More about servers below
*  Very popular especially for web applications
    * Powers very large-scale websites like Google, Facebook, Twitter and even YouTube.
    * MySQL is the world’s most popular database and remains so because of its open source nature. ([source](http://www.monitis.com/blog/cc-in-review-the-key-differences-between-sql-and-nosql-dbs/))

## Other RDBMS
*  Oracle
    *  Large customer base
    *  Dominant in the commercial market
*  DB2
    *  Designed to run on IBM mainframes
*  SQL Server
    *  Designed by Microsoft
    *  Medium sized systems
*  SQLite
    *  Used on mobile devices
    *  Doesn’t require a server

## MySQL and Cloud9

  1. Create a blank workspace
  2. Start the MySQL server `mysql-ctl start`
  3. Enter the MySQL command line using `mysql -u username` where `username` is your cloud9 username, for example mine username is howardcy

### Running a script
  1. Clone the setup assignment from GitHub  ` git clone url` where `url` is the URL of your GitHub repository
  2. Navigate to the directory that was created when you cloned the repository `cd database1`
  3. Execute the SQL script from the repository `mysql -u username < dreamhome.sql`
