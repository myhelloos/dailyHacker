function seqSearch(arr, data) {
	for (var i = 0; i < arr.length; i++) {
		if (arr[i] == data) {
			return i;
		}
	}
	return -1;
}

function findMin(arr) {
	var min = arr[0];
	for (var i = 1; i < arr.length; i++) {
		if (arr[i] < min) {
			min = arr[i];
		}
	}
	return min;
}

function findMax(arr) {
	var max = arr[0];
	for (var i = 1; i < arr.length; i++) {
		if (arr[i] > max) {
			max = arr[i];
		}
	}
	return max;
}

function disArr(arr) {
	for (var i = 0; i < arr.length; i++) {
		putstr(arr[i] + " ");
		if (i % 10 == 9) {
			putstr("\n");
		}
	}
	if (i % 10 != 0) {
		putstr("\n");
	}
}
