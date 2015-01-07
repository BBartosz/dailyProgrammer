import org.scalatest.{Matchers, FunSpec}

class ScannerSpec extends FunSpec with Matchers{
  describe("#tokenize"){
    describe("input: some simple string"){
      val input = "some simple string"
      it("creates list of 3 tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize.length should be(5)
      }
    }

    describe("""input: string with new line \n"""){
      val input = """string with new line \n"""
      it("creates list of 5 tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize.length should be(9)
      }

      it("creates proper tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize(0) should be(Word("string"))
        scanner.tokenize(1) should be(Space())
        scanner.tokenize(2) should be(Word("with"))
        scanner.tokenize(3) should be(Space())
        scanner.tokenize(4) should be(Word("new"))
        scanner.tokenize(5) should be(Space())
        scanner.tokenize(6) should be(Word("line"))
        scanner.tokenize(7) should be(Space())
        scanner.tokenize(8) should be(NewLine())
      }
    }

    describe("""input: string with undefined \x"""){
      val input = """string with undefined \x"""
      it("creates list of 4 tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize.length should be(7)
      }

      it("creates proper tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize(0) should be(Word("string"))
        scanner.tokenize(1) should be(Space())
        scanner.tokenize(2) should be(Word("with"))
        scanner.tokenize(3) should be(Space())
        scanner.tokenize(4) should be(Word("undefined"))
        scanner.tokenize(5) should be(Space())
        scanner.tokenize(6) should be(Undefined("\\x"))
      }
    }

    describe("""input: string with backslash \"""){
      val input = """string with backslash \"""
      it("creates list of 4 tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize.length should be(7)
      }

      it("creates proper tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize(0) should be(Word("string"))
        scanner.tokenize(1) should be(Space())
        scanner.tokenize(2) should be(Word("with"))
        scanner.tokenize(3) should be(Space())
        scanner.tokenize(4) should be(Word("backslash"))
        scanner.tokenize(5) should be(Space())
        scanner.tokenize(6) should be(Undefined("\\"))
      }
    }

    describe("""input: string with double backslash \\"""){
      val input = """string with double backslash \\"""
      it("creates list of 4 tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize.length should be(9)
      }

      it("creates proper tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize(0) should be(Word("string"))
        scanner.tokenize(1) should be(Space())
        scanner.tokenize(2) should be(Word("with"))
        scanner.tokenize(3) should be(Space())
        scanner.tokenize(4) should be(Word("double"))
        scanner.tokenize(5) should be(Space())
        scanner.tokenize(6) should be(Word("backslash"))
        scanner.tokenize(7) should be(Space())
        scanner.tokenize(8).value should be("\\")
      }
    }

    describe("""input: A random\nstring\\\"""){
      val input = """A random\nstring\\\"""
      it("creates list of 6 tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize.length should be(7)
      }

      it("creates proper tokens"){
        val scanner = new Scanner(input)

        scanner.tokenize(0) should be(Word("A"))
        scanner.tokenize(1) should be(Space())
        scanner.tokenize(2) should be(Word("random"))
        scanner.tokenize(3) should be(NewLine())
        scanner.tokenize(4) should be(Word("string"))
        scanner.tokenize(5).value should be("\\")
        scanner.tokenize(6) should be(Undefined("""\"""))
      }
    }
  }
}