case class CarryAdder(numbers: List[Int]) {
  val maxNumber = numbers.max
  val mapNumbers: List[Map[Index, Digit]] = {
    numbers.map(n => n.toString.reverse.map(_.asDigit).zipWithIndex.map(n =>
      (new Index(n._2), new Digit(n._1))).toMap)
  }
  val maxDigitsNumber: Int = {
    mapNumbers.maxBy(_.size).size
  }

  def makeCarries: Map[Index, List[Int]] = {
    def loop(indexNo: Int, carries: Map[Index, List[Int]]): Map[Index, List[Int]] ={
      if (indexNo > maxDigitsNumber - 1){
        return carries
      }else{
        val actualIndex  = new Index(indexNo)
        val sumOfCarries = carries(actualIndex).sum
        val sumOfDigits  = mapsForComputations.map(n => n(new Index(indexNo)).value).sum + sumOfCarries
        val newCarries   = carries + (new Index(indexNo + 1) -> List.fill(sumOfDigits/10)(1))
        loop(indexNo + 1, newCarries)
      }
    }

    loop(0, Map(new Index(0) -> List()))
  }

  def mapsForComputations: List[Map[Index, Digit]] = {
    mapNumbers.map(n =>
    if (maxIndexNumber(n) < maxDigitsNumber){
      refillWithZeros(n)
    }else{
      n
    })
  }

  def maxIndexNumber(digits: Map[Index, Digit]): Int = {
    digits.maxBy(_._1.value)._1.value
  }

  def refillWithZeros(digits: Map[Index, Digit]): Map[Index, Digit] ={
    val numberOfNewDigits =  maxDigitsNumber - digits.size

    def loop(numberOfNewDigits: Int, newDigits:Map[Index, Digit]): Map[Index, Digit] ={
      if (numberOfNewDigits == 0){
        newDigits
      } else {
        loop(numberOfNewDigits - 1, newDigits + (new Index(maxIndexNumber(newDigits) + 1) -> new Digit(-1)))
      }
    }
    loop(numberOfNewDigits, digits)
  }
}

case class Index(value: Int){
}

case class Digit(value: Int){
}
