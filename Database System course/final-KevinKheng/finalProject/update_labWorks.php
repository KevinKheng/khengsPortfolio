<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Edit Lab Works</title>
</head>

<body>
	<h1> Lab Works Updated </h1>
<?php
	$assignID=$_POST["Assignment ID"];
  	$assignmentName=$_POST["Assignment Name"];
  	$employeeId=$_POST["Employee Id"];
  	$projectId=$_POST["Project ID"];
    $serialNoId=$_POST["Serial No. Id"];
 

	if(!$assignID || !$assignmentName || !$employeeId || !$projectID||!$serialNoId) {
		echo "You have not entered all required details.  Please go back and try again.";
		exit;
	}

	//format input
	$assignID = addslashes($assignID);
  	$assignmentName = addslashes($assignmentName);
  	$employeeId = addslashes($employeeId);
  	$projectId = addslashes($assignID);
    $serialNoId= addslashes($serialNoId);

	//connect to the database
	@$db = new mysqli('localhost', 'kck15911', '', 'labWorks');


	if ($db->connect_error) {
		die('Connect Error ' . $db->connect_errno . ': ' . $db->connect_error);
	}

	$query = "update assignment SET assignmentName = ? WHERE assignId =?";
	if(	$stmt = $db->prepare($query)){
		$stmt->bind_param("ssss",$assingmentName, $employeeId, $projectId,$serialNoId);
	  $stmt->execute();

    if ($stmt->affected_rows == 1){
    	echo "<h2>New Values:</h2>";
    	echo "<strong>Assignment ID: </strong>". $assignID . "<br/>";
    	echo "<strong>Assignment Name: </strong>". $assingmentName . "<br/>";
    	echo "<strong>Employee Id: </strong>". $employeeId. "<br/>";
    	echo "<strong>Project Id: </strong>". $projectId. "<br/>";
    	echo "<strong>Serial No Id: </strong>". $serialNoId. "<br/>";
    	
    }
}else{
	 echo "Prepare failed: (" . $mysqli->errno . ") " . $mysqli->error;
}

$db->close();

?>
<a href="show_labWorks.php">Return to labWorks</a>
</body>

</html>
