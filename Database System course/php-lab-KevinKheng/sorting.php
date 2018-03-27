<!DOCTYPE html >

<!-- sorting.php - An example to illustrate several of the
     sorting functions
     -->
<html>
  <head>
    <title> Sorting </title>
  </head>
  <body>
    <?php
      $original = array("Fred" => 31, "Al" => 27,
                        "Gandalf" => "wizard",
		        "Betty" => 42, "Frodo" => "hobbit");
    ?>
    <h4> Original Array </h4>
    <?php
      foreach ($original as $key => $value)
	   echo("[$key] => $value <br />");

      $new = $original;
      sort($new);
    ?>
    <h4> Array sorted with sort </h4>
    <?php
      foreach ($new as $key => $value)
		echo("[$key] = $value <br />");

      $new = $original;
      asort($new);
    ?>
    <h4> Array sorted with asort </h4>
    <?php

	foreach ($new as $key => $value)
		echo("[$key] = $value <br />");

      $new = $original;
      ksort($new);
    ?>
    <h4> Array sorted with ksort </h4>
    <?php

      foreach ($new as $key => $value)
        print("[$key] = $value <br />");
    ?>
  </body>
</html>
