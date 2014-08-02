package org.scalaproblems.basic

class P03 {
  def kthElement(k: Int, xs: List[Int]):Int =  {
		  kthElementRecursive(k,0,xs)
  }
  
  def kthElementRecursive(k: Int, index: Int, xs: List[Int]): Int = {
    if(index == k) xs.head
    else kthElementRecursive(k, index+1, xs.tail)
  }
  
  
}