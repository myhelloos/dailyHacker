load("HashTable.js");

var pnumbers = new HashTable();
pnumbers.buildChains();
var name, number;
for (var i = 0; i < 3; i++) {
    putstr("Enter a name (space to quit): ");
    name = readline();
    if (name == " ") break;
    putstr("Enter a number: ");
    number = readline();
    pnumbers.put(name, number);
}
name = "";
putstr("Name for number (Enter quit to stop): ");
while (name != "quit") {
    name = readline();
    if (name == "quit") break;
    print(name + "'s number is " + pnumbers.get(name));
    putstr("Name for number (Enter quit to stop): ");
}
