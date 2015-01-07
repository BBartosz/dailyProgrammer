import scala.io.Source

class DateParser(val url: String) {
  def execute: List[String] = {
    val wrongDates: List[String] = getDates
    buildProperDates(wrongDates)
  }

  def getDates: List[String] = {
    val data = Source.fromURL(url)
    val dates: List[String] = data.mkString.split('\n').toList
    dates
  }

  def buildProperDates(badDates: List[String]): List[String] = {
    badDates.map(x => convert(x))
  }

  def convert(str: String): String = str match {
    case forwardSlash(mm, dd, yy) => constructIsoDate(fixYear(yy), mm, dd)
    case hash(mm, yy, dd) => constructIsoDate(fixYear(yy), mm, dd)
    case aster(dd, mm, yyyy) => constructIsoDate(yyyy, mm, dd)
    case wordYy(month, dd, yy) => constructIsoDate(fixYear(yy),
      monthConvert(month), dd)
    case wordYyyy(month, dd, yyyy) => constructIsoDate(yyyy,
      monthConvert(month), dd)
    case _ => str
  }

  def constructIsoDate(yyyy: String, mm: String, dd: String): String =
  yyyy + "-" + mm + "-" + dd

  def fixYear(yy: String): String =
  if (yy.toInt <= 49) "20" + yy
  else "19" + yy

  val forwardSlash = """(\d\d)/(\d\d)/(\d\d)""".r
  val hash = """(\d\d)#(\d\d)#(\d\d)""".r
  val aster = """(\d\d)\*(\d\d)\*(\d\d\d\d)""".r
  val wordYy = """(\w*) (\d\d), (\d\d)""".r
  val wordYyyy = """(\w*) (\d\d), (\d\d\d\d)""".r

  val monthConvert = Map(
    "Jan" -> "01",
    "Feb" -> "02",
    "Mar" -> "03",
    "Apr" -> "04",
    "May" -> "05",
    "Jun" -> "06",
    "Jul" -> "07",
    "Aug" -> "08",
    "Sep" -> "09",
    "Oct" -> "10",
    "Nov" -> "11",
    "Dec" -> "12")
}