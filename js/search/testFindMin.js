load("Search.js");

var nums = [];
for (var i = 0; i < 100; i++) {
    nums[i] = Math.floor(Math.random() * 101);
}
disArr(nums);
print();
var minValue = findMin(nums);
print("The minimum value is: " + minValue);
