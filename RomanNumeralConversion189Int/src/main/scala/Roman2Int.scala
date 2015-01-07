class Roman2Int {
  private val romanConvert = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50,
    'C' -> 100, 'D' -> 500, 'M' -> 1000)
  private val multipleRegex = """\((.*)\)(.*)""".r

  def convert(str: String): Int = {
    def convertHelper(acc: Int, remaining: String): Int = {
      if (remaining.isEmpty)
        acc
      else if (remaining.tail.isEmpty)
        acc + romanConvert(remaining.head)
      else if (romanConvert(remaining.head) < romanConvert(remaining.tail.head))
        convertHelper(acc + romanConvert(remaining.tail.head) -
          romanConvert(remaining.head), remaining.tail.tail)
      else
        convertHelper(acc + romanConvert(remaining.head), remaining.tail)
    }

    str match {
      case multipleRegex(large, small) =>
        convert(large) * 1000 + convertHelper(0, small)
      case _ => convertHelper(0, str)
    }
  }
}
