object Main {
  def main(args: Array[String]) {
    val parser = Parser("""bartek scala \\r\\r\nuby""")

    parser.parse
  }
}
