load("queue.js")

function radixSort(nums, max) {
    var queues = [];
    for (var i = 0; i < 10; i++) {
        queues[i] = new Queue();
    }
    var base = 1;
    do {
        distribute(nums, queues, base);
        collect(queues, nums);
        base *= 10;
        max = Math.floor(max / 10);
    } while (max > 0)

}

function distribute(nums, queues, base) {
    for (var i = 0; i < nums.length; i++) {
        queues[Math.floor((nums[i]/base))%10].enqueue(nums[i]);
    }
}

function collect(queues, nums) {
    var i = 0;
    for (var digit = 0; digit < 10; digit++) {
        while (!queues[digit].empty()) {
            nums[i++] = queues[digit].dequeue();
        }
    }
}

function dispArray(arr) {
    for (var i = 0; i < arr.length; i++) {
        putstr(arr[i] + " ");
    }
}
