#Difference between String StringBuffer and StringBuilder 

String is immutable whereas StringBuffer and StringBuilder can change their values.

The only difference between StringBuffer and StringBuilder is that **StringBuilder is unsynchronized whereas StringBuffer is synchronized.** So when the application needs to be run only in a single thread then it is better to use StringBuilder. StringBuilder is more efficient than StringBuffer.

##Criteria to choose among String, StringBuffer and StringBuilder
1. If your text is not going to change use a string Class because a String object is immutable.
2. If your text can change and will only be accessed from a single thread, use a StringBuilder because StringBuilder is unsynchronized.
3.If your text can changes, and will be accessed from multiple threads, use a StringBuffer because StringBuffer is synchronous.

## reference:
1. [Java Tips](http://www.java-tips.org/java-se-tips/java.lang/difference-between-string-stringbuffer-and-stringbu.html)
2. [stackoverflow](http://stackoverflow.com/questions/355089/stringbuilder-and-stringbuffer)