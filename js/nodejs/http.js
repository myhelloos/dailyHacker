var http = require('http')  
   
 http.get(process.argv[2], function (response) {  
   response.setEncoding('utf8')  
   response.on('data', console.log)  
   response.on('error', console.error)  
 }).on('error', console.error) 

var http = require('http')

http.get(process.argv[2], (res) => {
	var data = [];
	res.setEncoding('utf8')
	   .on('data', (chunk) => {
			data.push(chunk);
		})
	   .on('end', () => {
			var result = data.join('');
			console.log(result.length);
			console.log(result);
		});
})


const http = require('http')

var urls = process.argv.slice(2, process.argv.length);

var results = new Array(urls.length);
var waiting = urls.length;

var complete = () => {
	if (!waiting) {
		results.forEach((result) => {
			console.log(result);
		});
	}
}

urls.forEach((url, index) => {
	http.get(url, (res) => {
		var data = [];
		res.setEncoding('utf8')
		   .on('data', (chunk) => {
				data.push(chunk);
			})
		   .on('end', () => {
				results[index] = data.join('');
				waiting--;
				complete();
			});
	});
});
