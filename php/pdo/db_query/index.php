<?php

/*
 * There are extra lines of code added to this file, that are used in the
 * lecture.  This code below represents the last point of the video.
 * So uncomment or comment the code respectfully when working through
 * this lecture.
 * Also please change the db settings below to match your config
 */

$config['db'] = array(
    'host' => 'localhost',
    'username' => 'root',
    'password' => '1234',
    'dbname' => 'website',
);

$db = new PDO('mysql:host=' . $config['db']['host'] . ';dbname=' . $config['db']['dbname'], $config['db']['username'], $config['db']['password']);
$query = $db->query("SELECT `articles`.`title`, `articles`.`id`  FROM `articles`");

// FETCH_NUM will return the element number instead
/*$rows = $query->fetchAll(PDO::FETCH_ASSOC);
echo '<pre>', print_r($rows, true), '</pre>';*/

// Fetch a specific article's title from the db

$articles = $query->fetchAll(PDO::FETCH_ASSOC);
echo $articles[4]['title'];

// Show all the results from the db
/*while ($row = $query->fetch(PDO::FETCH_ASSOC)) {
    echo $row['title'], '<br>';
}*/
