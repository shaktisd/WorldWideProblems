package org.scala.tests
import org.scalatest._
import org.scalaproblems.basic.P01

class P01Specs extends FlatSpec with Matchers{
  "P01 last" should "find the last element of a list" in {
    val p01 = new P01()
    val list = List(1,2,3,4,5)
    p01.last(list) should be (5)
  }
  
  "P01 lastRecursive" should "find the last element of a list" in {
    val p01 = new P01()
    val list = List(1,2,3,4,5)
    p01.lastRecursive(list) should be (5)
  }

}