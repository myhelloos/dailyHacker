import {getUsefulContents} from "file.js";
getUsefulContents("http://www.example.com", data => {
  doSomethingUseful(data);
});
