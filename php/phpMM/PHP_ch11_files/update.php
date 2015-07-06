<?php

require_once "../scripts/database_connection.php";

$update = "UPDATE users SET password = '" . crypt("greenfield", "mgreenf") . "' " .
          " WHERE user_id = 49";

$result = mysql_query($update);

?>
