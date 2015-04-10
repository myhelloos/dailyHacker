object Solution {
    def main(args: Array[String]) {
        for (i <-0 until readInt) {
            val length = readInt
            val arr = readLine.split(" ").map(_.toInt)
            var result = 0
            for(j <- 1 until length) {
                for (k <- 0 until j) {
                    if (arr(k) > arr(j)) result+=1
                }
            }
            println(result)
        }
    }
}
