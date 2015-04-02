object Solution {
    def main(args: Array[String]): Unit = {
        for (i <- 0 until readInt) {
            solve(readLine)
        }
    }

    def solve(str: String): Unit = {
        for (j <- 1 to str.length / 2) {
            if ((str(j) - str(j - 1)).abs != (str(str.length - j) - str(str.length - j - 1)).abs) {
                println("Not Funny")
                return
            }
        }
        println("Funny")
        return
    }
}
