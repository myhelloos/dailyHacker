function HashTable() {
    this.table = new Array(137);
    this.values = new Array(137);
    this.simpleHash = simpleHash;
    this.betterHash = betterHash;
    this.showDistro = showDistro;
    this.put = put;
    this.get = get;
    // this.buildChains = buildChains;
}

function put(key, data) {
    var pos = this.betterHash(key);
    if (this.table[pos] == undefined) {
        this.table[pos] = key;
        this.values[pos] = data;
    } else {
        while (this.table[pos] != undefined) {
            pos++;
        }
        this.table[pos] = key;
        this.values[pos] = data;
    }
}

function get(key) {
    var hash = -1;
    hash = this.betterHash(key);
    if (hash > -1) {
        for (var i = hash; this.table[i] != undefined; i++) {
            if (this.table[hash] == key) {
                return this.values[hash];
            }
        }
    }
    return undefined;
}

function showDistro() {
    var n = 0;
    for (var i = 0; i < this.table.length; i++) {
        if (this.values[i] != undefined) {
            print (i + ": " + this.values[i]);
        }
    }
}

function simpleHash(data) {
    var total = 0;
    for (var i = 0; i < data.length; i++) {
        total += data.charCodeAt(i);
    }
    // print("Hash Value: " + data + " -> " + total);
    return total % this.table.length;
}

function betterHash(data) {
    const H = 39;
    var total = 0;
    for (var i = 0; i < data.length; i++) {
        total += H * total + data.charCodeAt(i);
    }
    total = total % this.table.length;
    if (total < 0) {
        total += this.table.length - 1;
    }
    // print("Hash Value: " + data + " -> " + parseInt(total));
    return parseInt(total);
}

function buildChains() {
    for (var i = 0; i < this.table.length; i++) {
        this.table[i] = new Array();
    }
}
