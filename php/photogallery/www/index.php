<?php

// change the following paths if necessary
$yii='/home/alfred/git/Yii/yii.php';
$config=dirname(__FILE__).'/../protected/config/main.php';

function d21($what, $where='fb.somewhere') {
    $what = print_r($what, true);
    Yii::log($what, 'info', 'application.' . $where);
}

// remove the following lines when in production mode
defined('YII_DEBUG') or define('YII_DEBUG',true);
// specify how many levels of call stack should be shown in each log message
defined('YII_TRACE_LEVEL') or define('YII_TRACE_LEVEL',3);

require_once($yii);
Yii::createWebApplication($config)->run();