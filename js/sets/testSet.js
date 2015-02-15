load("Set.js")

var names = new Set();
names.add("David");
names.add("Jennifer");
names.add("Cynthia");
names.add("Mike");
names.add("Raymond");
if (names.add("Mike")) {
    print("Mike added")
} else {
    print("Can't add Mike, must already be in set.");
}
print(names.show());

var removed = "Mike";
if (names.remove(removed)) {
    print(removed + " Removed.")
} else {
    print(removed + " not removed.");
}

names.add("Clayton");
print(names.show());

var removed = "Alisa";
if (names.remove(removed)) {
    print(removed + " Removed.")
} else {
    print(removed + " not removed.");
}
