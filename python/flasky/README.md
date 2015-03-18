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
## Debug
###1. alembic.util.CommandError: No such revision or branch 
1. delete all the .sqllite files in my system (or drop the databases? not test)
2. delete the migration history (may not be necessary, not test)
3. init the db migration record `python manage.py db init`
4. migrate db `python manage.py db migrate -m "reinit database" `
5. upgrade db `python manage.py db upgrade`