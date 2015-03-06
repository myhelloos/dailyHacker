function recurFib(n) {
	if (n < 2) {
		return n;
	} else {
		return recurFib(n - 1) + recurFib(n - 2);
	}
}

function dynFib(n) {
	var val = [];
	for (var i = 0; i < n; i++) {
		val[i] = 0;
	}
	val[0] = 1;
	val[1] = 1;
	for (var i = 2; i < n; i++) {
		val[i] = val[i - 1] + val[i - 2];
	}
	return val[n - 1]
}

function iterFib(n) {
	var last = 1;
	var nextLast = 1;
	for (var i = 2; i < n; i++) {
		last += nextLast;
		nextLast = last - nextLast;
	}
	return last;
}
