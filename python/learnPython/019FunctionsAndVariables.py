# -*- coding:utf-8 -*-
"""
函数里边的变量和脚本里边的变量之间是没有连接的。
"""

def cheeseAndCrackers(cheeseCount, boxesOfCrackers) :
    print "You have %d cheese!" % cheeseCount
    print "You have %d boxes of crackers!" % boxesOfCrackers
    print "Man that's enough for a party!"
    print "Get a blanket.\n"

print "We can just give the function numbers directly: "
cheeseAndCrackers(20, 30)

print "OR, we can use variables from our script:"
amountOfCheese = 10
amountOfCrackers = 50

cheeseAndCrackers(amountOfCheese, amountOfCrackers)

print "We can even do math inside too."
cheeseAndCrackers(10 + 20, 5 + 6)

print "AND we can combine the two, variables and math:"
cheeseAndCrackers(amountOfCheese + 100, amountOfCrackers + 100)
