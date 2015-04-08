object Solution {
    def main(args: Array[String]) {
        val arr = readArray(readInt)
        partition(arr, 0, arr.length-1)
        printArray(arr)
    }

    def readArray(len: Int):Array[Int] = readLine.split(" ").map(_.toInt)

    def partition(arr: Array[Int], low: Int, high: Int):Int = {
        val pivot = arr(low)
        var curLow = low
        var curHigh = high
        while (curHigh > curLow) {
            while(curHigh > curLow && arr(curHigh) >= pivot) curHigh-=1
            arr(curLow) = arr(curHigh)
            while(curHigh > curLow && arr(curLow) <= pivot) curLow+=1
            arr(curHigh) = arr(curLow)
        }
        arr(curLow) = pivot
        return curLow
    }

    def printArray(arr: Array[Int]) = println(arr.mkString(" "))
}
