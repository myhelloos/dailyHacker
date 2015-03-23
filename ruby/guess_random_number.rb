target = rand(10)
puts 'Guess a value from 0 to 10'
guess = gets().to_i()
puts "You Win!!!" if guess == target
puts "Too big." if guess < target
puts "Too small." if guess > target
