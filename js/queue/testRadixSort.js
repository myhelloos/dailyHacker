load("radixSort.js");


var nums = [];
var max = 0;
for (var i = 0; i < 200; i++) {
    nums[i] = Math.floor(Math.random() * 10000000001);
    if (max < nums[i]) {
        max = nums[i];
    }
}
print("Befor radix sort: ");
dispArray(nums);
// for (var i = 1; i < nums.length; i++) {
//     if (nums[i] < nums[i-1]) {
//         print("Error");
//         break;
//     }
// }
radixSort(nums, max);
print("\n\nAfter radix sort: ");
dispArray(nums);
// for (var i = 1; i < nums.length; i++) {
//     if (nums[i] < nums[i-1]) {
//         print("Error");
//         break;
//     }
// }
