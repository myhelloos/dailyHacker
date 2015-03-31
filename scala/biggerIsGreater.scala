object Solution {
    def main(args: Array[String]) {
        for (i <- 0 until readInt) {
            val arr = readLine
            val next = nextString(arr.toArray)
            if (arr == next) {
                println("no answer")
            } else {
                println(next)
            }
        }
    }

    def nextString(arr: Array[Char]): String = {
        var loc = -1;
        for (i <- (0 until (arr.length-1)).reverse) {
            loc = findNextChar(arr, i)
            println("loc " + loc)
            if (loc != -1) {
                println("i " + i)
                swap(arr, i, loc)
                println("swap "+ arr.mkString)
                reverseRemain(arr, i)
                println("reverse " + arr.mkString)
                return arr.mkString
            }
        }
        return arr.mkString
    }

    def findNextChar(arr: Array[Char], index: Int): Int = {
        for (i <- index until arr.length) {
            if (i == (arr.length - 1) && arr(index) < arr(i)) {
                return i
            // problem how to find it?
            } else if (i < (arr.length - 2) && arr(index) > arr(i)) return i - 1
        }
        return -1
    }

    def swap(arr: Array[Char], index1: Int, index2: Int): Unit = {
        val temp = arr(index1)
        arr(index1) = arr(index2)
        arr(index2) = temp
    }

    def reverseRemain(arr: Array[Char], begin: Int): Unit = {
        val mid = (begin + arr.length - 1) / 2
        for (i <- (begin+1) until mid; j <- (mid until arr.length).reverse) {
            swap(arr, i, j)
        }
    }
}
