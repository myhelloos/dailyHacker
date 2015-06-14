<?php

$config['db'] = array(
    'host' => 'localhost',
    'username' => 'root',
    'password' => '1234',
    'dbname' => 'website',
);

$db = new PDO('mysql:host=' . $config['db']['host'] . ';dbname=' . $config['db']['dbname'], $config['db']['username'], $config['db']['password']);
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
try {
  // start transaction
  $db->beginTransaction();

  // query 1
  $db->query("INSERT INTO `articles` (`articles`.`title`) VALUEs ('Another PDO Tutorial')");
  // query 2
  $db->query("UPDATE `articles` SET `articles`.`view` = 1 WHERE `id`= " . $db->lastInsertId());

  // commit
  $db->commit();
} catch (PDOException $e) {
  // rollback
  $db->rollBack();
  // output error
  die($e->getMessage());
}
