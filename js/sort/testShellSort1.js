load("CArray.js");

var numElements = 100;
var myNums = new CArray(numElements);
myNums.setData();
print(myNums.toString());
myNums.shellSort1();
print();
print(myNums.toString());
