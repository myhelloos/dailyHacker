load("Search.js");

var nums = [];
for (var i = 0; i < 100; i++) {
    nums[i] = Math.floor(Math.random() * 100);
}
disArr(nums);
putstr("Enter a number to search for: ");
var num = parseInt(readline());
print();
var position = seqSearch(nums, num);
if (position > -1) {
    print(num + " is in the array at position " + position);
} else {
    print(num + " is not in the array.");
}
print();
disArr(nums);
