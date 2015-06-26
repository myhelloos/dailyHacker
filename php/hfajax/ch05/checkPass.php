<?php
/**
 * Short description for checkPass.php
 *
 * @package checkPass
 * @author alfred <alfred@alfred-ThinkPad>
 * @version 0.1
 * @copyright (C) 2015 alfred <alfred@alfred-ThinkPad>
 * @license MIT
 */

sleep(1);

$password = $_REQUEST["password"];
if (preg_match("/^.*(?=.{6,})(?=.*[0-9])(?=.*[a-zA-z]).*$/", $password) === 0) {
  echo "denied";
} else {
  echo "okay";
}

