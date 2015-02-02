load("dancer.js")

var maleDancers = new Queue();
var femaleDancers = new Queue();

getDancers(maleDancers, femaleDancers);
dance(maleDancers, femaleDancers);
if (!femaleDancers.empty()) {
    print(femaleDancers.front().name + " is waiting to dance.");
}
if (!maleDancers.empty()) {
    print(maleDancers.front().name + " is waiting to dance.");
}
