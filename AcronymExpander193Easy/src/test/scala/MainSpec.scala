import org.scalatest.{Matchers, FunSpec}

class MainSpec extends FunSpec with Matchers{
  describe("#translate, input: wtf that was unfair"){
    val input = "wtf that was unfair"
    it("translates properly to: what the fuck that was unfair"){
      Main.translate(input) should be("what the fuck that was unfair")
    }
  }

  describe("#translate, input: gl all hf"){
    val input = "gl all hf"
    it("translates properly to: good luck all have fun"){
      Main.translate(input) should be("good luck all have fun")
    }
  }

  describe("#translate, input: imo that was wp. Anyway I've g2g"){
    val input = "imo that was wp. Anyway I've g2g"
    it("translates properly to: in my opinion that was well played. Anyway I've got to go"){
      Main.translate(input) should be("in my opinion that was well played. Anyway I've got to go")
    }
  }
}
