object Solution {
    def main(args: Array[String]) {
        for (i <- 0 until readInt) {
            val arr = readLine.toArray
            val (a, b) = findSwapPlace(arr)
            if (a != -1 && b != -1) {
                swap(arr, a, b)
                println(arr.mkString)
            } else {
                println("no answer")
            }
        }
    }

    // 1. find the swap place, and swap
    // 2. sort the later array
    // 3. return the new string.    
    def findSwapPlace(arr: Array[Char]): (Int, Int) = {
        for (i <- (0 until arr.length).reverse) {
            var max = arr(i)
            for (j <- (0 until i).reverse) {
                if (arr(i) > arr(j)) {

                }
                if (arr(j) > max) max = arr(j)
            }
        }
        return (-1, -1)
    }

    def swap(arr: Array[Char], index1: Int, index2: Int): Unit = {
        val temp = arr(index1)
        arr(index1) = arr(index2)
        arr(index2) = temp
    }
}
