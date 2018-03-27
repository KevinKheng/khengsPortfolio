<?php


$password = 'password123';
$encrypted = crypt('flyers2016','1234');
echo $encrypted."<br/>";


// generate a 16-character salt string
$salt = substr(str_replace('+','.',base64_encode(md5(mt_rand(), true))),0,16);

// how many times the string will be hashed
$rounds = 10000;

// pass in the password, the number of rounds, and the salt
// $5$ specifies SHA256-CRYPT, use $6$ if you want SHA512
$hash_stored = crypt($password, '$5$rounds='.$rounds.'$'. $salt.'$');


echo "Hash stored: " .$hash_stored."<br/>";

// the hash  to stored for the user
$test_pw = 'password123';

// extract the hashing method, number of rounds, and salt from the stored hash
// and hash the password string accordingly
$parts = explode('$', $hash_stored);
$method = $parts[1];
$rounds = $parts[2];
$salt = $parts[3];
$test_hash = crypt($test_pw, '$'.$method.'$'.$rounds.'$'.$salt.'$');

// compare
echo "Test Hash:  ". $test_hash . "<br/>" ;
if($hash_stored === $test_hash)
	echo "true";
else
	echo "false";


?>
