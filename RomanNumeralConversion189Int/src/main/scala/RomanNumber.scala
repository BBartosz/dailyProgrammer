class RomanNumber(val value: String){
  private val valueRegex = """\((.*)\)(.*)""".r
  val definitions: Map[String, Int] = {
    Map("I" -> 1,
        "V" -> 5,
        "X" -> 10,
        "L" -> 50,
        "C" -> 100,
        "D" -> 500,
        "M" -> 1000,
        ""  -> 9999999)
  }
  def toArabic: Int ={
    def loop(arabicValue: Int, romanNumber: String, previousRomanDigit: String): Int ={
      if (romanNumber.length == 0) {
        arabicValue
      } else {
        val firstRomanDigit: String = romanNumber.head.toString
        if (romanNumber.length == 1) {
          arabicValue + definitions(firstRomanDigit)
        } else if (nextNumberIsGreater(romanNumber) && !previousNumberIsLessOrEqual(firstRomanDigit, previousRomanDigit)) {
          val secondRomanDigit: String = romanNumber.tail.head.toString
          loop(arabicValue + definitions(secondRomanDigit) - definitions(firstRomanDigit), cut2FirstDigits(romanNumber), firstRomanDigit)
        } else if (nextNumberIsEqual(romanNumber)) {
          loop(arabicValue + definitions(firstRomanDigit), romanNumber.tail, firstRomanDigit)
        } else if (nextNumberIsLess(romanNumber)) {
          loop(arabicValue + definitions(firstRomanDigit), romanNumber.tail, firstRomanDigit)
        } else {
          0
        }
      }
    }

    if (validValue) {
      value match {
        case valueRegex(thousand, small) =>
          loop(0, thousand, "") * 1000 + loop(0, small, "")
        case _ => loop(0, value, "")
      }
    }else{
      0
    }

  }

  def cut2FirstDigits(romanNumber: String): String = {
    romanNumber.tail.tail
  }

  def previousNumberIsLessOrEqual(firstRomanDigit: String, previousRomanLetter: String): Boolean = {
    definitions(firstRomanDigit) >= definitions(previousRomanLetter)
  }

  def nextNumberIsLess(restRoman: String): Boolean = {
    definitions(restRoman.tail.head.toString) < definitions(restRoman.head.toString)
  }

  def nextNumberIsEqual(restRoman: String): Boolean = {
    definitions(restRoman.tail.head.toString) == definitions(restRoman.head.toString)
  }

  def nextNumberIsGreater(restRoman: String): Boolean = {
    definitions(restRoman.head.toString) < definitions(restRoman.tail.head.toString)
  }

  def validValue: Boolean ={
    !value.matches("""[X]{4,}|[I]{4,}|[V]{4,}|[L]{4,}|[C]{4,}|[D]{4,}|[M]{5,}""")
  }
}