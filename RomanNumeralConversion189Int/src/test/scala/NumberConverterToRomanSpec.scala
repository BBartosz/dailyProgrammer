import org.scalatest.{BeforeAndAfter, Matchers, FunSpec}

class NumberConverterToRomanSpec extends FunSpec with Matchers with BeforeAndAfter{
  var converter: NumberConverter = _

  before {
    converter = new NumberConverter
  }

  describe("Converting roman to arabic") {
    describe("with proper number format") {
      describe("input < 10") {
        describe("when input 1") {
          val arabic = new ArabicNumber(1)

          it("returns I") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("I")
          }
        }

        describe("when input 2") {
          val arabic = new ArabicNumber(2)

          it("returns II") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("II")
          }
        }

        describe("when input 3") {
          val arabic = new ArabicNumber(3)

          it("returns III") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("III")
          }
        }
      }

      describe("input < 40") {
        describe("when input 10") {
          val arabic = new ArabicNumber(10)

          it("returns X") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("X")
          }
        }

        describe("when input 11") {
          val arabic = new ArabicNumber(11)

          it("returns XI") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XI")
          }
        }

        describe("when input 15") {
          val arabic = new ArabicNumber(15)

          it("returns XV") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XV")
          }
        }

        describe("when input 21") {
          val arabic = new ArabicNumber(21)

          it("returns XXI") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XXI")
          }
        }

        describe("when input 39") {
          val arabic = new ArabicNumber(39)

          it("returns XXXIX") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XXXIX")
          }
        }
      }
      describe("50 > input >= 40") {
        describe("when input 40") {
          val arabic = new ArabicNumber(40)

          it("returns XL") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XL")
          }
        }

        describe("when input 47") {
          val arabic = new ArabicNumber(47)

          it("returns XLVII") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XLVII")
          }
        }

        describe("when input 49") {
          val arabic = new ArabicNumber(49)

          it("returns XLIX") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XLIX")
          }
        }
      }

      describe("90 > input >= 50") {
        describe("when input 50") {
          val arabic = new ArabicNumber(50)

          it("returns L") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("L")
          }
        }

        describe("when input 64") {
          val arabic = new ArabicNumber(64)

          it("returns LXIV") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("LXIV")
          }
        }

        describe("when input 89") {
          val arabic = new ArabicNumber(89)

          it("returns LXXXIX") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("LXXXIX")
          }
        }
      }
      describe("100 > input >= 90"){
        describe("when input 90") {
          val arabic = new ArabicNumber(90)

          it("returns XC") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XC")
          }
        }

        describe("when input 94") {
          val arabic = new ArabicNumber(94)

          it("returns XCIV") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XCIV")
          }
        }

        describe("when input 98") {
          val arabic = new ArabicNumber(98)

          it("returns XCVIII") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("XCVIII")
          }
        }
      }

      describe("1000 > input >= 100") {
        describe("when input 100") {
          val arabic = new ArabicNumber(100)

          it("returns C") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("C")
          }
        }

        describe("when input 191") {
          val arabic = new ArabicNumber(191)

          it("returns CXCI") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("CXCI")
          }
        }

        describe("when input 624") {
          val arabic = new ArabicNumber(624)

          it("returns DCXXIV") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("DCXXIV")
          }
        }

        describe("when input 999") {
          val arabic = new ArabicNumber(999)

          it("returns CMXCIX") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("CMXCIX")
          }
        }
      }

      describe("4000 > input >= 1000") {
        describe("when input 1000") {
          val arabic = new ArabicNumber(1000)

          it("returns M") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("M")
          }
        }

        describe("when input 1524") {
          val arabic = new ArabicNumber(1524)

          it("returns MDXXIV") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("MDXXIV")
          }
        }

        describe("when input 3999") {
          val arabic = new ArabicNumber(3999)

          it("returns MMMCMXCIX") {
            val result: String = converter.arabicToRoman(arabic)

            result should be("MMMCMXCIX")
          }
        }
      }
    }
  }
}
