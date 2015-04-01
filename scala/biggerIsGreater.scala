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
            if (loc != -1) {
                swap(arr, i, loc)
                reverseRemain(arr, i)
                return arr.mkString
            }
        }
        return arr.mkString
    }

    def findNextChar(arr: Array[Char], index: Int): Int = {
        for (i <- (index + 1) until arr.length) {
            if (i == (arr.length - 1) && arr(index) < arr(i)) return i
            if (arr(index) < arr(i - 1) && arr(index) >= arr(i)) {
                return i - 1
            }
        }
        return -1
    }

    def swap(arr: Array[Char], index1: Int, index2: Int): Unit = {
        val temp = arr(index1)
        arr(index1) = arr(index2)
        arr(index2) = temp
    }

    def reverseRemain(arr: Array[Char], begin: Int): Unit = {
        val times = (arr.length - 1 - begin) / 2
        for (i <- 1 to times) {
            swap(arr, (begin + i), (arr.length - i))
        }
    }
}
