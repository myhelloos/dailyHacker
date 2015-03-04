function CArray(numElements) {
	this.dataStore = [];
	this.pos = 0;
	this.numElements = numElements;
	this.insert = insert;
	this.toString = toString;
	this.clear = clear;
	this.setData = setData;
	this.swap = swap;

	this.bubbleSort = bubbleSort;
	this.selectionSort = selectionSort;
	this.insertionSort = insertionSort;

	this.gaps = [701, 301, 132, 57, 23, 10, 4, 1];
	this.shellSort = shellSort;
    this.shellSort1 = shellSort1;

	for (var i = 0; i < numElements; i++) {
		this.dataStore[i] = i;
	}
}

/*******************************************************************************
                                    Basic Sort Algorithm
*******************************************************************************/
function bubbleSort() {
	var numElements = this.dataStore.length;
	var temp;
	for (var outer = numElements; outer >= 2; outer--) {
		for (var inner = 0; inner <= outer - 1; inner++) {
			if (this.dataStore[inner] > this.dataStore[inner + 1]) {
				swap(this.dataStore, inner, inner + 1);
			}
		}
	}
}

function selectionSort() {
	var min, temp;
	for (var outer = 0; outer < this.dataStore.length - 1; outer++) {
		min = outer;
		for (var inner = outer + 1; inner < this.dataStore.length; inner++) {
			if (this.dataStore[inner] < this.dataStore[min]) {
				min = inner;
			}
		}
		swap(this.dataStore, outer, min);
	}
}

function insertionSort() {
	var temp, inner;
	for (var outer = 1; outer < this.dataStore.length; outer++) {
		temp = this.dataStore[outer];
		inner = outer;
		while (inner > 0 && (this.dataStore[inner - 1] >= temp)) {
			this.dataStore[inner] = this.dataStore[inner - 1];
			inner--;
		}
		this.dataStore[inner] = temp;
	}
}

/*******************************************************************************
                                    Advance Sort Algorithm
*******************************************************************************/

function setGaps(arr) {
	this.gaps = arr;
}

function shellSort() {
	for (var g = 0; g < this.gaps.length; g++) {
		for (var i = this.gaps[g]; i < this.dataStore.length; i++) {
			var temp = this.dataStore[i];
			for (var j = i; j >= this.gaps[g] &&
				this.dataStore[j - this.gaps[g]] > temp; j -= this.gaps[g]) {
				this.dataStore[j] = this.dataStore[j - this.gaps[g]];
			}
			this.dataStore[j] = temp;
		}
	}
}

function shellSort1() {
	var N = this.dataStore.length
	var h = 1;
	while (h < N / 3) {
		h = 3 * h + 1;
	}
	while (h >= 1) {
		for (var i = h; i < N; i++) {
			for (var j = i; j >= h && this.dataStore[j] < this.dataStore[j - h]; j -= h) {
				swap(this.dataStore, j, j - h);
			}
		}
		h = (h - 1) / 3;
	}
}

/*******************************************************************************
	                                    Array Test Bed
	*******************************************************************************/
function setData() {
	for (var i = 0; i < this.numElements; i++) {
		this.dataStore[i] = Math.floor(Math.random() *
			(this.numElements + 1))
	}
}

function clear() {
	for (var i = 0; i < this.dataStore.length; i++) {
		this.dataStore[i] = 0;
	}
}

function insert(element) {
	this.dataStore[this.pos++] = element;
}

function toString() {
	var retstr = "";
	for (var i = 0; i < this.dataStore.length; i++) {
		retstr += this.dataStore[i] + " ";
		if (i > 0 && i % 10 == 0) {
			retstr += "\n";
		}
	}
	return retstr;
}

function swap(arr, index1, index2) {
	var temp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = temp;
}