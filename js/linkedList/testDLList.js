load("DLList.js");

var cities = new DLList();
cities.insert("Conway", "head");
cities.insert("Russellville", "Conway");
cities.insert("Carlisle", "Russellville");
cities.insert("Alam", "Carlisle");
cities.display();
print();
cities.remove("Carlisle");
cities.display();
print();
cities.dispReverse();
