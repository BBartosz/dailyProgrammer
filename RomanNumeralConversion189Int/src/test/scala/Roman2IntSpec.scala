import org.scalatest.{BeforeAndAfter, Matchers, FunSpec}

class Roman2IntSpec extends FunSpec with Matchers with BeforeAndAfter {
  var converter: Roman2Int = _

  before {
    converter = new Roman2Int
  }

  describe("Converting roman to arabic") {
    describe("with proper number format") {
      describe("when input I") {

        it("returns 1") {
          val arabic = converter.convert("I")

          arabic should be(1)
        }
      }
    }

    describe("when input XXXIV") {

      it("returns 34") {
        val arabic = converter.convert("XXXIV")

        arabic should be(34)
      }
    }

    describe("when input MMMM") {
      it("returns 987") {
        val arabic = converter.convert("MMMM")

        arabic should be(4000)
      }
    }

    describe("when input VVVVVV") {
      it("returns 987") {
        val arabic = converter.convert("VVV")

        arabic should be(0)
      }
    }

    describe("when input (V)V") {
      it("returns 5005") {
        val arabic = converter.convert("(V)V")

        arabic should be(5005)
      }
    }
  }
}

