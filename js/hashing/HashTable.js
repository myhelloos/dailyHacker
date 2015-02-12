function HashTable() {
    this.table = new Array(137);
    this.simpleHash = simpleHash;
    this.betterHash = betterHash;
    this.showDistro = showDistro;
    this.put = put;
    // this.get = get;
}

function put(data) {
    var pos = this.betterHash(data);
    this.table[pos] = data;
}

function showDistro() {
    var n = 0;
    for (var i = 0; i < this.table.length; i++) {
        if (this.table[i] != undefined) {
            print (i + ": " + this.table[i]);
        }
    }
}

function simpleHash(data) {
    var total = 0;
    for (var i = 0; i < data.length; i++) {
        total += data.charCodeAt(i);
    }
    print("Hash Value: " + data + " -> " + total);
    return total % this.table.length;
}

function betterHash(data) {
    const H = 31;
    var total = 0;
    for (var i = 0; i < data.length; i++) {
        total += H * total + data.charCodeAt(i);
    }
    total = total % this.table.length;
    if (total < 0) {
        total += this.table.length - 1;
    }
    print("Hash Value: " + data + " -> " + parseInt(total));
    return parseInt(total);
}
