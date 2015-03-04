load("CArray.js");

var numElements = 100000;
var nums = new CArray(numElements);
nums.setData();
var start = new Date().getTime();
nums.bubbleSort();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Elapsed time for the bubble sort on " +
	numElements + " elements is: " + elapsed + " milliseconds.");


nums.setData();
var start = new Date().getTime();
nums.selectionSort();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Elapsed time for the selection sort on " +
	numElements + " elements is: " + elapsed + " milliseconds.");

nums.setData();
var start = new Date().getTime();
nums.insertionSort();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Elapsed time for the insertion sort on " +
	numElements + " elements is: " + elapsed + " milliseconds.");

// Elapsed time for the bubble sort on 100 elements is: 1 milliseconds.
// Elapsed time for the selection sort on 100 elements is: 0 milliseconds.
// Elapsed time for the insertion sort on 100 elements is: 1 milliseconds.
//
// Elapsed time for the bubble sort on 1000 elements is: 12 milliseconds.
// Elapsed time for the selection sort on 1000 elements is: 2 milliseconds.
// Elapsed time for the insertion sort on 1000 elements is: 1 milliseconds.
//
// Elapsed time for the bubble sort on 10000 elements is: 800 milliseconds.
// Elapsed time for the selection sort on 10000 elements is: 71 milliseconds.
// Elapsed time for the insertion sort on 10000 elements is: 70 milliseconds.
//
// Elapsed time for the bubble sort on 100000 elements is: 79502 milliseconds.
// Elapsed time for the selection sort on 100000 elements is: 6730 milliseconds.
// Elapsed time for the insertion sort on 100000 elements is: 6663 milliseconds.
