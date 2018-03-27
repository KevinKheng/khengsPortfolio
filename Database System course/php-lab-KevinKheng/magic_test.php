<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test</title>
</head>
<body>
<?php if(get_magic_quotes_gpc())
			echo "magic quotes on";
		else
			echo "magic quotes off";
?>
</body>
</html>