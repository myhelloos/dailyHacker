people = 20
cats = 30
dogs = 15

# For If statement, structure is similar to "def:"
# with colon at end of first line, the indent

if people < cats:
    # 20 < 30 is True, so this will print
    print "Too many cats! The wold is doomed!"

if people > cats:
    # 20 > 30 is False, so this will not print
    print "Not many cats! The world is saved!"

if people < dogs:
    # 20 < 15 is False, so this will not print
    print "The world is drooled on!"

if people > dogs:
    # 20 > 15 is True, so this will print
    print "The world is dry!"


dogs += 5
# dogs = 15 + 5 = 20
# This is a method for incrementing numbers
# Its is equivalent to "dogs = dogs + 5"
# You can also use -=, *=, /=, ets.

if people >= dogs:
    # 20 >= 20 is True, so this will print
    print "People are greater than or equal to dogs."

if people <= dogs:
    # 20 <= 20 is True, so this will print
    print "People are less than or equal to dogs."

if people == dogs:
    # 20 == 20 is True, so this will print
    print "People are dogs."
