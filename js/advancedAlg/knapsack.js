function recKnapsack(capacity, size, value, n) {
	if (n == 0 || capacity == 0) {
		return 0;
	}
	if (size[n - 1] > capacity) {
		return recKnapsack(capacity, size, value, n - 1);
	} else {
		return max(value[n - 1] +
			recKnapsack(capacity - size[n - 1], size, value, n - 1),
			recKnapsack(capacity, size, value, n - 1));
	}
}

function dynKnapsack(capacity, size, value, n) {
	var k = [];
	for (var i = 0; i <= capacity + 1; i++) {
		k[i] = [];
	}
	for (var i = 0; i <= n; i++) {
		for (var w = 0; w <= capacity; w++) {
			if (i == 0 || w == 0) {
				k[i][w] = 0;
			} else if (size[i - 1] <= w) {
				k[i][w] = max(value[i - 1] + k[i - 1][w - size[i - 1]], k[i - 1][w])
			} else {
				k[i][w] = k[i - 1][w];
			}
		}
	}
	return k[n][capacity];
}

function ksack(values, weights, capacity) {
	var w = 0;
	var tempWeights = [];
	var tempValues = [];
	var tempW, tempV, inner;
	for (var i = 0; i < weights.length; i++) {
		tempValues.push(values[i]);
		tempWeights.push(weights[i]);
	}
	// insertion sort
	for (var outer = 1; outer < weights.length; outer++) {
		tempV = tempValues[outer];
		tempW = tempWeights[outer];
		for (inner = outer; inner > 0; inner--) {
			if ((tempValues[inner - 1] / tempWeights[inner - 1]) < (tempV / tempW)) {
				tempValues[inner] = tempValues[inner - 1];
				tempWeights[inner] = tempWeights[inner - 1];
			} else {
				break;
			}
		}
		tempValues[inner] = tempV;
		tempWeights[inner] = tempW;
	}
	for (var i = 0, load = 0; load < capacity && i < tempValues.length; i++) {
		if (tempWeights[i] <= (capacity - load)) {
			w += tempValues[i];
			load += tempWeights[i];
		} else {
			var r = (capacity - load) / tempWeights[i];
			w += r * tempValues[i];
			load += tempWeights[i];
		}
	}
	return w;
}

function max(a, b) {
	return (a > b) ? a : b;
}
