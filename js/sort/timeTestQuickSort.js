load("CArray.js");

var numElements = 10000;
var nums = new CArray(numElements);
nums.setData();
var start = new Date().getTime();
nums.qSort();
var stop = new Date().getTime();
var elapsed = stop - start;
print("Elapsed time for the quick sort on " +
	numElements + " elements is: " + elapsed + " milliseconds.");

// before update the pivotchooser:
// Elapsed time for the quick sort on 100 elements is: 1 milliseconds.
// Elapsed time for the quick sort on 1000 elements is: 3 milliseconds.
// Elapsed time for the quick sort on 10000 elements is: 29 milliseconds.
// Elapsed time for the quick sort on 100000 elements is: 303 milliseconds.
// Elapsed time for the quick sort on 1000000 elements is: 3555 milliseconds.
// Elapsed time for the quick sort on 10000000 elements is: 59846 milliseconds.

// after update the pivotchooser:
// Elapsed time for the quick sort on 100 elements is: 1 milliseconds.
// Elapsed time for the quick sort on 1000 elements is: 7 milliseconds.
// Elapsed time for the quick sort on 10000 elements is: 50 milliseconds.
// Elapsed time for the quick sort on 100000 elements is: 520 milliseconds.
// Elapsed time for the quick sort on 1000000 elements is: 5770 milliseconds.
// Elapsed time for the quick sort on 10000000 elements is: 84367 milliseconds.

// this is due to the pivot chooser cost time to compare those random data.
// if we compare a sorted array:

// before update the pivotchooser:
// Elapsed time for the quick sort on 10000 elements is: 4331 milliseconds.

// after update the pivotchooser:
// Elapsed time for the quick sort on 10000 elements is: 49 milliseconds.
