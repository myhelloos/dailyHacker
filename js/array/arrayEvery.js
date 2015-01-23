function isEven(num) {
    return num % 2 == 0;
}

var nums = [2,4,6,8,10];
var even = nums.every(isEven); 
if (even) {
    print("all numbers are even");
} else {
    print("not all numbers are even");
}
var nums = [1,3,4,7,9,11];
var even = nums.some(isEven); 
if (even) {
    print("some numbers are even");
} else {
    print("all numbers are not even");
}
