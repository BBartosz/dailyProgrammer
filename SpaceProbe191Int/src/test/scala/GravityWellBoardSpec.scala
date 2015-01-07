import org.scalatest.{Matchers, FunSpec}

class GravityWellBoardSpec extends FunSpec with Matchers {
  describe("when space size is 3") {
    val emptyBoard = new EmptySpaceBoard(new EmptySpace(0, 0), new EmptySpace(2, 2), 3)

    describe("when there are no asteroids"){
      val asteroidSpace = new AsteroidsBoard(emptyBoard, 0)

      describe("when there are 2 gravity wells"){
        describe("value") {
          val gravityWellSpace = new GravityWellBoard(asteroidSpace, 2)
          val board = gravityWellSpace

          it("doesnt change start point of board"){
            board.start should be(EmptySpace(0,0))
          }

          it("doesnt change end point of board"){
            board.end should be(EmptySpace(2,2))
          }

          it("all vertexes excluding start and and  should be gravity wells") {
            board.value(1) should be(GravityWell(1, 0))
            board.value(2) should be(GravityWell(2, 0))
            board.value(3) should be(GravityWell(0, 1))
            board.value(4) should be(GravityWell(1, 1))
            board.value(5) should be(GravityWell(2, 1))
            board.value(6) should be(GravityWell(0, 2))
            board.value(7) should be(GravityWell(1, 2))
          }
        }
      }
      describe("when there are no gravity wells"){
        describe("value") {
          val gravityWellSpace = new GravityWellBoard(asteroidSpace, 0)
          val board = gravityWellSpace

          it("creates 0 gravity wells"){
            board.value.filter{ case GravityWell(x,y) => true; case _ => false}.length should be(0)
          }
        }

      }

    }
  }
}
