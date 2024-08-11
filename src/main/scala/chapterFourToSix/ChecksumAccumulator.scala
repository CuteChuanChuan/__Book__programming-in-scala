package chapterFourToSix

import scala.collection.mutable

case class Person(name: String, age: Int):
  def appendToName(suffix: String): Person = Person(s"$name$suffix", age)

class ChecksumAccumulator {
  private var sum = 0
  
  // A side effect is generally defined as mutating state somewhere external to the method or performing an I/O action.
  // In add's case, the side effect is that sum is reassigned.A method that is executed only for its side effects is known as a procedure.
  def add(b: Byte): Unit = sum += b
  
  def checksum(): Int = ~(sum & 0xFF) + 1
}

// When a singleton object shares the same name with a class, it is called that class’s companion object.
// A class and its companion object can access each other’s private members.

// One difference between classes and singleton objects is that singleton objects cannot take parameters, whereas classes can
// Because you can’t instantiate a singleton object with the new keyword, you have no way to pass parameters to it.

// A singleton object that does not share the same name with a companion class is called a standalone object.
// You can use standalone objects for many purposes, including collecting related utility methods together or defining an entry point to a Scala application
object ChecksumAccumulator{
  val cache = mutable.Map.empty[String, Int]
  
  def calculate(s: String): Int =
    if cache.contains(s) then
      println("Using cached value")
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for c <- s do // check through each character in the passed string
        acc.add((c >> 8).toByte)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}

object Person:
  def apply(name: String, age: Int): Person =
    val capitalizedName =
      if name.nonEmpty then
        val firstChar = name.charAt(0).toUpper
        val restOfName = name.substring(1).toLowerCase()
        s"$firstChar$restOfName"
      else throw new IllegalArgumentException("Name cannot be empty")
    new Person(capitalizedName, age)


@main def m1(): Unit = {
  val acc = new ChecksumAccumulator
  acc.add(1)
  acc.add(2)
  println(acc.checksum())
  println(ChecksumAccumulator.calculate("Every value is an object."))
  println(ChecksumAccumulator.cache)
  println(ChecksumAccumulator.calculate("I am Raymond."))
  println(ChecksumAccumulator.cache)
  println(ChecksumAccumulator.calculate("I am Raymond."))
  
  val person = Person("Raymond", 23)
  println(person.name)
  println(person.toString)
  println(person.hashCode())
  println(person.hashCode() == Person("Raymond", 23).hashCode())
  
  val q = Person("sally", 39)
  q.appendToName(" Smith")
}