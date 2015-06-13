<?php

// Please change the db settings below to match your config

$config['db'] = array(
    'host' => 'localhost',
    'username' => 'root',
    'password' => '1234',
    'dbname' => 'website',
);

$db = new PDO('mysql:host=' . $config['db']['host'] . ';dbname=' . $config['db']['dbname'], $config['db']['username'], $config['db']['password']);
$query = $db->query("SELECT `articles`.`title` FROM `articles`");
echo "<pre>";
    print_r($query);
echo "</pre>";
$result = $query->fetchAll();
echo "<pre>";
    print_r($result);
echo "</pre>";
