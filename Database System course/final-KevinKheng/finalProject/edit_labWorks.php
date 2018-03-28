<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Lab Works Edit</title>
</head>

<body>

    <?php

    if(isset($_GET["id"]) && !empty(trim($_GET["id"]))){
       $id = trim($_GET["id"]);
	     @$db = new mysqli('localhost', 'kck15911', '', 'labWorks');

    	if ($db->connect_error) {
    		die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
    	}

      $sql = "SELECT * FROM assignment WHERE assignID = ?";

      if($stmt = $db->prepare($sql)){
        $stmt->bind_param("s", $id);
        $stmt->execute();
        $result =$stmt->store_result();
  	    $stmt->bind_result($assignId, $assignmentName, $employeeId, $projectID,$serialNoId);
  	    $stmt->fetch();
        $stmt->close();
      }
  }

            ?>

	<form action="update_labWorks.php" method="post">
		<input type="hidden" name="assignId" value="<?php echo $assignId?>"/>
		<p>AssignmentName <input type="text" name="assignmentName" maxlength="30" size="30"value="<?php echo $assignmentName?>"/></p>
		<input type="submit" name="submit" value="Update" />
	</form>
</body>

</html>
