import scala.collection._

object Solution {
    def isPangram(s: String): Boolean = {
        val alphabet = mutable.HashSet[Char]()
        for (c <- s if c.isLetter) alphabet.add(c.toLower)
        return alphabet.size == 26
    }

    def main(args: Array[String]) {
        val s = io.Source.stdin.getLines().take(1).next

        if (isPangram(s)) println("pangram")
        else println("not pangram")
    }
}
