<?php

require_once "../scripts/database_connection.php";

$update = "UPDATE users SET password = '" . crypt("esomogyi", "esomogyi") . "' " .
          " WHERE username = 'esomogyi'";

$result = mysql_query($update);

?>
