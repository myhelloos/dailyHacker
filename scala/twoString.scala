object Solution extends App {
    for (i <- 0 until readInt) {
        var flag = 0
        var cont = true
        for (elem:Char <- readLine) flag |= (1 << (elem - 'a'))
        for (elem:Char <- readLine) {
            if (cont && (flag & (1 << (elem - 'a'))) != 0) {
                cont = false
            }
        }
        if (cont) println("NO")
        else println("YES")
    }
}
