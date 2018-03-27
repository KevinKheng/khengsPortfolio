<!DOCTYPE html>


<html>

  <head>
    <meta charset="UTF-8">
    
<title> Register </title>
    <link rel="stylesheet" href="register.css">
  
</head>

  <body>

<?php
	$password="";
	$confirm="";
	$bday="";

// Flag variable to track success:
$okay = TRUE;
if(isset($_POST['tried'])){  //if the form was submitted
	$email = $_POST['email'];
	$password = $_POST['password'];
	$confirm = $_POST['confirm'];
	$bday = $_POST['birthday']; 

	// Validate the password:
	if (empty($password)) {
		echo '<p class="error">Please enter your password.</p>';
		$okay = FALSE;
	}


	// Check the two passwords for equality:
	if ($password != $confirm) {
		echo '<p class="error">Your confirmed password does not match the original password.</p>';
		$okay = FALSE;
	}

	
}
	// If there were no errors, print a success message:
	if (isset($_POST['tried']) && $okay ) {  //if form was submitted and everything is good
		echo '<p>You have been successfully registered (but not really).</p>';
		echo "<p>You entered your birthday as $bday.</p>";
	}
	else {

?>



	<form action="register2.php" method="post">

	<p> Email Address:  <input type="text" value="<?php echo $email;?>" 
      		name="email" size="30" /><p>
    <p>Password: <input type="password" value="<?php echo $password;?>"
    		name="password" size="20" /></p>
	<p>Confirm Password: <input type="password" value="<?php echo $confirm;?>"
     		name="confirm" size="20" /></p>

	<p> Date of Birth: <input type="date" name="birthday" value="<?php echo $bday;?>" </p>
  		

</p>
<input type="submit" name="submit" value = "Register" />
<input type="hidden" name="tried" value="true">
</form>
<?php
	}
?>
</body>

</html>
