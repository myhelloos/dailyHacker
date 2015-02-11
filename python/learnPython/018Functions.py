# -*- coding:utf-8 -*-
"""
函数可以做三样事情：
1. 它们给代码片段命名，就跟“变量”给字符串和数字命名一样。
2. 它们可以接受参数，就跟你的脚本接受 argv 一样。
3. 通过使用 #1 和 #2，它们可以让你创建“微型脚本”或者“小命令”。
你可以使用 def 新建函数。

注意事项如下：
1. 函数定义是以 def 开始的吗？
2. 函数名称是以字符和下划线 _ 组成的吗？
3. 函数名称是不是紧跟着括号 ( ？
4. 括号里是否包含参数？多个参数是否以逗号隔开？
5. 参数名称是否有重复？（不能使用重复的参数名）
6. 紧跟着参数的是不是括号和冒号 ): ？
7. 紧跟着函数定义的代码是否使用了 4 个空格的缩进 (indent)？
8. 函数结束的位置是否取消了缩进 (“dedent”)？

当你运行（或者说“使用 use”或者“调用 call”）一个函数时，记得检查下面的要点：
1. 调运函数时是否使用了函数的名称？
2. 函数名称是否紧跟着 ( ？
3. 括号后有无参数？多个参数是否以逗号隔开？
4. 函数是否以 ) 结尾？
"""

# this one is like your scripts with argv
def print_two (*args) :
    arg1, arg2 = args
    print "arg1: %r, arg2: %r" % (arg1, arg2)

# ok, that *argv is actually pointless, we can just do this
def print_two_again (arg1, arg2) :
    print "arg1: %r, arg2 : %r" % (arg1, arg2)

# this just takses one argument
def print_one(arg1) :
    print "arg1 : %r" % arg1

# this one takes no arguments
def print_none () :
    print "I got nothin'."

print_two("Zed", "Shaw")
print_two_again("Zed", "Shaw")
print_one("First!")
print_none()
