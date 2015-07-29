<?php

// The session table create sql:
// CREATE TABLE sessions (
//     id CHAR(32) NOT NULL,
//     data TEXT,
//     last_accessed TIMESTAMP NOT NULL,
//     PRIMARY KEY (id)
// );

// Global variable used for the database connections in all session functions
$sdbc = NULL;

// Define the open_session() function:
// This funtion takes no arguments
// This function should open the database connection
// This function should return true
function open_session() {
    global $sdbc;

    // connect to the database:
    $sdbc = mysqli_connect('localhost', 'root', '', 'test') or die("Error " . mysqli_error($sdbc)); ;

    return true;
} // End of open_session() function.

// Define the close_session() function:
// This function takes no arguments
// This function close the database connection
// This function return the closed status
function close_session() {
    global $sdbc;

    return mysqli_close($sdbc);
} // End of close_session() function.

// Define the read_session() function:
// This function takes one argument: the session ID
// This function retrives the session data
// This function returns the session data as a string
function read_session($sid) {
    global $sdbc;

    // Query the database:
    $sql = sprintf('SELECT data FROM sessions WHERE id="%s"', mysqli_real_escape_string($sdbc, $sid));
    $result = mysqli_query($sdbc, $sql);

    // Retrive the result
    if (mysqli_num_rows($result) == 1) {
        list($data) = mysqli_fetch_array($result, MYSQLI_NUM);

        // Return the data
        return $data;
    } else { // Return an empty string.
        return '';
    }
} // End of read_session() function.

// Define the write_session() function:
// This function takes two arguments:
// The session ID and the session data
function write_session($sid, $data) {
    global $sdbc;

    // Store in the database:
    $sql = sprintf('REPLACE INTO sessions (id, data) VALUES ("%s", "%s")',
        mysqli_real_escape_string($sdbc, $sid), mysqli_real_escape_string($sdbc, $data));
    $result = mysqli_query($sdbc, $sql);

    return true;
} // End of write_session() function.

// Define the destroy_session() fucntion:
// This function take one argument: the session ID.
function destroy_session($sid) {
    global $sdbc;

    // Delete from the database:
    $sql = sprintf('DELETE FROM sessions WHERE id="%s"', mysqli_real_escape_string($sdbc, $sid));
    $result = mysqli_query($sdbc, $sql);

    // Clear the $_SESSION array;
    $_SESSION = array();

    return true;
} // End of destroy_session() function.

// Define the clean_session() function
// This function takse one argument: a value in seconds/
function clean_session($expire) {
    global $sdbc;

    // Delete old sessions:
    $sql = sprintf('DELETE FROM sessions WHERE DATE_ADD(last_accessed, INTERVAL %d SECOND) < NOW()',
        (int) $expire);
    $result = mysqli_query($sdbc, $sql);

    return true;
} // END of clean_session() function.

# ************************************ #
# ***** END OF FUNCTIONS ***** #
# *********************************** #

// Declare the function to use:
session_set_save_handler('open_session', 'close_session', 'read_session', 'write_session', 'destroy_session', 'clean_session');

// Start the session:
session_start();

