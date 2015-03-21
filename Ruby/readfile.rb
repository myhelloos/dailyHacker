#!/usr/bin/ruby -w

# Example 1 - Read File and close
counter = 1
file = File.new("readfile.rb", "r")
while (line = file.gets)
    puts "#{counter}: #{line}"
    counter = counter + 1
end
file.close

# Example 2 - Pass file to block
counter = 1
File.open("readfile.rb", "r") do |infile|
    while (line = infile.gets)
        puts "#{counter}: #{line}"
        counter = counter + 1
    end
end

# Example 3 - Read File with Exception Handling
counter = 1
begin
    file = File.new("readfile.rb", "r")
    while (line = file.gets)
        puts "#{counter}: #{line}"
        counter = counter + 1
    end
    file.close
rescue => err
    puts "Exception: #{err}"
    err
end
