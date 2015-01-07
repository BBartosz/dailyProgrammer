import org.scalatest.{Matchers, FunSpec}

class EmptySpaceBoardSpec extends FunSpec with Matchers {
  describe("value"){
    describe("when space size is 2"){
      val emptySpace = new EmptySpaceBoard(new EmptySpace(0,0), new EmptySpace(1,1), 2)
      val map = emptySpace.value

      it("is a list of vertex with length 4"){
        map.length should be(4)
      }

      it("first vertex has got coordinates (0,0)"){
        map.head.x should be(0)
        map.head.y should be(0)
      }
      it("second vertex has got coordinates (1,0)"){
        map(1).x should be(1)
        map(1).y should be(0)
      }
      it("third vertex has got coordinates (0,1)"){
        map(2).x should be(0)
        map(2).y should be(1)
      }
      it("fourth vertex has got coordinates (1,1)"){
        map(3).x should be(1)
        map(3).y should be(1)
      }
    }

    describe("when space size is 9"){
      val emptySpace = new EmptySpaceBoard(new EmptySpace(0,0), new EmptySpace(1,1), 9)
      val map = emptySpace.value

      it("creates list of vertex with length 81"){
        map.length should be(81)
      }
    }
  }
}
