object chapter1 extends App {
  
  private def factorial(x: BigInt): BigInt =
    if x == 0 then 1 else x * factorial(x - 1)
  
  private val x: Int = 30
  private val factorial_result = this.factorial(x = x)
  
  println(s"$x! = $factorial_result")
}

