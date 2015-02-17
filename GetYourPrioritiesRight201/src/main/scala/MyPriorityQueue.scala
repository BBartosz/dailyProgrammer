object MyPriorityQueue {
  def apply[A](xs: A*): List[A] = xs.toList

  def enqueue[A](element: A, queue: List[A]): List[A] = ins[A](element, queue)

  def dequeue[A, B](queue: List[A], sortF: A => B)(implicit ord: Ordering[B]): List[A] = queue match {
    case Nil => throw new NoSuchElementException("dequeue of empty queue")
    case x::xs => queue.sortBy(sortF)(ord).tail
  }

  def count[A](queue: List[A]): Int = queue.size

  def clear(): List[Any] = Nil

  protected def ins[A](elem: A, queue: List[A]): List[A] = queue match {
    case Nil => List(elem)
    case tp::ts => elem::tp::ts
  }
}

