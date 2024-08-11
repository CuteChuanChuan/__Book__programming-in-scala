package chapterFourToSix

import scala.annotation.{tailrec, targetName}

class Rational (n: Int, d: Int):
  require(d != 0, "denominator must be nonzero")
  private val g: Int = gcd(n.abs, d.abs)
  private val numerator: Int = n / g
  private val denominator: Int = d / g
  
  def this(n: Int) = this(n, 1)
  
  override def toString: String = s"$numerator/$denominator"
  
  @targetName("""add_""")
  def + (that: Rational): Rational =
    Rational(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)
  
  @targetName("""addInt_""")
  def + (that: Int): Rational =
    Rational(numerator + that * denominator, denominator)
  
  @targetName("""mul_""")
  def * (that: Rational): Rational = Rational(numerator * that.numerator, denominator * that.denominator)
  
  @targetName("""mulInt_""")
  def * (that: Int): Rational =
    Rational(numerator * that, denominator)
    
  @targetName("""sub_""")
  def - (that: Rational): Rational =
    Rational(numerator * that.denominator - that.numerator * denominator, denominator * that.denominator)
  
  @targetName("""subInt_""")
  def - (that: Int): Rational =
    Rational(numerator - that * denominator, denominator)
  
  @targetName("""div_""")
  def / (that: Rational): Rational =
    Rational(numerator * that.denominator, denominator * that.numerator)
  
  @targetName("""divInt_""")
  def / (that: Int): Rational =
    Rational(numerator, denominator * that)
  
  def lessThan(that: Rational): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator
  
  def max(that: Rational): Rational =
    if lessThan(that) then that else this
  
  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)
  
extension (x: Int)
  @targetName("""add_""")
  def + (y: Rational): Rational = Rational(x) + y

  @targetName("""mul_""")
  def * (y: Rational): Rational = Rational(x) * y

  @targetName("""sub_""")
  def - (y: Rational): Rational = Rational(x) - y

  @targetName("""div_""")
  def / (y: Rational): Rational = Rational(x) / y


@main def m123(): Unit = {
  val oneHalf = Rational(1, 2)
  val twoThirds = Rational(2, 3)
  println(s"${oneHalf} + ${twoThirds} = ${oneHalf + twoThirds}") // println(oneHalf.+(twoThirds))
  println(s"${oneHalf} - ${twoThirds} = ${oneHalf - twoThirds}") // println(oneHalf.*(twoThirds))
  println(s"${oneHalf} * ${twoThirds} = ${oneHalf * twoThirds}") // println(oneHalf.-(twoThirds))
  println(s"${oneHalf} / ${twoThirds} = ${oneHalf / twoThirds}") // println(oneHalf./(twoThirds))
  
  println(2 * oneHalf)
  
  println(oneHalf.lessThan(twoThirds))
  println(oneHalf.max(twoThirds))
  
  val two = Rational(2)
  println(two)
  
  val elevenSeven = Rational(66, 42)
  println(elevenSeven)
}

