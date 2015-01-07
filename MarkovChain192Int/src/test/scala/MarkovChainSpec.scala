import org.scalatest.{Matchers, FunSpec}

class MarkovChainSpec extends FunSpec with Matchers {
  val b = new Letter('b')
  val aLetter = new Letter('a')
  val r = new Letter('r')
  val t = new Letter('t')
  val e = new Letter('e')
  val k = new Letter('k')

  describe("with one element list (List('bartek')"){
    val words = List(new Word("bartek"))
    val chain = new MarkovChain(words)

    describe("#create"){
      it("creates proper markov chain"){
        val markovChain = chain.create
        markovChain(b)(aLetter) should be(1)
        markovChain(aLetter)(r) should be(1)
        markovChain(r)(t) should be(1)
        markovChain(t)(e) should be(1)
        markovChain(e)(k) should be(1)
      }
    }
  }

  describe("with one element list (List('babaaaartek')"){
    val words = List(new Word("babaaaartek"))
    val chain = new MarkovChain(words)

    describe("#create"){
      it("creates proper markov chain"){
        val markovChain = chain.create

        markovChain(b)(aLetter) should be(2)
        markovChain(aLetter)(b) should be(1)
        markovChain(aLetter)(aLetter) should be(3)
        markovChain(aLetter)(r) should be(1)
        markovChain(r)(t) should be(1)
        markovChain(t)(e) should be(1)
        markovChain(e)(k) should be(1)
        // some cases for non existing pairs
        markovChain(k)(aLetter) should be(0)
        markovChain(aLetter)(k) should be(0)
        markovChain(b)(e) should be(0)
      }
    }
  }
}
