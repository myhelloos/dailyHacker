object Solution {

    def main(args: Array[String]) {
        if (readLine().filter(_ != ' ').toLowerCase.distinct.size == 26)
        println("pangram")
        else
        println("not pangram")
    }
}
