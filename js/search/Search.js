function seqSearch(arr, data) {
	for (var i = 0; i < arr.length; i++) {
		if (arr[i] == data) {
			if (i > (arr.length * 0.2)) {
				var position = Math.floor(Math.random() * (arr.length * 0.2 + 1));
				swap(arr, i, position);
			}
			return true;
		}
	}
	return false;
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

function binSearch(arr, data) {
	var upperBound = arr.length - 1;
	var lowerBound = 0;
	while (lowerBound <= upperBound) {
		var mid = Math.floor(lowerBound + (upperBound - lowerBound) / 2);
		if (arr[mid] < data) {
			lowerBound = mid + 1;
		} else if (arr[mid] > data) {
			upperBound = mid - 1;
		} else {
			return mid
		}
	}
	return -1;
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

function swap(arr, index1, index2) {
	var temp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = temp;
}
