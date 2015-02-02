# -*- coding:utf-8 -*-
from sys import argv
script, filename = argv

txt = open(filename)
print "Here's your file %r:" % filename
print txt.read()

print "Type the filename again."
file_again = raw_input('> ');

txt_again = open(file_again)

print txt_again.read()

txt.close()
txt_again.close()

'''
A function is a piece of code that is called by name. It can be passed data to
    operate on (ie. the parameters) and can optionally return data (the return value).
    All data that is passed to a function is explicitly passed.
A method is a piece of code that is called by name that is associated with an
    object. In most respects it is identical to a function except for two
    key differences.
        It is implicitly passed for the object for which it was called.
        It is able to operate on data that is contained within the class
            (remembering that an object is an instance of a class -
            the class is the definition, the object is an instance of that data).
'''
