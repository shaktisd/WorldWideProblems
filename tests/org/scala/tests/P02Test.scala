package org.scala.tests

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import org.scalaproblems.basic.P02

class P02Test extends FlatSpec with Matchers {
  
  "P02" should "find last but one element of the list" in{
    val p02 = new P02()
    val list = List(1,2,3,4,5)
    p02.lastButOne(list) should be (4)
  }

}