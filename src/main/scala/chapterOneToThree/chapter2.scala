package chapterOneToThree

object chapter2 extends App {
  
  private def max(x: Int, y: Int): Int = if x > y then x else y
  
  private def greet(): Unit = println("Hello")
  
  private val result = max(x = 5, y = 10)
  
  println(result)
  greet()
}
