<?php

$obj = (object) ['value' => 1];

function fnByVal($val) {
    // $val = 100;
    $val->value = "abc";
}

function fnByRef(&$ref) {
    $ref = 100;
}

// The by-value function does not modify $obj, the by-reference function does:

fnByVal($obj);
var_dump($obj); // stdClass(value => 1)
fnByRef($obj);
var_dump($obj); // int(100)
