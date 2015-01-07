class Webscraper(val url: String) {
  val commentsWords: Array[Word] = extractWordsFromComments()

  def countWordsInComments(words: Words): Int ={
    words.values.map(w => new WordCounter(w, commentsWords).countWordOccurence).sum
  }

  private def extractWordsFromComments(): Array[Word] = {
    val comments = new PageParser(url).findComments()
    comments.flatMap(c => c.value.split(" ").filterNot(_ == "")).map(w => new Word(w))
  }
}
