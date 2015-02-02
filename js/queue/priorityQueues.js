function Queue() {
    this.dataStore = [];
    this.enqueue = enqueue;
    this.dequeue = dequeue;
    this.front = front;
    this.back = back;
    this.toString = toString;
    this.empty = empty;
    this.count = count;
}

function enqueue(element) {
    this.dataStore.push(element);
}

function dequeue() {
    var priority = this.dataStore[0].code;
    var location = 0;
    for (var i = 1; i < this.dataStore.length; i++) {
        if (this.dataStore[i].code < priority) {
            priority = this.dataStore[i].code;
            location = i;
        }
    }
    return this.dataStore.splice(location, 1);
}

function front() {
    return this.dataStore[0];
}

function back() {
    return this.dataStore[this.dataStore.length - 1];
}

function toString() {
    var retStr = "";
    for (var i = 0; i < this.dataStore.length; i++) {
        retStr += this.dataStore[i].name + " code: "
        + this.dataStore[i].code + "\n";
    }
    return retStr;
}

function empty() {
    if (this.dataStore.length == 0) {
        return true;
    } else {
        return false;
    }
}

function count() {
    return this.dataStore.length;
}

// for Patient
function Patient(name, code) {
    this.name = name;
    this.code = code;
}
