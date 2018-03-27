<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Exercise 5 PHP Script</title>
</head>
<body>
    <h1>Book-O-Rama Catalog Search</h1>
<?php
	$searchtype=$_POST["searchtype"];
	$searchterm=trim($_POST["searchterm"]);
	if(!$searchtype || !$searchterm) {
		echo "You have not entered search details.  Please go back and try again.";
		exit;
	}
	@$db = new mysqli('localhost', 'kck15911', '', 'books');
	if ($db->connect_error) {
		die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	}
	$searchterm = "%".$searchterm."%";
	$query = "select * from books where $searchtype like ?";
	if ($stmt = $db->prepare($query)){
		$stmt->bind_param("s", $searchterm);
		$stmt->execute();
		$result =$stmt->store_result();
	  $num_results =  $stmt->num_rows;
	  echo "<p> Number of books found: $num_results";
	  $stmt->bind_result($isbn, $author, $title, $price);
	    /* fetch values */
	    while ($stmt->fetch()) {
	        echo "<p><strong>Title: ";
			echo htmlspecialchars(stripslashes($title));
			echo "</strong>";
			echo "<br />";
			echo "ISBN: ".stripslashes($isbn);
			echo "<br />";
			echo "Price: $". number_format($price,2);
			echo" </p>";
	    }
		/* close statement */
    	$stmt->close();
	}
	$db->close();
?>
</body>
</html>