<!DOCTYPE html>
<html>
<!-- powers.php
     An example to illustrate loops and arithmetic
     -->
<head>
        <meta charset="UTF-8">  
        <title>PHP and HTML</title>
</head>
<body>
            <?php
        $a = 7;
        $b = 7;
        if ($a == $b) {
           $a = 3 * $a;
        ?>
        <br /> At this point, $a and $b are 
         equal <br />
        So, we change $a to three times $a
        <?php
         }
         ?> 

  </body>
</html>
