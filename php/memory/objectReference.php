<?php
$fp = fopen('foo.txt', 'r');
$otherVar = $fp;
fwrite($fp, "One\n");
fwrite($otherVar, "Two\n");
fclose($fp);

/* This fails, because the file is closed */
fwrite($otherVar, "Three\n");
