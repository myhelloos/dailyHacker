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
            if (i ==0 || w == 0) {
                k[i][w] = 0;
            } else if (size[i-1] <= w) {
                k[i][w] = max(value[i-1]+k[i-1][w-size[i-1]], k[i-1][w])
            } else {
                k[i][w] = k[i-1][w];
            }
        }
    }
    return k[n][capacity];
}

function max(a, b) {
	return (a > b) ? a : b;
}
