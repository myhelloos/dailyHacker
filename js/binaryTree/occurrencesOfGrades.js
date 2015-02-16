function prArray(arr) {
    putstr(arr[0].toString() + ' ');
    for (var i = 1; i < arr.length; i++) {
        putstr(arr[i].toString() + ' ');
        if (i % 10 == 0) {
            putstr('\n');
        }
    }
}

function genArray(length) {
    var arr = [];
    for (var i = 0; i < length; i++) {
        arr[i] = Math.floor(Math.random() * 101);
    }
    return arr;
}

load("BST.js");

var grades = genArray(100);
prArray(grades);
var gradedistro = new BST();
for (var i = 0; i < grades.length; i++) {
    var g = grades[i];
    var grade = gradedistro.find(g);
    if (grade == null) {
        gradedistro.insert(g);
    } else {
        gradedistro.update(g);
    }
}

var cont = 'y'
while (cont == 'y') {
    putstr("\n\nEnter a grade: ");
    var g = parseInt(readline());
    var aGrade = gradedistro.find(g);
    if (aGrade == null) {
        print("No occurrences of " + g);
    } else {
        print("Occurrences of " + g + ": " + aGrade.count);
    }
    putstr("Look at another grade (y/n)? ");
    cont = readline();
}
