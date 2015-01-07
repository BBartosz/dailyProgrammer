case class EmptySpaceBoard(start: Vertex, end: Vertex, size: Int) extends Board{
  val spaceDimension = size
  lazy val value: List[Vertex] = {
    def loop(sizeY: Int, space: List[Vertex]): List[Vertex] = {
      if (sizeY == size ) {
        space
      } else {
        loop(sizeY + 1,  space ::: generateSpaceRow(sizeY, space))
      }
    }
    loop(minAxisIndex, List())
  }

  private def generateSpaceRow(sizeY: Int, space: List[Vertex]): List[Vertex] = {
    def loop(x:Int, spaceRow: List[Vertex]): List[Vertex] = {
      if (x < 0){
        spaceRow
      }else{
        loop(x - 1, new EmptySpace(x, sizeY) :: spaceRow)
      }
    }
    loop(maxAxisIndex, List())
  }

  private def maxAxisIndex: Int = {
    size - 1
  }

  private def minAxisIndex: Int = {
    0
  }
}
