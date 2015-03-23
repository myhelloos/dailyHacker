#!/usr/bin/ruby -w

data = [1,2,3,4,
    5,6,7,8,
    9,10,11,12]
data.each_slice(4) {|x| puts x.join(", ")}
