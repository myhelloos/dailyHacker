<?php

$config['db'] = array(
  'host' => 'localhost',
  'username' => 'root',
  'password' => '1234',
  'dbname' => 'website',
);

$db = new PDO('mysql:host=' . $config['db']['host'] . ';dbname=' . $config['db']['dbname'], $config['db']['username'], $config['db']['password']);
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$query = $db->prepare("SELECT `articles`.`title` FROM `aricles` WHERE `articles`.`title` LIKE :search");

$search = (isset($_GET['search']) === true) ? $_GET['search'] : '';
$query->bindValue(':search', '%' . $search . '%', PDO::PARAM_STR);

$query->execute();

echo '<pre>', print_r($query->errorInfo(), true), '</pre>';

$rows = $query->fetchAll(PDO::FETCH_ASSOC);
echo '<pre>' , print_r($rows, true), '</pre>';
