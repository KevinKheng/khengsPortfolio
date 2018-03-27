<?php

//get the session id
session_start();
if($_SESSION['username'] == null){
	header( 'Location: book_login.php?logout');
}
?>
<!DOCTYPE html>
<html lang="en">
    <head>

		<title> Welcome</title>
  
	</head>

  <body>
<?php
// Print a greeting:
echo  '<h1>Welcome, ' . $_SESSION['username'] . '!</h1>';

echo '<a href="book_login.php?logout">Logout</a>';
	
?>