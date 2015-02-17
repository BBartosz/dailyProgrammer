object Main {
  case class Item(name: String, valueA: Float, valueB: Int)

  def main(args: Array[String]) {
    val itemA = Item("nazwa2222", 12, 12)
    val itemB = Item("nazwa2", 123, 123)
    val itemC = Item("nazwa3", 1234, 1234)

    val item1 = 2
    val item2 = 3
    val item3 = 4

    val itemQueue = MyPriorityQueue(itemA, itemB)
    val newItemQueue = MyPriorityQueue.enqueue[Item](itemC, itemQueue)
//    dequeue by name which is string
    println(MyPriorityQueue.dequeue[Item, String](newItemQueue, q => q.name))
//    dequeue by valueA which is float
    println(MyPriorityQueue.dequeue[Item, Float](newItemQueue, q => q.valueA))
//    dequeue by valueB which is int
    println(MyPriorityQueue.dequeue[Item, Int](newItemQueue, q => q.valueB))

    val intQueue = MyPriorityQueue(item1, item2)
    val newIntQueue = MyPriorityQueue.enqueue[Int](item3, intQueue)
//    dequeue by element i  which is int
    println(MyPriorityQueue.dequeue[Int, Int](newIntQueue, i => i))

  }
}
