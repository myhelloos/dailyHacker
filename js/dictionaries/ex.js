load("Dictionary.js")

print("Type some text and press <ENTER>:\t");
var str = readline();
var res = str.toLowerCase().replace(/[^a-z\ \']+/g, "").split(" ");

wordCount = new Dictionary();
for each (var temp in res) {
    if (!wordCount.find(temp)) {
        wordCount.add(temp, 1);
    } else {
        // var count = wordCount.find(temp)+1;
        // wordCount.remove(temp);
        // wordCount.add(temp, count);
        wordCount.replace(temp, wordCount.find(temp)+1);
    }
}
wordCount.showAll();
