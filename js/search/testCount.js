load("Search.js")

var nums = [];
for (var i = 0; i < 100; i++) {
    nums[i] = Math.floor(Math.random() * 101);
}
nums.sort(compare);
disArr(nums);
print();
putstr("Eneter a value to count: ");
var val = parseInt(readline());
var retVal = count(nums, val);
print("Found " + retVal + " occurrences of " + val + ".");

function compare(a, b) {
    return a - b;
}
