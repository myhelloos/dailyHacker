var nums=[1,2,3,7,8,9];
var insertNums = [4,5,6];
// insert into as an array
nums.splice(3,0,insertNums);
print(nums);
print(nums[3]);
nums.splice(3,1);
print(nums);
nums.splice(3,0,4,5,6);
print(nums);
// revese the array
nums.reverse();
print(nums);
