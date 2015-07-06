<html> 
 <head> 
  <link href="../../css/phpMM.css" rel="stylesheet" type="text/css" /> 
 </head> 
 
 <body> 
  <div id="header"><h1>PHP & MySQL: The Missing Manual</h1></div> 
  <div id="example">Example 2-1</div> 
 
  <div id="content"> 
    <p>Here's a record of what information you submitted:</p>
    <p>
      First Name: <?php echo $_REQUEST['first_name']; ?><br />
      Last Name: <?php echo $_REQUEST['last_name']; ?><br />
      E-Mail Address: <?php echo $_REQUEST['email']; ?><br />
      Facebook URL: <?php echo $_REQUEST['facebook_url']; ?><br />
      Twitter Handle: <?php echo $_REQUEST['twitter_handle']; ?><br />
    </p>
  </div> 
 
  <div id="footer"></div> 
 </body> 
</html>
