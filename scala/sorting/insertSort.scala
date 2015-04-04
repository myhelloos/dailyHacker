object Solution {

    def main(args: Array[String]):Unit = {
        val len = readInt
        val arr = readLine.split(" ").map(_.toInt)

        insertSort(arr)
    }


    def insertSort(arr: Array[Int]): Unit = {
        for (index <- 1 until arr.length) {
            val item = arr(index)
            var hole = index;
            while (hole > 0 && arr(hole - 1) > item) {
                arr(hole) = arr(hole - 1)
                hole -= 1
            }
            arr(hole) = item
            printArray(arr)
        }
    }

    def printArray(arr: Array[Int]) = println(arr.mkString(" "))
}
