case class Scanner(input: String) {
  val doubleBackslashPattern = """(\\\\)""".r
  val newLinePattern = """(\\n)""".r
  val spacePattern = """(\s)""".r
  val wordPattern = """(\s?\w+)""".r
  val backslashPattern = """(\\.)""".r
  val singlebackslashPattern = """(\\)""".r

  def tokenize: List[Token] = {
    val pattern = """(\\\\)|(\\n)|(\\.)|(\w+)|(\s+)|(\S+)""".r
    val splittedInput = pattern.findAllIn(input).toList

    for {
      word <- splittedInput
    } yield buildToken(word)
  }

  def buildToken(word: String): Token = {
    word match {
      case wordPattern(word) => Word(word)
      case newLinePattern(word) => NewLine()
      case spacePattern(word) => Space()
      case doubleBackslashPattern(word) => DoubleBackslash()
      case backslashPattern => Undefined(word)
      case _ => Undefined(word)
    }
  }
}

trait Token{
  val value: String
}

case class Word(value: String) extends Token

case class NewLine() extends Token{
  val value = "\\n"
}

case class Space() extends Token{
  val value = " "
}

case class DoubleBackslash() extends Token{
  val value = "\\"
}

case class Undefined(value: String) extends Token