# -*- coding:utf-8 -*-
age = raw_input("How old are you?")
height = raw_input("How tall are you?")
weight = raw_input("How much do you weight?")

print "So, you're %r old, %r tall and %r heavyi." %(
age, height, weight
)

# The pydoc module automatically generates documentation from Python modules.
#   The documentation can be presented as pages of text on the console, served
#   to a Web browser, or saved to HTML files.

# %r 是 debug 专用，它显示的是原始表示出来的字符，而 %s 是为了显示给用户。
