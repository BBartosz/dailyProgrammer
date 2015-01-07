import org.scalatest.{BeforeAndAfter, Matchers, FunSpec}

class NumberConverterToArabicSpec extends FunSpec with Matchers with BeforeAndAfter{
  var converter: NumberConverter = _

  before {
    converter = new NumberConverter
  }

  describe("Converting roman to arabic"){
    describe("with proper number format"){
      describe("when input I") {
        val roman = new RomanNumber("I")

        it("returns 1") {
          val result: Int = converter.romanToArabic(roman)

          result should be(1)
        }
      }
      describe("when input II") {
        val roman = new RomanNumber("II")

        it("returns 2") {
          val result: Int = converter.romanToArabic(roman)

          result should be(2)
        }
      }
      describe("when input III") {
        val roman = new RomanNumber("III")

        it("returns 3") {
          val result: Int = converter.romanToArabic(roman)

          result should be(3)
        }
      }
      describe("when input IV") {
        val roman = new RomanNumber("IV")

        it("returns 4") {
          val result: Int = converter.romanToArabic(roman)

          result should be(4)
        }
      }
      describe("when input V") {
        val roman = new RomanNumber("V")

        it("returns 5") {
          val result: Int = converter.romanToArabic(roman)

          result should be(5)
        }
      }
      describe("when input VI") {
        val roman = new RomanNumber("VI")

        it("returns 6 for input V") {
          val result: Int = converter.romanToArabic(roman)

          result should be(6)
        }
      }
      describe("when input VII") {
        val roman = new RomanNumber("VII")

        it("returns 7") {
          val result: Int = converter.romanToArabic(roman)

          result should be(7)
        }
      }

      describe("when input VIII") {
        val roman = new RomanNumber("VIII")

        it("returns 8") {
          val result: Int = converter.romanToArabic(roman)

          result should be(8)
        }
      }

      describe("when input XXXIV") {
        val roman = new RomanNumber("XXXIV")

        it("returns 34") {
          val result: Int = converter.romanToArabic(roman)

          result should be(34)
        }
      }

      describe("when input CCLXVII") {
        val roman = new RomanNumber("CCLXVII")

        it("returns 267") {
          val result: Int = converter.romanToArabic(roman)

          result should be(267)
        }
      }

      describe("when input DCCLXIV") {
        val roman = new RomanNumber("DCCLXIV")

        it("returns 764") {
          val result: Int = converter.romanToArabic(roman)

          result should be(764)
        }
      }

      describe("when input CMLXXXVII") {
        val roman = new RomanNumber("CMLXXXVII")

        it("returns 987") {
          val result: Int = converter.romanToArabic(roman)

          result should be(987)
        }
      }

      describe("when input MCMLXXXIII") {
        val roman = new RomanNumber("MCMLXXXIII")

        it("returns 1983") {
          val result: Int = converter.romanToArabic(roman)

          result should be(1983)
        }
      }

      describe("when input MMXIV") {
        val roman = new RomanNumber("MMXIV")

        it("returns 2014") {
          val result: Int = converter.romanToArabic(roman)

          result should be(2014)
        }
      }

      describe("when input MMMM") {
        val roman = new RomanNumber("MMMM")

        it("returns 4000") {
          val result: Int = converter.romanToArabic(roman)

          result should be(4000)
        }
      }

      describe("when input MMMMCMXCIX") {
        val roman = new RomanNumber("MMMMCMXCIX")

        it("returns 4999") {
          val result: Int = converter.romanToArabic(roman)

          result should be(4999)
        }
      }

      describe("when input (V)V") {
        val roman = new RomanNumber("(V)V")

        it("returns 5005") {
          val result: Int = converter.romanToArabic(roman)

          result should be(5005)
        }
      }

      describe("when input (XV)V") {
        val roman = new RomanNumber("(XV)V")

        it("returns 15005") {
          val result: Int = converter.romanToArabic(roman)

          result should be(15005)
        }
      }
    }

    describe("with invalid number format"){
      describe("when input is IIII"){
        val roman = new RomanNumber("IIII")

        it("returns 0"){
          val result: Int = converter.romanToArabic(roman)

          result should be(0)
        }
      }

      describe("when input is XXXX"){
        val roman = new RomanNumber("XXXX")

        it("returns 0"){
          val result: Int = converter.romanToArabic(roman)

          result should be(0)
        }
      }

      describe("when input is IIX"){
        val roman = new RomanNumber("IIX")

        it("returns 0"){
          val result: Int = converter.romanToArabic(roman)

          result should be(0)
        }
      }

      describe("when input is IIIX"){
        val roman = new RomanNumber("IIIX")

        it("returns 0"){
          val result: Int = converter.romanToArabic(roman)

          result should be(0)
        }
      }

      describe("when input MMMMM") {
        val roman = new RomanNumber("MMMMM")

        it("returns 0") {
          val result: Int = converter.romanToArabic(roman)

          result should be(0)
        }
      }
    }
  }
}
