#!/usr/bin/ruby -w

data = [1,2,3,4,
    5,6,7,8,
    9,10,11,12]
stack = []
data.each do |x|
    stack.push(x)
    if (stack.length == 4)
        puts(stack.join(", "))
        stack = []
    end
end
