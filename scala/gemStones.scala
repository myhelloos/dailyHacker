object Solution {
    def main(args: Array[String]) {
        var flag: Int = 0
        var tempFlag: Int = 0
        var tempData: String = ""
        var result = 0
        val times = readInt()
        for (i <- 0 until times) {
            tempData = readLine.distinct
            tempFlag = 0
            for (char <- tempData) {
                tempFlag |= (1 << (char - 'a'))
            }
            if (i == 0) flag |= tempFlag
            else flag &= tempFlag
        }
        while (flag != 0) {
            if ((flag & 1) == 1) result += 1
            flag >>= 1
        }
        println(result)
    }
}
