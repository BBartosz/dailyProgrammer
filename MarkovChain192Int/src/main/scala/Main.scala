object Main {
  def main (args: Array[String]) {
    val word  = new Word("bartek")
    val chain = new MarkovChain(List(word)).create
    println(checkWord(word, chain))
  }


  def checkWord(word: Word, chain: Map[Char, Map[Char, Int]]): Boolean ={
    def loop(slicedWord: Word): Boolean = {
      if (slicedWord.value.length > 1){
        chain
      }
    }

    loop(word)
  }

}
