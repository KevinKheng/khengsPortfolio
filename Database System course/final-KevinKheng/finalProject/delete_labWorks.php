<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Lab Works Delete</title>
</head>

<body>

    <?php

    if(isset($_GET["id"]) && !empty(trim($_GET["id"]))){
      $id = trim($_GET["id"]);

    	@$db = new mysqli('localhost', 'kck15911', '', 'labWorks');

    	if ($db->connect_error) {
    		die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
    	}

      // Prepare a select statement
      $sql = "DELETE FROM assignment WHERE assignId = ?";

      if($stmt = $db->prepare($sql)){
          $stmt->bind_param("s", $id);
          if ($stmt->execute()){
              echo "<h2>Labs Deleted</h2>";
          }else{
              echo "<h2>Something went wrong. Please try again later.</h2";
          }
      }
    }

    ?>

	<a href="show_labWorks.php">Return to labWorks</a>
</body>

</html>
