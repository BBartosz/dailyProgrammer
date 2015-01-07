object Main {
  def main(args: Array[String]): Unit = {
    val input = "Lol good game"
    val translated = translate(input)
  }

  type Acronym = String
  type AcronymDef = String

  val dictionary: Map[Acronym, AcronymDef] = {
    Map(
      "lol" -> "laugh out loud",
      "dw" -> "don't worry",
      "hf" -> "have fun",
      "gg" -> "good game",
      "brb" -> "be right back",
      "g2g" -> "got to go",
      "wtf" -> "what the fuck",
      "wp" -> "well played",
      "gl" -> "good luck",
      "imo" -> "in my opinion",
      "wtf" -> "what the fuck",
      "wp"  -> "well played")
  }

  def translate(input: String): String ={
    {
      for {
        word <- input.split(" ")
      } yield wordTranslation(word)
    }.mkString(" ")
  }

  def wordTranslation(word: String): String ={
    val cleanWord: String = splitWord(word.toLowerCase())("letters")
    val punctuation: String = splitWord(word.toLowerCase())("punctuation")

    dictionary.getOrElse(cleanWord, word) + punctuation
  }

  def splitWord(word: String): Map[String, String] = {
    val wordPattern = """(\w+)(\W*)""".r
    word match {
      case wordPattern(letters, punctuation) => Map("letters" -> letters, "punctuation" -> punctuation)
      case _ => Map("letters" -> "", "punctuation" -> "")
    }
  }
}
