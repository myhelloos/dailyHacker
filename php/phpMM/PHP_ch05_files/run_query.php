<?php                                                                                               
  require '../../scripts/database_connection.php';

  $query_text = $_REQUEST['query'];
  $result = mysql_query(mysql_real_escape_string($query_text));

  if (!$result) {
    die("<p>Error in executing the SQL query " . $query_text . ": " .
        mysql_error() . "</p>");
  }

  $return_rows = true;
  if (preg_match("/^[ \t\r\n]*(CREATE|INSERT|UPDATE|DELETE|DROP)/i", $query_text)) {
    $return_rows = false;
  }

  if ($return_rows) {
    // We have rows to show from the query
    echo "<p>Results from your query:</p>";
    echo "<ul>";
    while ($row = mysql_fetch_row($result)) {
      echo "<li>{$row[0]}</li>";
    }
    echo "</ul>";
  } else {
    // No rows. Just report if the query ran or not
    echo "<p>The following query was processed successfully:</p>";
    echo "<p>{$query_text}</p>";
  }
?>
