load("Search.js");

var words = read("words.txt").split(" ");
var word = "rhetoric";
words.sort();
disArr(words);
var start = new Date().getTime();
var position = binSearch(words, word);
var stop = new Date().getTime();
var elapsed = stop - start;
if (position >= 0) {
    print("Found " + word + " at position " + position + ".");
    print("Sequential search took " + elapsed + " milliseconds.");
} else {
    print(word + " is not in the file.");
}
