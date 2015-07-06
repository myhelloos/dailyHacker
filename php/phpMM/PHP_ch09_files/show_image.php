<?php

require '../scripts/app_config.php';
require '../scripts/database_connection.php';

try {
  if (!isset($_REQUEST['image_id'])) {
    handle_error("no image to load was specified.");
  }

  $image_id = $_REQUEST['image_id'];

  // Build the SELECT statement
  $select_query = sprintf("SELECT * FROM images WHERE image_id = %d",
                          $image_id);

  // Run the query
  $result = mysql_query($select_query);

  if (mysql_num_rows($result) == 0) {
    handle_error("we couldn't find the requested image.",
                 "No image found with an ID of " . $image_id . ".");
  }

  $image = mysql_fetch_array($result);

  header('Content-type: ' . $image['mime_type']);
  header('Content-length: ' . $image['file_size']);

  echo $image['image_data'];
} catch (Exception $exc) {
  handle_error("something went wrong loading your image.",
               "Error loading image: " . $exc->getMessage());
}
?>
