load("Search.js");

var numbers = [5,1,7,4,2,10,9,3,6,8];
disArr(numbers);
for (var i = 0; i < 3; i++) {
    seqSearch(numbers, 4);
    disArr(numbers);
}
