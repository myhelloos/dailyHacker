def break_words(stuff):
    """This function will break up words for us."""
    words = stuff.split(' ')
    return words
    # Look okay


def sort_words(words):
    """Sorts the words."""
    return sorted(words)
    # Look okay

# def print_first_word(words) # Add colon at end


def print_first_word(words):
    """Prints the first word after popping it off."""
    # word = words.poop(0) # Change "poop" to "pop"
    word = words.pop(0)
    print word


def print_last_word(words):
    """Prints the last word after popping it off."""
    # word = words.pop(-1) # Add closing parenthesis
    word = words.pop(-1)
    print word


def sort_sentence(sentence):
    """Takes in a full sentence and returns the sorted words."""
    words = break_words(sentence)
    return sort_words(words)
    # Looks okay


def print_first_and_last(sentence):
    """Prints the first and last words of the sentence."""
    words = break_words(sentence)
    print_first_word(words)
    print_last_word(words)
    # Looks okay


def print_first_and_last_sorted(sentence):
    """Sorts the words then prints the first and last one."""
    words = sort_sentence(sentence)
    print_first_word(words)
    print_last_word(words)
    # Looks okay


print "Let's practice everything."
print 'You\'d need to know \'bout escapes with \\ that do \n newlines and \t tabs.'
# Looks okay

poem = """
\tThe lovely world
with logic so firmly planted
cannot discern \n the needs of love
nor comprehend passion from intuition
and requires an explantion
\n\t\twhere there is none.
"""
# Looks okay


print "--------------"
print poem
print "--------------"
# Looks okay

# five = 10 - 2 + 3 - 5 # Change last number to 6
five = 10 - 2 + 3 - 6
print "This should be five: %s" % five


def secret_formula(started):
    jelly_beans = started * 500
    # jars = jelly_beans / 1000 # Change back slash to forward
    jars = jelly_beans / 1000
    crates = jars / 100
    return jelly_beans, jars, crates


start_point = 10000
# beans, jars, crates == secret_formula(start-point) # Change == to =
# Also change "start-point" to "start_point"
beans, jars, crates = secret_formula(start_point)

print "With a starting point of: %d" % start_point
# print "We'd have %d jeans, %d jars, and %d crates." % (jeans, jars, crates)
# Change "jeans" to "beans"
print "We'd have %d jeans, %d jars, and %d crates." % (beans, jars, crates)

start_point = start_point / 10

print "We can also do that this way:"
# print "We'd have %d beans, %d jars, and %d crabapples." % secret_formula(start_pont
# Chage "crabapples" to "crates"
# Chage "start_pont" to "start_point"
# Add closing parenthesis to "start_point"
print "We'd have %d beans, %d jars, and %d cartes." % secret_formula(start_point)


# sentence = "All god\tthings come to those who weight."
# Change "god" to "good"
# Remove tab command \t
# Chage "weight" to "wait"
sentence = "All good things come to those who wait."

# words = ex25.break_words(sentence)
# Remove "ex25."
words = break_words(sentence)

# sorted_words = ex25.sort_words(words)
# Remove "ex25."
sorted_words = sort_words(words)

print_first_word(words)
print_last_word(words)
# .print_first_word(sorted_words) # Remove . at beginning
print_first_word(sorted_words)
print_last_word(sorted_words)
# sorted_words = ex25.sort_sentence(sentence) # Remove "ex25."
sorted_words = sort_sentence(sentence)

# prin sorted_words # Chage "prin" to "print"
print sorted_words

# print_irst_and_last(sentence) # Change "irst" to "first"
print_first_and_last(sentence)

#    print_first_a_last_sorted(senence)
# Remove leading spaces
# Chage "a" to "and"
# change "senence" to "sentence"
print_first_and_last_sorted(sentence)
