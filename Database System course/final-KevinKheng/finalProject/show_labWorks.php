<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Show LabWork</title>
</head>
<body>
<h1>Labs Assignment</h1>
<?php
	@ $db = new mysqli('localhost', 'kck15911', '', 'labWorks');


	if ($db->connect_error) {
    	die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	}

	$query="SELECT * FROM assignment";
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
      //add this for edit and delete functions
			echo "<td>";
			echo "<a href='edit_labWorks.php?id=". $row[0] ."'>Edit</a>";
            echo "</td>";
            echo "<td>";
			echo "<a href='delete_labWorks.php?id=". $row[0] ."'>Delete</a>";
            echo "</td>";
			echo "</tr>";
		}

		$result->close();
		echo "</table>";
		echo "<br/><a href='add_labWorks.html'>Add a lab</a>";
}

	$db->close();

?>
</body>
</html>
