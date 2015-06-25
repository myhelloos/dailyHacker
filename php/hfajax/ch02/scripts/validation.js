/*
 * validation.js
 * Copyright (C) 2015 alfred <alfred@alfred-ThinkPad>
 *
 * Distributed under terms of the MIT license.
 */
window.onload = initPage;

function initPage()
{
  document.getElementById("username").onblur =
    checkUsername;
  document.getElementById("register").disabled = true;
}

function checkUsername()
{
  // get a rquest object and send it to the server
  document.getElementById("username").className = "thinking";
  request = createRequest();
  if (request != null) {
    var theName = document.getElementById("username").value;
    var username = escape(theName);
    var url = "checkName.php?username=" + username;

    request.onreadystatechange = showUsernameStatus;
    request.open("GET", url, true);
    request.send(null);
  } else {
    alert("Unable to create request");
  }
}

function showUsernameStatus()
{
  if (request.readyState == 4 && request.status == 200) {
    if (request.responseText == "okay") {
      // if it's okay, no error message to show
      document.getElementById("username").className = "approved";
      document.getElementById("register").disabled = false;
    } else {
      // if there's a problem, we'll tell the user
      document.getElementById("username").className = "denied";
      document.getElementById("username").focus();
      document.getElementById("username").select();
      document.getElementById("register").disabled = true;
    }
  }
}

