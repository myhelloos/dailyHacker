load("fib.js");

for (var num = 10; num <= 30; num += 10) {
	var start = new Date().getTime();
	print(recurFib(num));
	var stop = new Date().getTime();
	print("recursive time - " + (stop - start) + " milliseconds.");
	print();

	start = new Date().getTime();
	print(dynFib(num));
	stop = new Date().getTime();
	print("dynamic time - " + (stop - start) + " milliseconds.");
	print();

    start = new Date().getTime();
    print(iterFib(num));
    stop = new Date().getTime();
    print("iterable time - " + (stop - start) + " milliseconds.");
    print();
}
