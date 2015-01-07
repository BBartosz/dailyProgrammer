import scala.io.Source

object Main {
  val path = "/home/bartek/idea_projects/dailyProgrammer/word_counting/src/main/scala/book.txt"
  lazy val allWords = Source.fromFile(path).mkString.replaceAll("[^A-Za-z0-9-]+", " ").toLowerCase().split(" ").toList

  def main(args: Array[String]) {
    println(countWords)
  }

  def countWords: List[(String, Int)] = {
//    allWords.toSet[String].map(word => (word, allWords.count(_ == word))).toList.sortBy(- _._2)
    allWords.groupBy(identity).mapValues(_.size).toList.sortBy(- _._2)
  }
}
