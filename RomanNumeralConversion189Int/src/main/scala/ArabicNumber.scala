class ArabicNumber(val value: Int) {
  val definitions: Map[Int, String] = {
    Map(
      1    -> "I",
      5    -> "V",
      10   -> "X",
      50   -> "L",
      100  -> "C",
      500  -> "D",
      1000 -> "M",
      0    -> "")
  }
  def toRoman: String = {
    if(value < 10) {
      convert(1, "", value)
    }else if (value < 100){
      convert(10, "", value) +
        convert(1, "", value.toString().tail.toInt)
    }else if (value < 1000){
      convert(100, "", (value.toString().head + "00").toInt) +
        convert(10, "", (value.toString().tail).toInt) +
          convert(1, "", value.toString().tail.tail.toInt)
    } else if(value < 5000){
      convert(1000, "", (value.toString().head + "000").toInt) +
        convert(100, "", (value.toString().tail.head + "00").toInt) +
          convert(10, "", value.toString().tail.tail.toInt) +
            convert(1, "", value.toString().tail.tail.tail.toInt)
    }
    else {
      "0"
    }
  }

  def convert(decimalType: Int, accRoman: String, arabicValue: Int): String = {
    val remainder: Int = arabicValue % decimalType

    if (arabicValue == decimalType){
      accRoman + definitions(decimalType)
    } else if (arabicValue < decimalType){
      accRoman
    }else if (arabicValue < (4 * decimalType)){
      convert(decimalType, definitions(decimalType) * (arabicValue/decimalType), remainder)
    }else if (arabicValue < (5 * decimalType)){
      convert(decimalType, definitions(decimalType) + definitions(5 * decimalType), remainder)
    }else if (arabicValue < (9 * decimalType)){
      convert(decimalType, definitions(5*decimalType) + definitions(decimalType) * ((arabicValue-(5*decimalType))/decimalType), remainder)
    }else if (arabicValue < (10 * decimalType)) {
      convert(decimalType, definitions(decimalType) + definitions(10 * decimalType), remainder)
    }else{
      "0"
    }
  }
}

