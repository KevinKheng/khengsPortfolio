<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Lab Works Search Results</title>
</head>

<body>
	<h1> Lab Works Search Results </h1>
<?php
	$searchtype=$_POST["searchtype"];
	$searchterm=trim($_POST["searchterm"]);

	if(!$searchtype || !$searchterm) {
		echo "You have not entered search details.  Please go back and try again.";
		exit;
	}

	@$db = new mysqli('localhost', 'kck15911', '', 'labWorks');


	if ($db->connect_error) {
		die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	}

	$searchterm = "%".$searchterm."%";
	$query = "SELECT * FROM assignment where $searchtype like ?";
	
	
	

	if ($stmt = $db->prepare($query)){
		$stmt->bind_param("s", $searchterm);
		$stmt->execute();
		$result =$stmt->store_result();
	  $num_results =  $stmt->num_rows;
	  echo "<p> Number of labs found: $num_results";
	  $stmt->bind_result($assignId,$assignmentName,$employeeId,$projectId,$serialNoId);

	    /* fetch values */
	    while ($stmt->fetch()) {
	        echo "<p><strong>Assignment Name: ";
			echo htmlspecialchars(stripslashes($assignmentName));
			echo "</strong>";
			echo "<br />";
			echo "Employee Id: ".stripslashes($employeeId);
			echo "<br />";
			echo "Project Id:".stripslashes($projectId);
		
			
			
			echo" </p>";
	    }
		/* close statement */
    	$stmt->close();
	}

	$db->close();
?>
</body>

</html>
