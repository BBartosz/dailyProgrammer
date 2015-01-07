class Dijkstra(val board: Board) {
  val notExistingVertex = new EmptySpace(-1, -1)
  val infinity: Double = 1.0/0
  val S: Set[Vertex] = Set()
  private val onlyEmptySpaces: List[Vertex] = board.value.filterNot(v => v.isInstanceOf[Asteroid])
  val Q: Set[Vertex] = onlyEmptySpaces.toSet
  val dpTable: Map[Vertex, (Double, Vertex)]  = board.value.filterNot(v => !v.isInstanceOf[EmptySpace]).map(v =>
    if(v == board.start){
      v -> (0.0, notExistingVertex)
    } else {
      v -> (infinity, notExistingVertex)
    }
  ).toMap

  def run: Map[Vertex, (Double, Vertex)] = {
    def loop(closestVertex: Vertex, newDpTable: Map[Vertex, (Double, Vertex)], newQ: Set[Vertex], newS: Set[Vertex]): Map[Vertex, (Double, Vertex)] = {
      if (Q.isEmpty){
        return newDpTable
      }else{
        val updatedQ = newQ.filterNot(v => v == closestVertex)
        val updatedS = newS + closestVertex
        val updatedDpTable: Map[Vertex, (Double, Vertex)] = updatePredecessors(closestVertex, newDpTable)

        if (closestVertex == board.end){
          updatedDpTable
        } else if (!updatedQ.isEmpty){
          loop(findClosestVertex(updatedDpTable, updatedS), updatedDpTable, updatedQ, updatedS)
        }else{
          updatedDpTable
        }
      }
    }
    val closestVertex = findClosestVertex(dpTable, S)

    loop(closestVertex, dpTable, Q, S)
  }

  def findClosestVertex(dpTable: Map[Vertex, (Double, Vertex)], S:Set[Vertex]): Vertex = {
    dpTable.filterNot(t => S.contains(t._1)).minBy(_._2._1)._1
  }

  def updatePredecessors(vertex: Vertex, dpTable: Map[Vertex, (Double, Vertex)]): Map[Vertex, (Double, Vertex)] = {
    dpTable.map(t =>
      if(surroundingVertexes(vertex).contains(t._1)){
        if (findVertexInDpTable(t._1, dpTable).head._2._1 > findVertexInDpTable(vertex, dpTable).head._2._1 + 1){
          findVertexInDpTable(t._1, dpTable).head._1 -> (findVertexInDpTable(vertex, dpTable).head._2._1 + 1.0, vertex)
        }else{
          t
        }
      }else{
        t
      }
    )
  }

  def findVertexInDpTable(vertex: Vertex, dpTable: Map[Vertex, (Double, Vertex)]): Map[Vertex, (Double, Vertex)] = {
    dpTable.filter(v => v._1 == vertex)
  }

  def surroundingCoordinates(vertex: Vertex): List[(Int, Int)] = {
    List(
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

  def surroundingVertexes(vertex: Vertex): Set[Vertex] = {
    val surroundingEmptySpaces = surroundingCoordinates(vertex).map(c =>
      onlyEmptySpaces.filter(v => v.x == c._1 && v.y == c._2)).flatten.toSet
    surroundingEmptySpaces
  }
}
