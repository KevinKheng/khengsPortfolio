<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <?php
        $passState;
        $email = $_POST['email'];
        //echo $email;
        $pass1 = $_POST['pass1'];
        $pass2 = $_POST['pass2'];
        if ($pass1 != $pass2){
            echo "YOU FUCKED UP";
            $passState = false;
            
        }else {
            echo "GOOD SHIT";
            $passState = true;
        }
     ?>
     
<h2>Cell that spans two columns:</h2>
<table style="width:100%">
  <tr>
    <th>Email</th>
    <th>Matching password</th>
  </tr>
  <tr>
    <td><?php echo $email; ?></td>
    <td><?php echo $passState; ?></td>
  </tr>
</table>

</body>
</html>



<style>
table, th, td {
    border: 1px solid black;
}
tr {
    text-align: center;
}
</style>