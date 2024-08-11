package chapterFourToSix

import ChecksumAccumulator.calculate

// scalac ChecksumAccumulator.scala Summer.scala
// scala chapterFourToSix.Summer of love

object Summer:
  def main(args: Array[String]): Unit =
    for arg <- args do
      println(s"$arg = ${calculate(arg)}")
 
