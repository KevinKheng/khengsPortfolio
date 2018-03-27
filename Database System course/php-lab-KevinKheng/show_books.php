<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Show Books</title>
</head>
<body>
<?php 
	@ $db = new mysqli('localhost', 'kck15911', '', 'books');


	if ($db->connect_error) {
    	die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	}

	$query="SELECT * FROM books"; 
	//$result = $db->query($query);
	
	if ($result = $db->query($query)) {
	
	    //find size of result set
		$num_results = $result->num_rows;
		$num_fields = $result->field_count;

		echo "<table border='0'>";
		echo "<tr>";

		//get and display field names
		$dbinfo = $result->fetch_fields();


		foreach ($dbinfo as $val) {
			echo "<th>".$val->name."</th>";
		}
	
		echo "</tr>";
	
		while($row = $result->fetch_row())	{
			echo "<tr>";
			for($i=0; $i<$num_fields; $i++){
				echo "<td>". stripslashes($row[$i])."</td>";
			}
			echo "</tr>";
		}
	
		$result->close();
		echo "</table>";
}

	$db->close();

?>
</body>
</html>

