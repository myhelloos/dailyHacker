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
        for {i <- (0 until arr.length).reverse
            j <- ((i + 1) until arr.length).reverse } {
                if (arr(i) < arr(j)) {
                    swap(arr, i, j)
                    reverseRemain(arr, i)
                    return arr.mkString
                }
            }
        return arr.mkString
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
