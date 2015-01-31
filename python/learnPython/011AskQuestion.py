# -*- coding: utf-8 -*-
print "How old are you?",
age = raw_input(': ');
print "How tall are you?",
height = raw_input(': ');
print "How much do you weight?",
weight = raw_input(': ');

print "So, you're %r old, %r tall and %r heavy." %(
age, height, weight
)

# 在每行 print 后面加了个逗号(comma) , 了吧？这样的话 print 就不会输出新行符而结束
# input() 和 raw_input() 有何不同？
#       input() 函数会把你输入的东西当做 Python 代码进行处理，这么做会有安全问题，你应该
#       避开这个函数。
