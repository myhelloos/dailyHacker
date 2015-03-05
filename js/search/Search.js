function seqSearch(arr, data) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == data) {
            return true;
        }
    }
    return false;
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
