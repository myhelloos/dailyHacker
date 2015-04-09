object Solution {
    def main(args: Array[String]) {
        val arr = readArray(readInt)
        quickSort(arr)()
    }

    def quickSort(arr: Array[Int])(low: Int=0, high: Int=arr.length-1):Unit = {
        if (low >= high) return
        val pivot = partition(arr, low, high)
        quickSort(arr)(low, pivot-1)
        quickSort(arr)(pivot+1, high)
        printArray(arr, low, high)
    }

    def partition(arr: Array[Int], low: Int, high: Int):Int = {
        val pivot = arr(low)
        var i = high
        for (j <- (low+1 to high).reverse) {
            if (arr(j) >= pivot) {
                swap(arr, i, j)
                i-=1
            }
        }
        swap(arr, i, low)
        return i
    }

    def swap(arr:Array[Int], i:Int, j:Int) {
        val temp = arr(i)
        arr(i) = arr(j)
        arr(j) = temp
    }
    def printArray(arr: Array[Int], low:Int, high:Int) = println(arr.slice(low, high+1).mkString(" "))
    def readArray(len: Int):Array[Int] = readLine.split(" ").map(_.toInt)
}
