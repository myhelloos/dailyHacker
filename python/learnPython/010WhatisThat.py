# -*- coding: utf-8 -*-

tabby_cat = "\tI'm tabbed in."
persian_cat = "I'm spilt\non a line."
backslash_cat = "I'm \\ a \\ cat."
fat_cat = """
I'll do a list:
\t* Cat food
\t* Fishies
\t* Catnip\n\t* Grass
"""

print tabby_cat
print persian_cat
print backslash_cat
print fat_cat

"""
Escape Sequence     Meaning                                                     Notes
\newline            Ignored
\\                  Backslash (\)
\'                  Single quote (')
\"                  Double quote (")
\a                  ASCII Bell (BEL)
\b                  ASCII Backspace (BS)
\f                  ASCII Formfeed (FF)
\n                  ASCII Linefeed (LF)
\N{name}            Character named name in the Unicode database (Unicode only)
\r                  ASCII Carriage Return (CR)
\t                  ASCII Horizontal Tab (TAB)
\uxxxx              Character with 16-bit hex value xxxx (Unicode only)         (1)
\Uxxxxxxxx          Character with 32-bit hex value xxxxxxxx (Unicode only)     (2)
\v                  ASCII Vertical Tab (VT)
\ooo                Character with octal value ooo                              (3,5)
\x08                Character with hex value hh                                 (4,5)

Notes:
1.Individual code units which form parts of a surrogate pair can be encoded
    using this escape sequence.
2.Any Unicode character can be encoded this way, but characters outside the
    Basic Multilingual Plane (BMP) will be encoded using a surrogate pair if
    Python is compiled to use 16-bit code units (the default).
3.As in Standard C, up to three octal digits are accepted.
4.Unlike in Standard C, exactly two hex digits are required.
5.In a string literal, hexadecimal and octal escapes denote the byte with the
    given value; it is not necessary that the byte encodes a character in the
    source character set. In a Unicode literal, these escapes denote a Unicode
    character with the given value.
"""
