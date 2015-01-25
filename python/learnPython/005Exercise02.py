# -*- coding: utf-8 -*- 
name = 'Zed A. Shaw'
age = 35 # not a lie
height = 74 # inches
weight = 180 # Ibs
eyes = 'Blue'
teeth = 'White'
hair = 'Brown'

print "Let's talk about {}.".format(name)
print "He's {:.2f} inches tall, that's {:.2f} centimeters.".format(height, height*2.54)
print "He's {:.2f} pounds heavy, that's {:.2f} kilograms.".format(weight, weight*0.453592)
print "Actually that's not too heavy."
print "He's got {} eyes and {} hairs.".format(eyes, hair)
print "His teeth are usually {} depending on the coffee.".format(teeth)

# this line is tricky, try to get it excatly right
print "If I add {:0>2d}, {:0>2d}, and {:0>2d} I get {:0>2d}.".format(age, height, weight, age+height+weight)

'''
Number 	    Format 	    Output 	    Description
3.1415926 	{:.2f} 	    3.14 	    2 decimal places
3.1415926 	{:+.2f} 	+3.14 	    2 decimal places with sign
-1 	        {:+.2f} 	-1.00 	    2 decimal places with sign
2.71828 	{:.0f} 	    3 	        No decimal places
5 	        {:0>2d} 	05 	        Pad number with zeros (left padding, width 2)
5 	        {:x<4d} 	5xxx 	    Pad number with x’s (right padding, width 4)
10 	        {:x<4d} 	10xx 	    Pad number with x’s (right padding, width 4)
1000000 	{:,} 	    1,000,000 	Number format with comma separator
0.25 	    {:.2%} 	    25.00% 	    Format percentage
1000000000 	{:.2e} 	    1.00e+09 	Exponent notation
13 	        {:10d} 	    13 	        Right aligned (default, width 10)
13 	        {:<10d} 	13 	        Left aligned (width 10)
13 	        {:^10d} 	13 	        Center aligned (width 10)
'''
