print "Let's practice everything."
print 'You\'d need to know \'bout escapes with \\ that do \n newlines and \t tabs.'

poem = """\t The lovely world
with logic so firmly planted
cannot discren \n the needs of love
nor comprehend passion from intuition
and requires an explanation
\n\t\twhere there is none.
"""

print "--------------"
print poem
print "--------------"


five = 10 - 2 + 3 - 6
print "This should be five: %s" % five

def secretFormula(started):
    jellyBeans = started * 500
    jars = jellyBeans / 1000
    crates = jars / 100
    return jellyBeans, jars, crates


startPoint = 10000
beans, jars, crates = secretFormula(startPoint)

print "With a starting point of: %d" % startPoint
print "We'd have %d beans, %d jars and %d crates." % (beans, jars, crates)

startPoint = startPoint / 10

print "We can also do that this way:"
print "We'd have %d beans, %d jars, and %d crates." % secretFormula(startPoint)
