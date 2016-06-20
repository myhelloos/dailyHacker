#!/bin/bash
if [ ${SHELL} = "/bin/bash" ]; then
   echo "your login shell is the bash (bourne again shell)"
else
   echo "your login shell is not bash but ${SHELL}"
fi

mailfolder=/var/spool/mail/alfred
[ -r "$mailfolder" ] || { echo "Can not read $mailfolder" ; exit 1; }
echo "$mailfolder has mail from:"
grep "^From " $mailfolder
