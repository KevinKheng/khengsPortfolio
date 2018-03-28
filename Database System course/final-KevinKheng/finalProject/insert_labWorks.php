<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Labs Insertion Results </title>
</head>

<body>
	<h1> Labs Insertion Results </h1>
  <?php
  	$assignId=$_POST["Assignment ID"];
  	$assignmentName=$_POST["Assignment Name"];
  	$employeeId=$_POST["Employee Id"];
  	$projectId=$_POST["Project ID"];
    $serialNoId=$_POST["Serial No. Id"];
   
    
  	if(!$assignId || !$assignmentName || !$employeeId || !$projectId||!$serialNoId) {
  		echo "You have not entered all required details. Go <a href='add_labWorks.html'>back</a> and try again.";
  		exit;
  	}

  	//format input
  	$assignId = intval($assignId);
  	$assignmentName = addslashes($assignmentName);
  	$employeeId = addslashes($employeeId);
  	$projectId = addslashes($assignId);
    $serialNoId= addslashes($serialNoId);
  
  	
  	//connect to the database
  	@$db = new mysqli('localhost', 'kck15911', '', 'labWorks');

  	if ($db->connect_error) {
  		die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
  	}

  	$query = "Insert into assignment values (?, ?, ?, ?,?)";
    if( $stmt = $db->prepare($query)){
    	$stmt->bind_param("issss", $assignId,$assignmentName,$employeeId,$projectId,$serialNoId);
      $stmt->execute();
      echo $stmt->affected_rows." labWorks inserted into database";

      /* close statement */
        $stmt->close();
    }

  	$db->close();
  ?>

  <br/>
  <a href="show_labWorks.php">Return to labWorks</a>
</body>

</html>
