load("HashTable.js");

var someNames = ["David", "Jennifer", "Donnie", "Raymond",
                 "Cynthia", "Mike", "Clayton", "Danny",
                 "Jonathan"];
var hTable = new HashTable();
// hTable.buildChains();
for (var i = 0; i < someNames.length; i++) {
    hTable.put(someNames[i], someNames[i]);
}
hTable.showDistro();
