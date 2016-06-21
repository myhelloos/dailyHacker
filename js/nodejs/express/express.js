const express = require('express');
const path = require('path');
const bodyparser = require('body-parser');
const stylus = require('stylus');
const crypto = require('crypto');
const fs = require('fs');

const app = express();
app.set('view engine', 'jade');

const port = process.argv[2];

const publicPath = process.argv[3] || path.join(__dirname, 'public');
const templatePath = process.argv[3] || path.join(__dirname, 'templates');
const stylusPath = process.argv[3] || __dirname + '/public';
const bookName = process.argv[3];

app.set('views', templatePath);

app.use(express.static(publicPath));
app.use(bodyparser.urlencoded({extended: false}))
app.use(stylus.middleware(stylusPath));

app.get('/home', (req, res) => {
	res.render('index', {date: new Date().toDateString()})
});

app.post('/form', (req, res) => {
	res.send(req.body.str.split('').reverse().join(''));
});

app.put('/message/:id', (req, res) => {
	res.send(crypto.createHash('sha1')
		.update(new Date().toDateString() + req.params.id)
		.digest('hex'));
});

app.get('/search', (req, res) => {
	res.send(req.query);
});

app.get('/books', (req, res) => {
	fs.readFile(bookName, (err, data) => {
		if (err) res.send(500);
		var books;
		try {
			books = JSON.parse(data);
		} catch {
			res.send(500);
		}
		res.json(books);
	});
});

app.listen(port);
