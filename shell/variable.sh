#!/bin/bash
a="hello world"
echo "A is {$a}. nice time."

num=2
echo "this is the ${num}nd"

# 打印出来的不是2而是1＋1。为了达到我们想要的效果有以下几种表达方式： 
 ((var++))
var=$(($var+1))
