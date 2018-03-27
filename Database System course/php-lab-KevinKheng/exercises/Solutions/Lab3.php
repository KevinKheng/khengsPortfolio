<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="1">
    <title>Exercise3 ANSWER!</title>
</head>
<body>
    <?php
    
        function myclock() {
            echo "This is the myclock, a random clock.";
            $min = 0;
            $max = 23;
            $hours = rand($min,$max);
            echo("<br>The time is " . $hours . "<br>");
            
            if ($hours > "12") {
                echo "Good afternoon";
            }else if ($hours == "12") {
                echo "ITS HIGH NOON, doot doot motherfucker";
            }else {
                echo "Good morning";
            }
            echo "<br>";
        } 
        
        myclock();
        
        function loopDown() {
            echo "<br> This is the loopDown, a Loop that prints numbers";
            for ($x = 0; $x <= 10; $x++) {
                echo "The number is: $x <br>";
            } 
        }
        
        loopDown();
        
        function whileUP() {
            echo "<br>This is the while loopDown";
            $x = 1;
            while($x <= 10) {
                echo "The number is: $x <br>";
                $x++;
            } 
        }
        
        whileUP()
    ?>
</body>
</html>