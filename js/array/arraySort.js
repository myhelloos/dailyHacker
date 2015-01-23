function compare(num1, num2) {
    return num1 - num2;
}

var nums = [3,2,4,2,7,24,67];
nums.sort();
print(nums);
nums.sort(compare);
print(nums);

