# -*- coding:utf-8 -*-

from sys import argv
from os.path import exists

script, from_file, to_file = argv

print "Copying from %s to %s" % (from_file, to_file)
# we could do those two on one line too, how?

indata = open(from_file).read();

print "Ready, hit the RETURN to continue, CTRL-C to abort."
raw_input()

out_file = open(to_file, 'w')
out_file.write(indata)

print "Alright, all done."

out_file.close()

'''
The first place checked is ``sys.modules``
    If the module is not found in the cache, then ``sys.meta_path`` is searched
'''
