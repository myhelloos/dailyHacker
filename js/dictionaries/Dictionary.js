function Dictionary() {
    this.dataStore = new Array();
    this.add = add;
    this.find = find;
    this.remove = remove;
    this.showAll = showAll;
    this.count = count;
    this.clear = clear;
    this.replace = replace;
}

function add (key, value) {
    this.dataStore[key] = value;
}

function find(key) {
    return this.dataStore[key];
}

function remove(key) {
    delete this.dataStore[key];
}

function showAll() {
    for each (var key in Object.keys(this.dataStore).sort()) {
        print (key + " -> " + this.dataStore[key]);
    }
}

function count() {
    var n = 0;
    for each (var key in Object.keys(this.dataStore)) {
        ++n
    }
    return n;
}

function clear() {
    for each (var key in Object.keys(this.dataStore)) {
        delete this.dataStore[key];
    }
}

function replace(key, value) {
    if (!this.find(key)) {
        return false;
    }
    this.dataStore[key] = value;
    return true;
}
