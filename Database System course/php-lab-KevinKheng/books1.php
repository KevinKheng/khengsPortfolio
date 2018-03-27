<?php   

//post this to your webserver
header('content-type: application/json; charset=utf-8');
header("access-control-allow-origin: *");
@$mysqli = new mysqli('localhost', 'bookorama', 'cs440', 'books');


if ($mysqli->connect_error) {
    die('Connect Error ' . $mysqli->connect_errno . ': ' . 	
		$mysqli>connect_error);
}

$query="SELECT * FROM books"; 

if ($result = $mysqli->query($query)) 
{
	while($row = $result->fetch_array(MYSQLI_ASSOC))
	{
		$output[] = array_map("stripslashes", $row) ; 
	}
	print(json_encode($output));
}
$mysqli->close();

?>
