function add(runningTotal, currentVal) {
    return runningTotal + currentVal;
}

var nums = [1,2,3,4,5,6,7,8,9,10];
var sum = nums.reduce(add);
print(sum);

var words = ["the ", "quick ", "brown ", "fox "];
var sentence = words.reduce(add);
print(sentence);

var sentence = words.reduceRight(add);
print(sentence);


