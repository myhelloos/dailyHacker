<?php
$elements = array();

////
// An array of 10,000 elements with random string values
////
for($i = 0; $i < 10000; $i++) {
        $elements[] = (string)rand(10000000, 99999999);
}

$time_start = microtime(true);

////
// for test
////
$arraySize = count($elements);
for($i = 0; $i < $arraySize; $i++) { }

$time_end = microtime(true);
$for_time = $time_end - $time_start;

$time_start = microtime(true);

////
// foreach test
////
foreach($elements as $element) { }

$time_end = microtime(true);
$foreach_time = $time_end - $time_start;

echo "For took: " . number_format($for_time * 1000, 3) . "ms\n";
echo "Foreach took: " . number_format($foreach_time * 1000, 3) . "ms\n";
