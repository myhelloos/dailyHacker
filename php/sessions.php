<?php
require('db_sessions.inc.php');
?>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>数据库session测试</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
    // Store some data in the session, if no data is present:
    if (empty($_SESSION)) {
        $_SESSION['blah'] = 'umlaut';
        $_SESSION['this'] = '3615684.45';
        $_SESSION['that'] = 'blue';

        // Print a message indicating what's going on:
        echo '<p>Session data stored.</p>';
    } else { // Print the already-stored data;
        echo '<p>Session Data Existes:<pre>' , print_r($_SESSION, 1) , '</pre></p>';
    }

    // Log the user out, if applicable:
    if (isset($_GET['logout'])) {
        session_destroy();
        echo '<p>Session destoryed.</p>';
    } else { // Otherwise, print the "Log out" link:
        echo '<a href="index.php?logout=true">Log Out</a>';
    }

    // Reprint the session data:
    echo '<p>Session Data:<pre>', print_r($_SESSION, 1), '</pre></p>';

    // Complete the page:
    ?>
</body>
</html>
<?php

// Write and close the session:
session_write_close();
