<?php
$stringToSearch = "Martin OMC-28LJ";
$regex = "/OM/";
$num_matches = preg_match($regex, $stringToSearch);

if ($num_matches > 0) {
  echo "Found ", $num_matches, " mathch(es)!", PHP_EOL;
} else {
  echo "No match. Sorry.", PHP_EOL;
}

// This will match
echo "Matches: " . preg_match("/(Mr|Dr). Smith/", "Mr. Smith"), PHP_EOL;

// So will this
echo "Matches: " . preg_match("/(Mr|Dr). Smith/", "Dr. Smith"), PHP_EOL;

// Matches
echo "Matches: " . preg_match("/^ (MR|DR). sMiTH$/i", " Dr. Smith") . "\n";
// Does NOT match
echo "Matches: " . preg_match("/^ (MR|DR). sMiTH$/i", "     Dr. Smith") . "\n";
// Matches
echo "Matches: " . preg_match("/^ +(MR|DR). sMiTH$/i", "     Dr. Smith") . "\n";

