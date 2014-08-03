package org.scalaproblems.basic

class P05 {
  
  def reverse(xs: List[Int]):List[Int] = xs match {
    case Nil => Nil
    case x :: tail => reverse(tail) ::: List(x)
  }
  
  def reverseTailRecursive(xs: List[Int]): List[Int] =  {
    def reverseR(accumulator: List[Int],rest : List[Int]): List[Int] = rest match {
    	case Nil => accumulator	
    	case x :: tail => reverseR(x :: accumulator,tail)
    }
    reverseR(Nil,xs)
  }
  
  def reversePureFunctional(xs: List[Int]): List[Int] = {
    xs.foldLeft(List[Int]()) { (r, h) => h :: r }
  }
  

}