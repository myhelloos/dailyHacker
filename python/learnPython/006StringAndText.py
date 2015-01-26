# -*- coding: utf-8 -*- 
#字符串通常是指你想要展示给别人的、或者是你想要从程序里“导出”的一小段字符
# define variable x
x = "There are %d types of people." % 10
# define variable binary
binary = "binary"
# define variable do_not
do_not = "don't"
# define variable y
y = "Those who know %s and those who %s." % (binary, do_not)
# print x to console
print x
# print y to console
print y

# print to console, using x as reference
print "I said: %r." % x
# print to console, using y as reference
print "I also said: '%s'." % y

# define variable hilarious
hilarious = False
# define variable joke_evaluation
joke_evaluation = "Isn't that joke so funny?! %r"

# print to console, using hilarious as reference
print joke_evaluation % hilarious

# define variable w
w = "This is the left side of ..."
# define variable e
e = "a string with a right side."

# print to console, using w and e as references
print w + e

