package cosc250.firststeps

import scala.annotation.tailrec

/**
  * Now we know about higher order functions, let's go back to the first tutorial and see if they can help us solve
  * the exercises. You are welcome to use the "for" notation, which is syntactic sugar for map and flatMap, and so
  * is calling higher order functions!
  */
object StepOne {

  /**
    * Double every element in an array.
    *
    * Start off by doing this iteratively. And then we'll discover how much shorter it is functionally.
    */
  def doubleArray(arr:Array[Int]):Array[Int] = arr.map(_*2)

  /**
    * Multiply every element in an array by its position in the array
    * eg, for [3, 4, 2, 6, 2] [3 * 0, 4 * 1, 2 * 2, 6 * 3, 2 * 4]
    *
    * You might need zipWithIndex here...
    */
  def timesPosition(arr:Array[Int]):Array[Int] = arr.zipWithIndex.map{case (a,b)=> a * b}


  /**
    * Ok, we did that for arrays. Now, what if we want to do it for lists?
    * Hint: if you're working imperatively and mutably, you can start with an Array and then go .toList on it at the end
    */
  def doubleList(arr:List[Int]):List[Int] = arr.map(_ * 2)


  /**
    * Suppose we are compiling a crossword. Given two words, find all the pairs of positions where those
    * words have letters in commong. eg, for "frogs" and "eggs", we would return
    * List((3,1), (3,2), (4,3)
    */
  def matchingLetters(wordA:String, wordB:String):List[(Int, Int)] = {
    val seq = for {
        (charA,indexA) <- wordA.zipWithIndex
        (charB, indexB) <- wordB.zipWithIndex
        if (charA == charB)
      }
        yield (indexA,indexB)

    seq.toList
  }


  /**
    * Ok, the Roman Numerals one is harder to do this way, but I'll leave it here for anyone who's keen. You can skip
    * it and head on to the Sudoku exercise if you'd prefer.
    */
  def roman(i:Int):String = {
    val numerals = List(
      1000 -> "M",
      900 -> "CM",
      500 -> "D",
      400 -> "CD",
      100 -> "C",
      90 -> "XC",
      50 -> "L",
      40 -> "XL",
      10 -> "X",
      9 -> "IX",
      5 -> "V",
      4 -> "IV",
      1 -> "I"
    )

    def buildRoman(n: Int, numerals: List[(Int, String)]): String = numerals match {
      case (value, symbol) :: tail if n >= value => symbol + buildRoman(n - value, numerals)
      case _ :: tail => buildRoman(n, tail)
      case Nil => ""
    }

    buildRoman(i, numerals)
  }
  /*
   * Ok, now that's done, time to write a little Sudoku solver, and meet another higher order function: filter
   */

}
