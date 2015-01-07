class WordCounter(word: Word, words: Array[Word]) {
  def countWordOccurence: Int = {
    words.count(_ == word)
//    def loop(words: Array[Word], counter: Int): Int ={
//      if(words.isEmpty){
//        counter
//      }else if (words.head.value == word.value){
//        loop(words.tail, counter + 1)
//      }else {
//        loop(words.tail, counter)
//      }
//    }
//    loop(words, 0)
  }
}
