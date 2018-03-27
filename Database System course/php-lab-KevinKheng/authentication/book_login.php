<?php
if(isset($_GET['logout'])){
	session_start();
	// remove all session variables
	session_unset(); 
	
	// destroy the session 
	session_destroy(); 
}


ob_start();

// Print some introductory text:
echo '<!DOCTYPE html><html><head> <meta charset="UTF-8"><title>Login</title></head>';
echo '<body><h1>Login Form</h1>';

// Check if the form has been submitted:
if(isset($_POST['submitted']) ) {
		$username = trim(stripslashes($_POST['username']));
		$password = trim(stripslashes($_POST['password']));
		if(($password == '') || ($username == '')){ // Forgot a field.
			echo '<p>Please make sure you enter both an email address and a password!</p>';
		}else {
	
					
			//open database connection
			@ $db = new mysqli('localhost', 'bookorama', 'cs440', 'books');


			if ($db->connect_error) {
				die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
			}

			$query = "SELECT password FROM users WHERE  name = '".$username."'";
			$result = $db->query($query);
			$num_results = $result->num_rows;
			if($num_results == 1){
				$row = $result->fetch_assoc();
				$hash_stored = $row['password'];
				$parts = explode('$', $hash_stored);
				$method = $parts[1];
				$rounds = $parts[2];
				$salt = $parts[3];
				$test_hash = crypt($password, '$'.$method.'$'.$rounds.'$'.$salt.'$');
				if($test_hash == $hash_stored){
    				session_start();
           			$_SESSION['username'] = $username;
           
            		//redirect
            		header( 'Location: home.php?sessionid='.session_id());
				}else{
					echo '<h2>Invalid password!<br />Try again.</h2>';
				}

			}else { // Incorrect!
				echo '<h2>User name not found!<br />Try again.</h2>';	
			}
			

		}

} ?>



	<form action="book_login.php" method="post">
		<p>User: <input type="text" name="username" size="20" /></p>
		<p>Password: <input type="password" name="password" size="20" /></p>
		<p><input type="submit" name="submit" value="Log In!" /></p>
		<input type="hidden" name="submitted" value="true" />

	</form>
</body>
</html>
