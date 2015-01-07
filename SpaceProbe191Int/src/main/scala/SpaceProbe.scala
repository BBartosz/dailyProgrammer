object SpaceProbe {
  def main (args: Array[String]) {
    val spaceDimension = 20
    val emptySpace = new EmptySpaceBoard(new EmptySpace(0,0),new EmptySpace(19,19), spaceDimension)
    val asteroidSpace = new AsteroidsBoard(emptySpace, 100)
    val gravityWellSpace = new GravityWellBoard(asteroidSpace, 10)
    val dijkstra = new Dijkstra(gravityWellSpace)
    val runBoard = dijkstra.run
    new BoardPrinter(gravityWellSpace, runBoard).print

    println(runBoard(emptySpace.end))
  }
}
