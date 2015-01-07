import scala.io.Source
import scala.util.Random

class Hangman extends HangPicture{
  def start(): Unit = {
    println("Choose level")
    println("E- easy")
    println("M- medium")
    println("H- hard")

    val level: String = Console.readLine()
    level.toLowerCase match {
      case "e" => play(randomWord(new EasyLevel))
      case "m" => play(randomWord(new MediumLevel))
      case "h" => play(randomWord(new HardLevel))
      case _   => start()    }
  }

  def play(word: Word): Unit = {
    val max_chances: Int = 6

    def loop(chancesLeft: Int, guessedLetters: List[String]): Unit = {
      if (chancesLeft == 0) return println(s"You've lost the word was $word")

      println(s"Guess letter, you have $chancesLeft chances left")
      println(dashedWord(guessedLetters, word))
      val letter: String = Console.readLine()

      if (guessedLetters.contains(letter)) {
        println("You have already choose this letter, and it was in mysterious word.")
        loop(chancesLeft, guessedLetters)
      }else{
        if (word.value.contains(letter) ){
          println("You've guessed the letter!")
          loop(chancesLeft, letter :: guessedLetters )
        }else{
          println("SO CLOSE")
          println(hangBuildStatus(max_chances - chancesLeft))
          loop(chancesLeft - 1, guessedLetters )
        }
      }
    }
    loop(max_chances, List())
  }

  def dashedWord(guessedLetters: List[String], word: Word): String = {
    word.toDashed(guessedLetters)
  }

  def randomWord(level: Level): Word = {
    Random.shuffle(words()).find { word =>
      word.isWithinBounds(level.wordBound)
    }.get
  }

  def words(): List[Word] = {
    val words:List[String] =
      Source.fromFile("/home/bartek/idea_projects/ch188/src/main/scala/words.txt").mkString.split('\n').toList

    words.map(w => new Word(w.toLowerCase.replace("'", "")))
  }
}

case class Word(value: String) {
  def isWithinBounds(bound: WordBounds): Boolean = {
    value.length >= bound.from && value.length <= bound.to
  }

  def toDashed(guessedLetters: List[String]): String ={
    value.map(c => if(!guessedLetters.contains(c.toString)) '_' else c)
  }
}

case class WordBounds(from: Int, to: Int)

trait Level {
  val wordBound: WordBounds
}

class EasyLevel() extends Level {
  override val wordBound: WordBounds = WordBounds(3, 4)
}

class MediumLevel() extends Level {
  override val wordBound: WordBounds = WordBounds(5, 7)
}

class HardLevel() extends Level {
  override val wordBound: WordBounds = WordBounds(8, 90)
}
