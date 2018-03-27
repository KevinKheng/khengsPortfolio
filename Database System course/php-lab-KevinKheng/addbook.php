<?php	
	$isbn=$_POST["isbn"];
	$author=$_POST["author"];
	$title=$_POST["title"];
	$price=$_POST["price"];
	
	
	@$mysqli = new mysqli('localhost', 'bookorama', 'cs440', 'books');
	if ($mysqli->connect_error) {
    die('Connect Error ' . $mysqli->connect_errno . ': ' . 	
		$mysqli>connect_error);
	}

	$query = "insert into books values ('$isbn', '$author', '$title', $price);";
	$result = $mysqli->query($query);
	if($result) 
		echo "added";
	else
		echo "failed";
	
	
	$mysqli->close();

?>