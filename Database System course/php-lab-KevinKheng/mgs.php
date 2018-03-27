<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Show Products</title>
</head>
<body>
<?php 
	@ $db = new mysqli('localhost', 'cs330', 'database', 'my_guitar_shop');


	if ($db->connect_error) {
    	die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	}

	$query="select category_name, product_name, list_price from products join categories on products.category_id = categories.category_id;"; 
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

