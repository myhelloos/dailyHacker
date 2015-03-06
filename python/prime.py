result = [];
for i in range(2, 101):
    isPrime = True
    for j in range(2, int(i**0.5)+1):
        if (i % j == 0):
            isPrime = False
            break
    if (isPrime):
        result.append(i);
print " ".join('%s' % val for val in result)
