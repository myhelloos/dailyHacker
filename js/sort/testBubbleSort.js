load("CArray.js");

var numElements = 10;
var myNums = new CArray(numElements);
myNums.setData();
print(myNums.toString());
myNums.bubbleSort();
print();
print(myNums.toString());
