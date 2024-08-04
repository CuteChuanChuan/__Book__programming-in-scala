package chapterOneToThree

object parenthesisApply extends App {
  def apply(x: Int): Int = x * 2
  
  val result: Int = parenthesisApply(5)
  println(result)
}
