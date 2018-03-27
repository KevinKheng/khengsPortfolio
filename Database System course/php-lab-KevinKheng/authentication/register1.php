<!DOCTYPE html>


<html>

  <head>
    <meta charset="UTF-8">
    
<title> Register </title>
    <link rel="stylesheet" href="register.css">
  
</head>

  <body>

<?php


// Flag variable to track success:
$okay = TRUE;
if(isset($_POST['tried'])){  //if the form was submitted

	// Validate the password:
	if (empty($_POST['password'])) {
		echo '<p class="error">Please enter your password.</p>';
		$okay = FALSE;
	}


	// Check the two passwords for equality:
	if ($_POST['password'] != $_POST['confirm']) {
		echo '<p class="error">Your confirmed password does not match the original password.</p>';
		$okay = FALSE;
	}

	
}
	// If there were no errors, print a success message:
	if (isset($_POST['tried']) && $okay ) {  //if form was submitted and everything is good
	    $bday = $_POST['birthday']; 
		echo '<p>You have been successfully registered (but not really).</p>';
		echo "<p>You entered your birthday as $bday.</p>";
	}
	else {

?>



<form action="register1.php" method="post">
<p> Email Address:  <input type="email" name="email" size="30" required 	
	placeholder="Enter a valid email address"/><p>
<p>Password: <input type="password" name="password" size="20" /></p>
<p>Confirm Password: <input type="password" name="confirm" size="20" /></p>

<p> Date of Birth: <input type="date" name="birthday"> </p>

</p>
<input type="submit" name="submit" value = "Register" />
<input type="hidden" name="tried" value="true">
</form>
<?php
	}
?>
</body>

</html>
