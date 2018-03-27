<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Book-O-Rama Search Results</title>
</head>

<body>
	<h1> Book-O-Rama Search Results </h1>
<?php	
		
	@$db = new mysqli('localhost', 'bookorama', 'cs440', 'books');


	if ($db->connect_error) {
		die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	}
	
	echo "<p>It works</p>";

	
	$db->close();
?>
</body>

</html>