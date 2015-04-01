object Solution {

    import scala.util.Sorting._

    def getData(): List[Array[Char]] = {
        (for (i <- 1 to readInt) yield
        readLine.toArray).toList
    }

    def checkWord(wrd: Array[Char]): Option[String] = {
        for{ i <- wrd.length - 1 to 0 by -1
            j <- wrd.length - 1 until i by -1 } {
                if (wrd(i) < wrd(j)) {
                    val tmp = wrd(j)
                    wrd(j) = wrd(i)
                    wrd(i) = tmp

                    val (fst, lst) = wrd.splitAt(i + 1)
                    quickSort(lst)
                    return Some(fst.mkString + lst.mkString)
            }
        }
        return None
    }

    def main(args: Array[String]) {
        for (wrd <- getData())
        checkWord(wrd) match {
            case Some(w) => println(w)
            case None => println("no answer")
        }
    }
}
