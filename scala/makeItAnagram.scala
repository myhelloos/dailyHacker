object Solution {
    def main(args: Array[String]): Unit = {
        val flag = new Array[Int](26)
        // first read in, count characters*/
        for (elem <- readLine) {
            flag(elem - 'a') += 1
        }
        // then read the 2nd time, and decrease appeared characters
        for (elem <- readLine) {
            flag(elem - 'a') -= 1
        }
        var sum = 0
        //the result should be the sum of difference of character times*/
        flag.foreach {i => sum += i.abs}
        println(sum)
    }
}
