import org.scalatest.{Matchers, FunSpec}

class AsteroidBoardSpec extends FunSpec with Matchers {
  describe("value"){
    describe("when space size is 2 and amount is 2"){
      val emptyBoard = new EmptySpaceBoard(new EmptySpace(0,0), new EmptySpace(1,1), 2)
      val asteroidSpace = new AsteroidsBoard(emptyBoard, 2)
      val board = asteroidSpace.value

      it("creates 2 asteroids"){
        board.filter{ case Asteroid(x,y) => true; case EmptySpace(x,y) => false}.length should be(2)
      }

      it("second vertex should be asteroid with coordinates (1,0)"){
        board(1) should be(Asteroid(1,0))
      }
      it("third vertex should be asteroid with coordinates (0,1)"){
        board(2) should be(Asteroid(0,1))
      }
    }

    describe("When space size is 9 and amount is 4"){
      val emptyBoard = new EmptySpaceBoard(new EmptySpace(0,0), new EmptySpace(8,8), 9)
      val asteroidSpace = new AsteroidsBoard(emptyBoard, 4)
      val board = asteroidSpace

      it("creates 4 asteroids"){
        board.value.filter{ case Asteroid(x,y) => true; case EmptySpace(x,y) => false}.length should be(4)
      }

      it("doesnt change start point of board"){
        board.start should be(EmptySpace(0,0))
      }

      it("doesnt change end point of board"){
        board.end should be(EmptySpace(8,8))
      }
    }
  }
}

