<?php

$config['db'] = array(
    'host' => 'localhost',
    'username' => 'root',
    'password' => '1234',
    'dbname' => 'website',
);

$db = new PDO('mysql:host=' . $config['db']['host'] . ';dbname=' . $config['db']['dbname'], $config['db']['username'], $config['db']['password']);

$db->query("INSERT INTO `articles` (`articles`.`title`)  VALUES ('PDO Tutorial')");
header('Location: posts.php?id=' . $db->lastInsertId());
exit();
