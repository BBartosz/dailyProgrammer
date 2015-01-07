import org.scalatest.{Matchers, FunSpec}

class CarryAdderSpec extends FunSpec with Matchers {
  val adder = CarryAdder(List(23,45,123))

  describe("#mapNumbers"){
    it("creates proper map of numbers"){
      val twentyThree = Map(
        new Index(0) ->  new Digit(3),
        new Index(1) ->  new Digit(2)
      )
      val fortyFive = Map(
        new Index(0) ->  new Digit(5),
        new Index(1) ->  new Digit(4)
      )
      val oneTwoThree = Map(
        new Index(0) ->  new Digit(3),
        new Index(1) ->  new Digit(2),
        new Index(2) ->  new Digit(1)
      )
      adder.mapNumbers should be(List(twentyThree, fortyFive, oneTwoThree))
    }
  }

  describe("#maxIndexNumber"){
    it ("returns 2 for 123"){
      adder.maxIndexNumber(adder.mapNumbers.last) should be(2)
    }
  }

  describe("#maxDigitsNumber"){
    it ("returns 3"){
      adder.maxDigitsNumber should be(3)
    }
  }

  describe("#mapsForComputations"){
    it("adds indexes with values zero to the front of smaller than biggest number"){
      val twentyThree = Map(
        new Index(0) ->  new Digit(3),
        new Index(1) ->  new Digit(2),
        new Index(2) ->  new Digit(-1)
      )
      val fortyFive = Map(
        new Index(0) ->  new Digit(5),
        new Index(1) ->  new Digit(4),
        new Index(2) ->  new Digit(-1)
      )
      val oneTwoThree = Map(
        new Index(0) ->  new Digit(3),
        new Index(1) ->  new Digit(2),
        new Index(2) ->  new Digit(1)
      )
      adder.mapsForComputations should be(List(twentyThree, fortyFive, oneTwoThree))
    }

    describe("for numbers 9,12,9,345,9,9") {
      val adder = CarryAdder(List(9,12,9,345,9,9))
      it("returns proper maps for computations"){
        val first = Map(
          new Index(0) ->  new Digit(9),
          new Index(1) ->  new Digit(-1),
          new Index(2) ->  new Digit(-1)
        )
        val sec = Map(
          new Index(0) ->  new Digit(2),
          new Index(1) ->  new Digit(1),
          new Index(2) ->  new Digit(-1)
          )
        val third = Map(
          new Index(0) ->  new Digit(9),
          new Index(1) ->  new Digit(-1),
          new Index(2) ->  new Digit(-1)
        )
        val fourth = Map(
          new Index(0) ->  new Digit(5),
          new Index(1) ->  new Digit(4),
          new Index(2) ->  new Digit(3)
        )
        val fifth = Map(
          new Index(0) ->  new Digit(9),
          new Index(1) ->  new Digit(-1),
          new Index(2) ->  new Digit(-1)
        )
        val sixth = Map(
          new Index(0) ->  new Digit(9),
          new Index(1) ->  new Digit(-1),
          new Index(2) ->  new Digit(-1)
        )
        adder.mapsForComputations.head should be(first)
        adder.mapsForComputations should be(List(first, sec, third, fourth, fifth, sixth))
      }
    }
  }

  describe("#makeCarries"){
    it("returns proper carries map"){
      val carries: Map[Index, List[Int]] = Map(
        new Index(0) -> List(),
        new Index(1) -> List(1),
        new Index(2) -> List(),
        new Index(3) -> List()
      )
      adder.makeCarries should be(carries)
    }

    describe("for numbers 9,9,9"){
      val adder = CarryAdder(List(9,9,9))

      it("returns proper carries map"){
        val carries: Map[Index, List[Int]] = Map(
          new Index(0) -> List(),
          new Index(1) -> List(1,1)
        )
        adder.makeCarries should be(carries)
      }
    }

    describe("for numbers 9,9,9,9,9,9,9,9,9,9,9,9"){
      val adder = CarryAdder(List(9,9,9,9,9,9,9,9,9,9,9,9))

      it("returns proper carries map"){
        val carries: Map[Index, List[Int]] = Map(
          new Index(0) -> List(),
          new Index(1) -> List(1,1,1,1,1,1,1,1,1,1)
        )
        adder.makeCarries should be(carries)
      }
    }

    describe("for numbers 999,999"){
      val adder = CarryAdder(List(999,999))

      it("returns proper carries map"){
        val carries: Map[Index, List[Int]] = Map(
          new Index(0) -> List(),
          new Index(1) -> List(1),
          new Index(2) -> List(1),
          new Index(3) -> List(1)
        )
        adder.makeCarries should be(carries)
      }
    }

    describe("for numbers 99, 99, 99"){
      val adder = CarryAdder(List(99, 99, 99))

      it("returns proper carries map"){
        val carries: Map[Index, List[Int]] = Map(
          new Index(0) -> List(),
          new Index(1) -> List(1, 1),
          new Index(2) -> List(1, 1)
        )
        adder.makeCarries should be(carries)
      }
    }

    describe("for numbers 9,12,9,9,9,9,9,9"){
      val adder = CarryAdder(List(9,12,9,9,9,9,9,9))

      it("returns proper carries map"){
        val carries: Map[Index, List[Int]] = Map(
          new Index(0) -> List(),
          new Index(1) -> List(1, 1, 1, 1, 1, 1),
          new Index(2) -> List()
        )
        adder.makeCarries should be(carries)
      }
    }
  }
}


