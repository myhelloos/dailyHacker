function HashTable() {
    this.table = new Array(137);
    this.simpleHash = simpleHash;
    this.betterHash = betterHash;
    this.showDistro = showDistro;
    this.put = put;
    this.get = get;
    this.buildChains = buildChains;
}

function put(key, data) {
    var pos = this.betterHash(key);
    var index = 0;
    if (this.table[pos][index] == undefined) {
        this.table[pos][index] = key;
        this.table[pos][index+1] = data;
    } else {
        while (this.table[pos][index] != undefined) {
            index += 2;
        }
        this.table[pos][index] = key;
        this.table[pos][index+1] = data;
    }
}

function get(key) {
    var index = 0;
    var hash = this.betterHash(key);
    if (this.table[pos][index] = key) {
        return this.table[pos][index+1];
    } else {
        while (this.table[pos][index] != key) {
            index += 2;
        }
        return this.table[pos][index+1];
    }
    return undefined;
}

function showDistro() {
    var n = 0;
    for (var i = 0; i < this.table.length; i++) {
        if (this.table[i][0] != undefined) {
            var data = "";
            for (var j = 1; j < this.table[i].length; j += 2) {
                data += this.table[i][j] + "\t";
            }
            print (i + ": " + data);
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
