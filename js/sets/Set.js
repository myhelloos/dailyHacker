/*******************************************************************************
The two most important properties of sets are that
    the members of a set are unordered
    and that no member can occur in a set more than once.

Definitions:
    1. A set containing no members is called the empty set.
        The universe is the set of all possible members.
    2. Two sets are considered equal if they contain exactly the same members.
    3. A set is considered a subset of another set if all the members of the
        first set are contained in the second set.
*******************************************************************************/
function Set() {
    this.dataStore = [];
    this.add = add;
    this.remove = remove;
    this.size = size;
    this.union = union;
    this.intersect = intersect;
    this.subset = subset;
    this.difference = difference;
    this.show = show;
    this.contains = contains;
}

function add(data) {
    if (this.dataStore.indexOf(data) < 0) {
        this.dataStore.push(data);
        return true;
    }
    return false;
}

function remove(data) {
    var pos = this.dataStore.indexOf(data);
    if (pos > -1) {
        this.dataStore.splice(pos, 1);
        return true;
    }
    return false;
}

function show() {
    return this.dataStore;
}

function contains(data) {
    return this.dataStore.indexOf(data) > -1;
}

function union(set) {
    var tempSet = new Set();
    for (var i = 0; i < this.dataStore.length; i++) {
        tempSet.add(this.dataStore[i]);
    }
    for (var i = 0; i < set.dataStore.length; i++) {
        if (!tempSet.contains(set.dataStore[i])) {
            tempSet.add(set.dataStore[i]);
        }
    }
    return tempSet;
}

function intersect(set) {
    var tempSet = new Set();
    for (var i = 0; i < this.dataStore.length; ++i) {
        if (set.contains(this.dataStore[i])) {
            tempSet.add(this.dataStore[i]);
        }
    }
    return tempSet;
}

function subset(set) {
    if (this.size() > set.size()) {
        return false;
    }
    for each (var member in this.dataStore) {
        if(!set.contains(member)) {
            return false;
        }
    }
    return true;
}

function size() {
    return this.dataStore.length;
}

function difference(set) {
    var tempSet = new Set();
    for (var i = 0; i < this.dataStore.length; i++) {
        if (!set.contains(this.dataStore[i])) {
            tempSet.add(this.dataStore[i]);
        }
    }
    return tempSet;
}
