function lcs(word1, word2) {
    var max = 0;
    var index = 0;
    var lcsArr = new Array(word1.length+1);
    for (var i = 0; i < word1.length+1; i++) {
        lcsArr[i] = new Array(word2.length+1);
        for (var j = 0; j < word2.length+1; j++) {
            lcsArr[i][j] = 0;
        }
    }
    for (var i = 0; i < word1.length+1; i++) {
        for (var j = 0; j < word2.length+2; j++) {
            if (i == 0 || j == 0) {
                lcsArr[i][j] = 0;
            } else {
                if (word1[i-1] == word2[j-1]) {
                    lcsArr[i][j] = lcsArr[i-1][j-1] + 1;
                } else {
                    lcsArr[i][j] = 0;
                }
            }
            if (max < lcsArr[i][j]) {
                max = lcsArr[i][j];
                index = i;
            }
        }
    }
    var str= "";
    if (max == 0) {
        return str;
    } else {
        for (var i = index - max; i < index; i++) {
            str += word2[i];
        }
        return str;
    }
}
