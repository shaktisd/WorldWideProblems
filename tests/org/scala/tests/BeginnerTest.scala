package org.scala.tests

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalaproblems.basic.P03
import org.scalaproblems.basic.P02
import org.scalaproblems.basic.P01
import org.scalaproblems.basic.P04
import org.scalaproblems.basic.P05
import org.scalaproblems.basic.P06
import org.scalaproblems.basic.P07
import org.scalaproblems.basic.P08
import org.scalaproblems.basic.P09

class BeginnerTest extends FlatSpec with Matchers{
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
  
  "P02" should "find last but one element of the list" in{
    val p02 = new P02()
    val list = List(1,2,3,4,5)
    p02.lastButOne(list) should be (4)
  }

  "P03" should "find the kth element of a list" in {
    val list = List(1,1,2,3,4,5,6)
    val p03 = new P03()
    p03.kthElement(6, list) should be (6)
  }
  
  "P04" should "find the number of elements in a list" in {
    val list = List(1,2,3,4,5)
    val p04 = new P04()
    p04.length(list) should be (5)
    p04.lengthUsingCaseClass(list) should be (5)
    
    val oneElementLIst = List(1)
    p04.length(oneElementLIst) should be (1)
    p04.lengthUsingCaseClass(oneElementLIst) should be (1)
    
    val zeroElementLIst = List()
    p04.length(zeroElementLIst) should be (0)
    p04.lengthUsingCaseClass(zeroElementLIst) should be (0)
    
  }
  
  "P05" should "reverse a list" in {
    val xs = (List(1, 1, 2, 3, 5, 8))
    val p05 = new P05()
    p05.reverse(xs) should be (List(8,5,3,2,1,1))
    p05.reverseTailRecursive(xs) should be (List(8,5,3,2,1,1))
    p05.reversePureFunctional(xs) should be (List(8,5,3,2,1,1))
  }
  
  "P06" should "check if a list is a palindrome or not" in {
    val xs = List(1,2,3,4,3,2,1)
    val p06 = new P06()
    p06.isPalindrome(xs) should be (true)
  }
  
  "P07" should "flatten nested list structure" in {
    val xs = (List(List(1, 1), 2, List(3, List(5, 8))))
    val p07 = new P07()
    p07.flat(xs) should be (List(1,1,2,3,5,8))
  }
  
  "P08" should "compress duplicate consequtive list elements" in {
    val xs = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val p08 = new P08()
    p08.compressR(xs) should be (List('a, 'b, 'c, 'a, 'd, 'e))
    p08.compressL(xs) should be (List('a, 'b, 'c, 'a, 'd, 'e))
  }
  
  "P09" should " pack consequtive duplicate elements into a list" in {
    val xs = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val p09 = new P09()
    val packed  = p09.pack(xs)
    Console.print(packed)
    p09.pack(xs) should be (List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }
  
  
  

}