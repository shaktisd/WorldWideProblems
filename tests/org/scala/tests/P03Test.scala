package org.scala.tests

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import org.scalaproblems.basic.P03

class P03Test extends FlatSpec with Matchers{

  "P03" should "find the kth element of a list" in {
    val list = List(1,1,2,3,4,5,6)
    val p03 = new P03()
    p03.kthElement(6, list) should be (6)
  }
}