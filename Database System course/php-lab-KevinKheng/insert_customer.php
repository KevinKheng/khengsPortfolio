<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

	<title>Insert a Record</title>
</head>
<body>
	  <?php 
	  @$db = new mysqli('localhost', 'bookorama', 'cs440', 'books');


	  if ($db->connect_error) {
		  die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	  }

	  $query="INSERT INTO customersVALUES (44, 'Barak Obama', '1600 Pennsylvania Avenue', 'Washington DC')";

		if ($db->query($query) === TRUE){    
			echo '<p> Record added </p>';
		}else{	
			echo '<p>Unable to insert record</p>';
		}



	  $db->close();

	  ?>
</body>
</html>