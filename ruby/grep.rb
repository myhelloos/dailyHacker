#!/usr/bin/ruby -w

if (ARGV.length < 2)
    abort('usage: ruby grep.rb file str')
end
file = ARGV[0]
str = ARGV[1]

counter = 1
File.open(file, "r") do |infile|
    while (line = infile.gets)
        if line.match(str)
            puts "#{counter}: #{line}"
        end
        counter = counter + 1
    end
end
