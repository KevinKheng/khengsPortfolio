<?php   //post this to your webserver
@$mysqli = new mysqli('localhost', 'bookorama', 'cs440', 'books');


if ($mysqli->connect_error) {
    die('Connect Error ' . $mysqli->connect_errno . ': ' . 	
		$mysqli->connect_error);
}

$query="SELECT * FROM books where isbn='0857522329'"; 

if ($result = $mysqli->query($query)) 
{
	while($row = $result->fetch_array(MYSQLI_ASSOC))
	{
		$output[] = array_map("stripslashes", $row) ; 
	}

	//print("{\"JSONDataResult\":");
	print(json_encode($output));
	//print("}");
}
$mysqli->close();

?>
