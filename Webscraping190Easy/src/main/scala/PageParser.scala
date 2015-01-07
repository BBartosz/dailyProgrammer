import org.htmlcleaner.{HtmlCleaner, TagNode}

import scala.io.Source

class PageParser(val url: String) {
  def findComments(): Array[Comment] = {
    for{
      elem <- getPageElements()
      if isElemAComment(elem)
      comment = elem.getText.toString

    } yield new Comment(comment)
//    getPageElements().filter(elem => isElemAComment(elem)).map(elem => elem.getText.toString).map(
//      c => new Comment(c)
//    )
  }


  private def getPageElements(): Array[TagNode] = {
    val cleaner = new HtmlCleaner()
    val rootNode = cleaner.clean(Source.fromURL(url).mkString)
    rootNode.getElementsByName("div", true)
  }

  private def isElemAComment(elem: TagNode): Boolean = {
    val typeClass: String = elem.getAttributeByName("class")
    typeClass != null && typeClass.equalsIgnoreCase("Ct")
  }
}
