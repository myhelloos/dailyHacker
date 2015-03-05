load("Search.js");

var nums = [];
for (var i = 0; i < 100; i++) {
    nums[i] = Math.floor(Math.random() * 101);
}
disArr(nums);
for (var i = 10; i > 0; i--) {
    print();
    putstr("Enter a value to search for: ");
    var val = parseInt(readline());
    if (seqSearch(nums, val)) {
        print("Found element: ");
        print();
        disArr(nums);
    } else {
        print(val + " is not in array.");
    }
}
