trait Vertex {
  val x:Int
  val y:Int
}

case class EmptySpace(x:Int, y:Int) extends Vertex{
  def isStart: Boolean = {
    x == 0 && y == 0
  }
}

case class Asteroid(x:Int, y:Int) extends Vertex{
}

case class GravityWell(x:Int, y:Int) extends Vertex{
}

