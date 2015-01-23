function curve(grade) {
    return grade += 5;
}

var grades = [77,65,32,42,56,89];
var newGrades = grades.map(curve);
print(grades);
print(newGrades);


