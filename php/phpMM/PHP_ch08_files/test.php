<?php
echo "DOCUMENT ROOT: {$_SERVER['DOCUMENT_ROOT']}";
$image_sample_path = "/home1/b/bmclaugh/yellowtagmedia_com/phpMM/uploads/profile_pics/1312128274-james_roday.jpg";
$web_image_path = str_replace($_SERVER['DOCUMENT_ROOT'], '', $image_sample_path);

echo "<br /><br />CONVERTED PATH: {$web_image_path}";
?>
