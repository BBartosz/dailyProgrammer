import scala.util.Random

case class GravityWellBoard(val space: AsteroidsBoard, val amount: Int) extends Board{
  val start = space.start
  val end = space.end
  val spaceDimension = space.spaceDimension

  lazy val value: List[Vertex] = {
    def loop(restAmount: Int, possibilities: List[Vertex], newSpace: List[Vertex]): List[Vertex] = {
      if (restAmount == 0) {
        newSpace
      } else {
        val randVertex = Random.shuffle(possibilities).head
        val oldVertex = newSpace.filter(vertex => vertex.x == randVertex.x && vertex.y == randVertex.y).head
        val updatedSpace = updateSpace(newSpace, surroundingCoordinates(oldVertex))

        loop(restAmount - 1, possibilities.filterNot(ver => ver == randVertex), updatedSpace)
      }
    }
    loop(amount, possibleValues, space.value)
  }

  def possibleValues: List[Vertex]={
    space.value.filterNot(v =>
      surroundingCoordinates(space.start).contains(v.x, v.y) || surroundingCoordinates(space.end).contains((v.x, v.y))
    )
  }

  def surroundingCoordinates(vertex: Vertex): List[(Int, Int)] = {
    List(
      (vertex.x, vertex.y),
      (vertex.x, vertex.y + 1),
      (vertex.x, vertex.y - 1),
      (vertex.x - 1, vertex.y + 1),
      (vertex.x - 1, vertex.y),
      (vertex.x - 1, vertex.y - 1),
      (vertex.x + 1, vertex.y + 1),
      (vertex.x + 1, vertex.y),
      (vertex.x + 1, vertex.y - 1)
    )
  }

  def updateSpace(space: List[Vertex], coordinates: List[(Int, Int)]): List[Vertex] = {
    def loop(coordinates: List[(Int, Int)], updatedSpace: List[Vertex]): List[Vertex] ={
      if (coordinates.isEmpty){
        updatedSpace
      }else{
        if (coordinatesInsideSpace(coordinates.head, space)){
          val newVertex = new GravityWell(coordinates.head._1, coordinates.head._2)
          val oldVertex = updatedSpace.filter(vertex => vertex.x == coordinates.head._1 && vertex.y == coordinates.head._2).head

          loop(coordinates.tail, updatedSpace.updated(space.indexOf(oldVertex), newVertex))
        }else{
          loop(coordinates.tail, updatedSpace)
        }
      }
    }
    loop(coordinates, space)
  }

  def coordinatesInsideSpace(coordinates:(Int, Int), space: List[Vertex]): Boolean = {
    (coordinates._1  >= 0 && coordinates._2  >= 0) && (coordinates._1 < spaceDimension && coordinates._2  < spaceDimension)
  }
}
