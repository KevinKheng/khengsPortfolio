<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Book-O-Rama Book Entry Results</title>
</head>

<body>
	<h1> Book-O-Rama Book Entry Results </h1>
<?php	
	$isbn=$_POST["isbn"];
	$author=$_POST["author"];
	$title=$_POST["title"];
	$price=$_POST["price"];
	
	if(!$isbn || !$author || !$title || !$price) {
		echo "You have not entered all required details.  Please go back and try again.";
		exit;
	}
	
	//format input
	$isbn = addslashes($isbn);
	$author = addslashes($author);
	$title = addslashes($title);
	$price = doubleval($price);
	
	//connect to the database
	@$db = new mysqli('localhost', 'kck15911', '', 'books');


	if ($db->connect_error) {
		die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	}

	  
	$query = "insert into books values (?, ?, ?, ?)";
	$stmt = $db->prepare($query);
	$stmt->bind_param("sssd", $isbn, $author, $title, $price);
    $stmt->execute();
    echo $stmt->affected_rows." book inserted into database";
    
	mysqli_close($dbc);
?>
</body>

</html>
