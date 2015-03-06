load("knapsack.js");

var value = [4, 5, 10, 11, 13];
var size = [3, 4, 7, 8, 9];
var capacity = 16;
start = new Date().getTime();
print(recKnapsack(capacity, size, value, value.length));
stop = new Date().getTime();
print("dynamic time - " + (stop - start) + " milliseconds.");
print();

start = new Date().getTime();
print(dynKnapsack(capacity, size, value, value.length));
stop = new Date().getTime();
print("dynamic time - " + (stop - start) + " milliseconds.");
print();
