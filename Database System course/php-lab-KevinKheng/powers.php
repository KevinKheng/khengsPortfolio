<!DOCTYPE html>
<html>
<!-- powers.php
     An example to illustrate loops and arithmetic
     -->
<head>
        <meta charset="UTF-8">  
        <title>powers.php</title>
</head>
<body>
    <table border = "1">
      <caption> Powers table </caption>
      <tr>
	<th> Number </th>
	<th> Square Root </th>
	<th> Square </th>
	<th> Cube </th>
	<th> Quad </th>
      </tr>
      <?php
	for ($number = 1; $number <=10; $number++) {
	  $root = sqrt($number);
	  $square = pow($number, 2);
	  $cube = pow($number, 3);
	  $quad = pow($number, 4);
	  echo("<tr align = 'center'> <td> $number </td>");
	  echo("<td> $root </td> <td> $square </td>");
	  echo ("<td> $cube </td> <td> $quad </td> </tr>");
	}
      ?>
    </table>
  </body>
</html>
