load ('LIST.js');
var names = new List();
names.append("Cynthia");
names.append("Raymond");
names.append("Barbara");
print(names.toString());
names.remove("Raymond");
print(names.toString());


var names = new List();
names.append("Clayton");
names.append("Raymond");
names.append("Cynthia");
names.append("Jennifer");
names.append("Bryan");
names.append("Danny");

names.front();
print(names.getElement()); // displays Clayton

names.next();
print(names.getElement());  // displays Raymond

names.next();
names.next();
names.prev();
print(names.getElement()); // displays Cynthia

print("===Begains Here====");
for(names.front(); names.currPos() < names.length(); names.next()) {
   print(names.getElement());
}
print("===Begains Here====");
for(names.end(); names.currPos() >= 0; names.prev()) {
   print(names.getElement());
}
