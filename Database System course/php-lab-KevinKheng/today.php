<!-- today.php - A trivial example to illustrate a php document -->
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <title> today.php </title>
  </head>
  <body>
    <p>
      <?php
        echo "<strong>Welcome to my home page <br /> <br />";
        echo "Today is:</strong> ";
        echo date("l, F jS");
      ?>
    </p>
  </body>
</html>
