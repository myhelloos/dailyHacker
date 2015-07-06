<?php

session_start();

unset($_SESSION['user_id']);
unset($_SESSION['username']);
//setcookie('user_id', '', time()-(365*24*60*60));
//setcookie('username', '', time()-(365*24*60*60));

header('Location: signin.php');
exit();
?>
