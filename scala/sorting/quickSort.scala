
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
    }

    def partition(arr: Array[Int], low: Int, high: Int):Int = {
        val pivot = arr(high)
        var i = low
        for (j <- low until high) {
            if (arr(j) <= pivot) {
                swap(arr, i, j)
                i+=1
            }
        }
        swap(arr, i, high)
        printArray(arr)
        return i
    }

    def swap(arr:Array[Int], i:Int, j:Int) {
        val temp = arr(i)
        arr(i) = arr(j)
        arr(j) = temp
    }
    def printArray(arr: Array[Int]) = println(arr.mkString(" "))
    def readArray(len: Int):Array[Int] = readLine.split(" ").map(_.toInt)
}
