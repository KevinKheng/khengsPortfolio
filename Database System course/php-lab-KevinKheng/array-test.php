<!-- conversions.php - demonstrates type conversions-->
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <title> Arrays </title>
  </head>
  <body>
    <?php
        $fruits = array("grape", "apple", "peach", "plum");

        for($i = 0; $i<count($fruits); $i++)
        	echo $fruits[$i]."<br/>";
        echo"<br/>";

        $students = array("George"=>1, "Jonathan"=>2, "Marek"=>3, "Alex"=>2, "Lauren"=>"group 2");
        foreach($students as $name=>$group)
           echo "$name is in group $group<br/>";
        ?>

  </body>
</html>
