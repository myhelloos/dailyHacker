const http = require('http');
const fs = require('fs');

const port = process.argv[2];
const filename = process.argv[3];

var server = http.createServer(function (req, res) {
	res.writeHead(200, { 'content-type': 'text/plain' })  
	   
	fs.createReadStream(filename).pipe(res)  
});

server.listen(8000);
