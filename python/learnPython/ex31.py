print "You enter a dark room with two doors. Do you go through door #1 or door #2?"

door = raw_input("> ")
# Note that you can't enter "#1" or it goes to "else"

if door == "1":
    print "There's a giant bear here eating a cheese cake. what do you do?"
    print "1. Take the cake."
    print "2. Scream at the bear."

    bear = raw_input("> ")

    if bear == "1":
        print "The bear eats your face off.  Good job!"
    elif bear == "2":
        print "The bear eats your leg off.  Good job!"
    else:
        print "Well, doing %s is probably better.  Bear runs away." % bear
        # this is the only way to survive the game

elif door == "2":
    print "You stare into the endless abyss at Cthulhu's retina."
    # I still don't know how to pronounce "Cthulhu"
    # But youtube tells me it's "k-thu-lu"
    print "1. Buleberries."
    print "2. Yellow jacket clothespins."
    print "3. Understanding revolvers yelling melodies."

    insanity = raw_input("> ")

    if insanity == "1" or insanity == "2":
        print "Your body survives powered by a mind of jello. Good job!"
    else:
        print "The insanity rots your eyes into a pool of muck.  Good job!"
        # There's no way to win if you choose door 2

else:
    print "You stumble around and fall on a knife and die.  Good job!"
