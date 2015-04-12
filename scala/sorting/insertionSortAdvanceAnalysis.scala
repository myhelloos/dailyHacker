object Solution {
    def main(args: Array[String]) {
        for (i <-0 until readInt) {
            val length = readInt
            val arr = readLine.split(" ").map(_.toInt).slice(0, length)
            println(mergeSort(arr))
        }
    }

    def mergeSort(arr: Array[Int]):Int = {
        def mergeSort(arr: Array[Int], aux: Array[Int], low: Int, high: Int):Int = {
            if (high - low < 2) return 0
            val mid = (high - low) / 2 + low
            val leftResult = mergeSort(arr, aux, low, mid)
            val rightResult = mergeSort(arr, aux, mid, high)
            val mergeResult = merge(arr, aux, low, mid, high)
            leftResult + rightResult + mergeResult
        }

        val aux = new Array[Int](arr.length)
        mergeSort(arr, aux, 0, arr.length)
    }

    def merge(arr: Array[Int], aux: Array[Int], low: Int, mid: Int, high: Int):Int = {

        var curLow = low
        var curHigh = mid
        var result = 0

        for (i <- low until high) {
            if (curLow == mid) { aux(i) = arr(curHigh); curHigh += 1}
            else if (curHigh == high) { aux(i) = arr(curLow); curLow += 1}
            else if (arr(curLow) <= arr(curHigh)) { aux(i) = arr(curLow); curLow+=1 }
            else { aux(i) = arr(curHigh); curHigh+=1; result+= mid - curLow }
        }

        for (i <- low until high) arr(i) = aux(i)

        return result
    }
}
