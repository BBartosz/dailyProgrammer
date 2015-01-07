case class Parser(input: String) {
  val tokens = new Scanner(input).tokenize

  def parse: Unit ={
    if (isInputValid){
      tokens.foreach(t => {
        t match {
          case NewLine() => println()
          case _ => print(t.value)
        }
      })
    } else {
      println("Input invalid")
    }
  }

  def isInputValid: Boolean = {
    tokens.filter(t => t.isInstanceOf[Undefined]).isEmpty
  }
}

