// Don't delete the comment below -- it is a Scala-CLI "using" directive to instruct it to use the munit test framework
//> using test.dep org.scalameta::munit::0.7.29

package cosc250.firststeps

import StepOne._

/**
  * This is a unit test file.
  * 
  * We're using MUnit, which is a Scala testing library built on top of JUnit (the most popular Java testing library).
  * This means most IDEs will already have support for it.
  * 
  */
class FirstStepsSuite extends munit.FunSuite {
  
  // This is just here as a test that the testing framework is working!
  test("The test framework should run (1 + 1 == 2)") {
    assertEquals(2, 1 + 1)
  }
  
  test("doubleArray should return an array of doubled numbers") {
    assertEquals(doubleArray(Array(1, 2, 3)).toList, (Array(2, 4, 6)).toList)
    assertEquals(doubleArray(Array(9, 7, 5, 12)).toList, (Array(18, 14, 10, 24)).toList)
  }


  test("timesPosition should mutliply the elements of an array by their position") {
    assertEquals(timesPosition(Array(1, 2, 3)).toList, (Array(1 * 0, 2 * 1, 3 * 2)).toList)
    assertEquals(timesPosition(Array(9, 7, 5, 12)).toList, (Array(9 * 0, 7 * 1, 5 * 2, 12 * 3)).toList)
  }


  test("doubleList should double the contents of a List") {
    assertEquals(doubleList(List(1, 2, 3)), (List(2, 4, 6)))
    assertEquals(doubleList(List(9, 7, 5, 12)), (List(18, 14, 10, 24)))
  }


  test("matchingLetters should return tuples of all the matching locations in two strings") {
    assertEquals(matchingLetters("frogs", "eggs").toSet, (List(3 -> 1, 3 -> 2, 4 -> 3).toSet))
  }

  test("Roman should calculate roman numerals") {
    assertEquals(roman(1), ("I"))
    assertEquals(roman(2), ("II"))
    assertEquals(roman(4), ("IV"))
    assertEquals(roman(9), ("IX"))
    assertEquals(roman(21), ("XXI"))
    assertEquals(roman(61), ("LXI"))
    assertEquals(roman(1981), ("MCMLXXXI"))
    assertEquals(roman(1991), ("MCMXCI"))
  } 
  
}
