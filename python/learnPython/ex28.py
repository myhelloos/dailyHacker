print "1:", True and True, "(True?)"
# True and True
# For "and" both need

print "2:", False and True, "(False?)"
# False and True
# If any statement in an "and" is false, then false
# and no need to go any future

print "3:", 1 == 1 and 2 == 1, "(False?)"
# 1 == 1 and 2 == 1
# True and False
# False

print "4:", "test" == "test", "(True?)"
# "test" == "test"
# True

print "5:", 1 == 1 or 2 != 1, "(True?)"
# 1 == 1 or 2 != 1
# Ture or (irrelevant but True)
# If either statement in an "or" is true, then True
# and no need to go any future

print "6:", True and 1 == 1, "(True?)"
# True and 1 == 1
# True and True
# True

print "7:", False and 0 != 0, "(False?)"
# False and 0 != 0
# False and (irrelevant but False)
# False

print "8:", True or 1 == 1, "(True?)"
# True or 1 == 1
# True or (irrelevant but True)
# True

print "9:", "test" == "testing", "(False?)"
# "test" == "testing"
# False

print "10:", 1 != 0 and 2 == 1, "(False?)"
# 1 != 0 and 2 == 1
# True and False
# False

print "11:", "test" != "testing", "(True?)"
# "test" != "testing"
# True

print "12:", "test" == 1, "(False?)"
# "test" == 1
# False

print "13:", not (True and False), "(True?)"
# not (True and False)
# not (False)
# True

print "14:", not (1 == 1 and 0 != 1), "(False?)"
# not (1 == 1 and 0 != 1)
# not (True and True)
# not (True)
# False

print "15:", not (10 == 1 or 1000 == 1000), "(False?)"
# not (10 == 1 or 1000 == 1000)
# not (False or True)
# not (True)
# False

print "16:", not (1 != 10 or 3 == 4), "(False?)"
# not (1 != 10 or 3 == 4)
# not (True or False)
# not (True)
# False

print "17:", not ("testing" == "testing" and "Zed" == "Cool Guy"), "(True?)"
# not ("testing" == "testing" and "Zed" == "Cool Guy")
# not (True and False)
# not (False)
# True

print "18:", 1 == 1 and (not ("testing" == 1 or 1 == 0)), "(True?)"
# 1 == 1 and (not ("testing" == 1 or 1 == 0))
# True and (not (False or False))
# True and (not (False))
# True and (True)

print "19:", "chunky" == "bacon" and (not (3 == 4 or 3 ==3)), "(False?)"
# "chunky" == "bacon" and (not (3 == 4 or 3 == 3))
# False and (irrelevant but not (False or True))
# False and (irrevalant but not (True))
# False and (irrelevant but False)
# False

print "20:", 3 == 3 and (not ("testing" == "testing" or "Python" == "Fun")), "(False?)"
# 3 == 3 and (not ("testing" == "testing" or "Python" == "Fun"))
# True and (not (Ture or False))
# True and (not True)
# True and (False)
# False
