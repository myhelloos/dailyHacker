def testWhile(right, step=1):
    i = 0
    numbers = []
    while i < right:
        print "At the top i is %d" % i
        numbers.append(i)
        i += step
        print "Numbers now: ", numbers
        print "At the bootom i is %d" % i

    print "The numbrs: "

    for num in numbers:
        print num
