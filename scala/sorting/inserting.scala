object Solution {

    def main(args: Array[String]):Unit = {
        val len = readInt
        val arr = readLine.split(" ").map(_.toInt)

        insert(arr, len-1)
    }


    def insert(arr: Array[Int], index: Int): Unit = {
        val value = arr(index)
        var i = index - 1;
        while (i >= 0 && arr(i) > value) {
            arr(i+1) = arr(i)
            printArray(arr)
            i -= 1
        }
        arr(i+1) = value
        printArray(arr)
    }

    def printArray(arr: Array[Int]) = println(arr.mkString(" "))
}
