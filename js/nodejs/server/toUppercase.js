const http = require('http');
const map = require('through2-map')

const port = process.argv[2];

var server = http.createServer(function (req, res) {
	if (req.method == 'POST') {
			res.writeHead(200, { 'content-type': 'text/plain' })

			req.pipe(map(function (chunk) {
				return chunk.toString().toUpperCase();
			})).pipe(res)
	}
});

server.listen(port);
