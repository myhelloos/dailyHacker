# This is not a script. per se, but a module.
# That is. this document defines several functions
# that we can then use on other objects. The
# module will be called "ex25" (without the .py
# extension). In addition, we are going to run
# this from Python. and not the command line
# (i.e., UNIX shell) that we have used so far.
# I've include instructions at the bottom.

def breakWords(stuff):
    """This function will break up words for us."""
    words = stuff.split(' ')
    return words

def sortWords(words):
    """Sorts the words."""
    return sorted(words)

def printFirstWord(words):
    """Prints the first word after popping it of."""
    word = words.pop(0)
    print word

def printLastWord(words):
    """Prints the last word after popping it off."""
    word = words.pop(-1)
    print word

def sortSentence(sentence):
    """Takes in a full sentence and returns the sorted words."""
    words = breakWords(sentence)
    return sortWords(words)

def printFirstAndLast(sentence):
    """Prints the first and last wordss of sentence."""
    words = breakWords(sentence)
    printFirstWord(words)
    printLastWord(words)

def printFirstAndLastSorted(sentence):
    """Sorts the words then print the first and last one."""
    words = sortSentence(sentence)
    printFirstWord(words)
    printLastWord(words)

# Here are the instructions:

# 1. Start Python
# $ python

# 2. Import this newly defined module.
# >>> import ex25
# Note: Don't type ".py" or you'll get an error
# When you import this it will create a new file on your
# computer called ex25.pyc which is a "Python Bytecode
# Document." which helps the module load fasteer in the
# future. You can, however, deletete it if you want to.

# 3. Create an object to work with.
# >>> sentence = "All good things come to those who wait."

# 4. Run "sortWords" and show results
# >>> words = ex25.breakWords(sentence)
# >>> words
# Note: you can also print without the intermediate variable:
# >>> print ex25.breakWords(sentence)

# 5. Run "sortWords" and show results
# >>> sortesWords = ex25.sortWords(words)
# >>> sortedWords

# 6. Run "printFirstWord" (displays automatically)
# >>> ex25.printFirstWord(words)

# 7. Run "printLastWord" (displays automatically)
# >>> ex25.printLastWord(words)

# 8. Run "sortSentence" and show results
# >>> sortedSentence = ex25.sortSentence(sentence)
# >>> sortedSentence
# Note: Zed usssed the object "sorteWords" for these
# but that may be a mistake because he used that earlier
# and all his variables so far use the function name, so
# I'm calling the object "sortSentence."
# The output looks the same as "sortedWords" but used
# a different process to get there.

# 9. Run "PrintFirstAndLast" (display automatically)
# >>> ex25.printFirstAndLast(sentence)

# 10. Run "PrintFirstAndLastSorted" (display automatically)
# >>> ex25.printFirstAndLastSorted(sentence)

# If you type help(ex25) you'll see the first block of text
# I worte at the top and the text in triple quotes
# for each function below.

# If you type (ex25.breakWords) you'll see just
# the triple quote text for that function, That's called
# a "documentation comment"

# Finally, you can avoid typing "ex25." at the beginning
# of everything if you import the module like this instead:
# >>> form ex25 import *
# Then you can run the commands like this:
# >>> print breakWords(sentence)
