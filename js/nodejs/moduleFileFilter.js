const path = require('path');
const fs = require('fs');

module.exports = (dir, extName, callback) => {
	var ext = '.' + extName;

	var files = fs.readdir(dir, (err, files) => {
		if (err) return callback(err);

		var elements = list.filter((file) => {
			return path.extname(file) === ext;
		})
		
		callback(null, elements);
	});
}

const myModule = require('./myModule.js');

myModule(process.argv[2], process.argv[3], (err, data) => {
	if (err) console.log(err);
	data.forEach((file) => {
			console.log(file);
	});
});
