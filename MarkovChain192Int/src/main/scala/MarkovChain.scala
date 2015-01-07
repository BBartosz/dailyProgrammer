case class MarkovChain(words: List[Word]) {
  def create: Map[Letter, LetterOccurenceMap] = {
    words.foldLeft(buildInitialMarkovChain){(acc, curr) =>
      updateChain(curr, acc)
    }
  }

  private def updateChain(word: Word, chain: Map[Letter, LetterOccurenceMap]): Map[Letter, LetterOccurenceMap] = {
    word.toPairs.foldLeft(chain){(acc, pair) =>
      val firstLetter: Letter = new Letter(pair(0))
      val secondLetter: Letter = new Letter(pair(1))
      val updatedOccurenceNumber: Int = acc(firstLetter)(secondLetter) + 1

      acc + (firstLetter -> new LetterOccurenceMap(acc(firstLetter).value + (secondLetter -> updatedOccurenceNumber)))
    }
  }

  private def buildInitialMarkovChain: Map[Letter, LetterOccurenceMap] = {
    val initialAlphabet = "abcdefghijklmnopqrstuvwxyz".toList.map(l => new Letter(l))
    val initialLetterOccurence = new LetterOccurenceMap(initialAlphabet.map(l => (l,0)).toMap)

    initialAlphabet.map(l => (l, initialLetterOccurence)).toMap
  }
}

case class Word(value: String) {
  def toList: List[Char] = {
    value.toList
  }

  def toPairs: List[String] = {
    def loop(currValue: String, pairs: List[String]): List[String] = {
      if (currValue.length == 1) {
        pairs
      }else {
        loop(currValue.tail,  currValue.slice(0, 2).toString :: pairs)
      }
    }
    loop(value, List())
  }
}

case class Letter(value: Char) {
}

case class LetterOccurenceMap(value: Map[Letter, Int]){
  def apply(letter: Letter): Int = {
    value(letter)
  }
}
