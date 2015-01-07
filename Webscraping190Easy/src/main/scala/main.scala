object main{
  def main(args: Array[String]) {
    val url = "https://plus.googleapis.com/u/0/_/widget/render/comments?first_party_property=YOUTUBE&href=https://www.youtube.com/watch?v=orTgRMYZP5o"
    val webscraper = new Webscraper(url)
    val amountOfHappyWords = webscraper.countWordsInComments(new HappyWords())
    val amountOfSadWords = webscraper.countWordsInComments(new SadWords())
    println(amountOfSadWords)
    println(amountOfHappyWords)
  }
}

