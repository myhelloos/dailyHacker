Flasky
======

From the O'Reilly book [Flask Web Development](http://www.flaskbook.com)

* test whether install virtualenv:
	`$ virtualenv --verison`
* install virtualenv (on linux):
	`$ sudo apt-get install python-virtualenv`
* create python virtual environment:
	`$virtualenv venv`
* start the virtual environment:
	`$ source venv/bin/activate`
* leave the virtual environment:
	`$ deactive`

* db upgrade
	1. `python manager.py db migrate -m "information"`
	2. `python manager.py db upgrade`

* db creaate
	1. `python manager.py shell`
	2. `db.create_all()`
