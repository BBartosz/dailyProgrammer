class Printer(val adder: CarryAdder) {
  val carries  = adder.makeCarries
  val maxCarry = carries.maxBy(_._2.size)
  val maxIndex = carries.keys.maxBy(_.value)

  def print: Unit = {
    val indexes = carries.keys.toList.sortBy(i => i.value).reverse
    def loop(newIndexes: List[Index], newCarries: Map[Index, List[Int]]): Unit = {
      if (anyIndexNonEmpty(newCarries)){
        if (!newCarries(newIndexes.head).isEmpty) {
          println(indentation(newIndexes) +  "1")

          val updatedCarries = newCarries.updated(
            newIndexes.head, newCarries(newIndexes.head).tail)
          if(!updatedCarries(newIndexes.head).isEmpty) {
            loop(newIndexes, updatedCarries)
          }else{
            loop(indexes, updatedCarries)
          }
        } else {
          loop(newIndexes.tail, newCarries)
        }
      } else {
        println("---------")
      }
    }
    loop(indexes, carries)
    printNumbers
    printResult
  }

  def indentation(newIndexes: List[Index]): String = {
    if (adder.numbers.max.toString.length == 1){
      " " * (maxIndex.value - newIndexes.head.value)
    }else{
      " " * (maxIndex.value - newIndexes.head.value - 1)
    }
  }

  def anyIndexNonEmpty(carries: Map[Index, List[Int]]): Boolean = {
    !carries.find(c => !c._2.isEmpty).isEmpty
  }

  def printNumbers: Unit = {
    adder.mapsForComputations.foreach(n => {
      printf(" " * (adder.numbers.sum.toString.length - adder.numbers.max.toString.length))
      n.toSeq.sortBy(- _._1.value).foreach( i =>
        {
        if (i._2.value < 0) {
          printf(" ")
        }else{
          printf(i._2.value.toString )
        }
      })
      println("")
    })

    println("----------")
  }

  def printResult: Unit = {
//    printf("+")
    adder.numbers.sum.toString.map(_.asDigit).foreach(i => printf(i.toString)
    )
  }

}
