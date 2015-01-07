object CarryAdding {
  def main (args: Array[String]) {
//    val adder = new CarryAdder(List(9,9,9,9,9,9,9,9,9,9,9,9,9))
    val adder = new CarryAdder(List(9,9,11,45,12,9,340,9,9399,9999))
    println(new Printer(adder).print)
//    println(new Printer(adder).carries)
//    println(adder.mapNumbers)

  }
}
