load("CArray.js");

var numElements = 10000000;
var nums = new CArray(numElements);
nums.setData();
var start = new Date().getTime();
nums.shellSort1();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Elapsed time for the shell sort on " +
	numElements + " elements is: " + elapsed + " milliseconds.");


nums.setData();
var start = new Date().getTime();
nums.mergeSort();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Elapsed time for the merge sort on " +
	numElements + " elements is: " + elapsed + " milliseconds.");

nums.setData();
var start = new Date().getTime();
nums.qSort();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Elapsed time for the quick sort on " +
	numElements + " elements is: " + elapsed + " milliseconds.");

// Elapsed time for the shell sort on 1000 elements is: 2 milliseconds.
// Elapsed time for the merge sort on 1000 elements is: 3 milliseconds.
// Elapsed time for the quick sort on 1000 elements is: 3 milliseconds.
//
// Elapsed time for the shell sort on 10000 elements is: 2 milliseconds.
// Elapsed time for the merge sort on 10000 elements is: 12 milliseconds.
// Elapsed time for the quick sort on 10000 elements is: 31 milliseconds.
//
// Elapsed time for the shell sort on 100000 elements is: 23 milliseconds.
// Elapsed time for the merge sort on 100000 elements is: 49 milliseconds.
// Elapsed time for the quick sort on 100000 elements is: 303 milliseconds.
//
// Elapsed time for the shell sort on 1000000 elements is: 310 milliseconds.
// Elapsed time for the merge sort on 1000000 elements is: 580 milliseconds.
// Elapsed time for the quick sort on 1000000 elements is: 3846 milliseconds.
//
// Elapsed time for the shell sort on 10000000 elements is: 5508 milliseconds.
// Elapsed time for the merge sort on 10000000 elements is: 7147 milliseconds.
// Elapsed time for the quick sort on 10000000 elements is: 69879 milliseconds.
