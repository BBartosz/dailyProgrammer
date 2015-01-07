class BoardPrinter(val space: Board, val path: Map[Vertex, (Double, Vertex)]) {
  println(space)
  def print: Unit = {
    def loop(row: Int): Unit ={
      if (row < space.spaceDimension ){
        val rowVertex = space.value.filter(vertex => vertex.y == row)
        rowVertex.sortBy(_.x).foreach(v => v match{
          case EmptySpace(x,y) => printEmpty(x,y)
          case Asteroid(x,y) => printf(" A ")
          case GravityWell(x,y) => printf(" G ")
        })
        println()
        loop(row + 1)
      }
    }
    loop(0)
  }

  val pathVertexes: List[Vertex] = {
    val notExistingVertex = new EmptySpace(-1, -1)
//    path.map(t => t._2._2).filterNot(v => v == notExistingVertex).toList
    def loop(vertexes: List[Vertex], currentVertex: Vertex ): List[Vertex] ={
      if (currentVertex == notExistingVertex){
        return List()
      }
      if(currentVertex == space.start){
        vertexes
      } else {
        val newPenultimate = path(currentVertex)._2
        loop(currentVertex :: vertexes, newPenultimate)
      }
    }
    val penultimate = path(space.end)._2

    loop(List(), penultimate)
  }

  def printEmpty(x:Int, y:Int): Unit = {
    if (space.start.x == x && space.start.y == y){
      printf(" S ")
    }else if(space.end.x == x && space.end.y == y){
      printf(" E ")
    } else if(pathVertexes.contains(new EmptySpace(x, y))){
      printf(" o ")
    } else{
      printf(" . ")
    }
  }
}
