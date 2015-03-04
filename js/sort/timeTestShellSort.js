load("CArray.js");

var numElements = 1000000;
var nums = new CArray(numElements);
nums.setData();
var start = new Date().getTime();
nums.shellSort();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Shellsort with hard-coded gap sequence " +
	numElements + " elements is: " + elapsed + " milliseconds.");


nums.setData();
var start = new Date().getTime();
nums.shellSort1();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Shellsort with dynamic gap sequence " +
	numElements + " elements is: " + elapsed + " milliseconds.");

// Shellsort with hard-coded gap sequence 100 elements is: 0 milliseconds.
// Shellsort with dynamic gap sequence 100 elements is: 1 milliseconds.
//
// Shellsort with hard-coded gap sequence 1000 elements is: 1 milliseconds.
// Shellsort with dynamic gap sequence 1000 elements is: 2 milliseconds.
//
// Shellsort with hard-coded gap sequence 10000 elements is: 2 milliseconds.
// Shellsort with dynamic gap sequence 10000 elements is: 2 milliseconds.
//
// Shellsort with hard-coded gap sequence 100000 elements is: 38 milliseconds.
// Shellsort with dynamic gap sequence 100000 elements is: 27 milliseconds.
//
// Shellsort with hard-coded gap sequence 1000000 elements is: 4434 milliseconds.
// Shellsort with dynamic gap sequence 1000000 elements is: 338 milliseconds.
// this is due to the length of array is too long, and the shell gap does not update
