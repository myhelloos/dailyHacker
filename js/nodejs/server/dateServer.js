const url = require('url');
const http = require('http');

const port = process.argv[2];

var parsetime = (time) => {
  return {
    hour: time.getHours(),
    minute: time.getMinutes(),
    second: time.getSeconds()
  };
};

var unixtime = (time) => {
  return { unixtime : time.getTime() };
};

var server = http.createServer((req, res) => {
	var path = url.parse(req.url, true);
	var pathname = path.pathname;
	var datetime = new Date(path.query.iso);

	var result ;
	if (pathname == '/api/parsetime') {
		result = parsetime(datetime);
	} else if (pathname == '/api/unixtime') {
		result = unixtime(datetime);
	}

	if (result) {
    res.writeHead(200, { 'content-type': 'text/plain' });
	  res.end(result);
	}

  res.writeHead(404);
  res.end();
});

server.listen(port);
