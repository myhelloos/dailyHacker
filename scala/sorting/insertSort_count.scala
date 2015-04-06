object Solution {

    def main(args: Array[String]):Unit = {
        val len = readInt
        val arr = readLine.split(" ").map(_.toInt)

        insertSort(arr)
    }


    def insertSort(arr: Array[Int]): Unit = {
        var result = 0
        for (index <- 1 until arr.length) {
            val item = arr(index)
            var hole = index;
            while (hole > 0 && arr(hole - 1) > item) {
                arr(hole) = arr(hole - 1)
                hole -= 1
            }
            result += (index - hole)
            arr(hole) = item
        }
        println(result)
    }

    def printArray(arr: Array[Int]) = println(arr.mkString(" "))
}
