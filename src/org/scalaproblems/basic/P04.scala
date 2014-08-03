package org.scalaproblems.basic

class P04 {
  
  def length(xs: List[Int]): Int = {
    lengthRecursive(1, xs)
  }
  
  def lengthRecursive(size: Int,xs: List[Int]):Int = {
    if(xs == Nil) 0
    else if(xs.tail == Nil) size
    else lengthRecursive(size + 1, xs.tail)
  }
  
  def lengthUsingCaseClass(xs: List[Int]): Int = xs match {
    case Nil => 0
    case _ :: tail => 1 + lengthUsingCaseClass(tail)
  }

}