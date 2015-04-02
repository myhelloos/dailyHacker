object Solution {
    def main(args: Array[String]): Unit = {
        val times = readInt
        val arr: Array[Int] = readLine.split(" ").map(_.toInt)
        var result = 0
        for {i <- 1 until times
            j <- 0 until i } {
                if (arr(i) < arr(j)) result+=1
            }
            println(result)
    }
}
