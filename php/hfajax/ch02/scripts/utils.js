/*
 * utils.js
 * Copyright (C) 2015 alfred <alfred@alfred-ThinkPad>
 *
 * Distributed under terms of the MIT license.
 */

function createRequest()
{
  // create a variable named "request"
  try {
    request = new XMLHttpRequest();
  } catch (tryMS) {
    try {
      request = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (ohterMS) {
      try {
        request = new ActiveXObject("Microsoft.XMLHTTP");
      } catch (failed) {
        request = null;
      }
    }
  }

  return request;
}

