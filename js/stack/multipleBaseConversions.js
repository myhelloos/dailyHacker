load("Stack.js")

/*******************************************************************************
    Note: This algorithm will work only with bases 2 through 9.
*******************************************************************************/
function mulBase(num, base) {
    var s= new Stack();
    do {
        s.push(num % base)
        num = Math.floor(num / base);
    } while (num > 0)
    var converted = "";
    while (s.length() > 0) {
        converted += s.pop();
    }
    return converted;
}
