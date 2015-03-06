load("knapsack.js");

var value = [4,5,10,11,13];
var size = [3,4,7,8,9];
var capacity = 16;
print(recKnapsack(capacity, size, value, value.length));

print(dynKnapsack(capacity, size, value, value.length));
