object Solution {
    def main(args: Array[String]): Unit = {
        for (times <- 0 until readInt) {
            val flag = new Array[Int](26)
            val str = readLine
            if (str.length % 2  == 0) {
                for (index <- 0 until str.length) {
                    if (index < str.length / 2) flag(str(index) - 'a') +=1
                    else flag(str(index) - 'a') -=1
                }
                var sum = 0
                flag.foreach {i => sum += i.abs}
                println(sum / 2)
            } else {
                println(-1)
            }
        }
    }
}
