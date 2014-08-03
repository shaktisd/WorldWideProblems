package org.scalaproblems.basic

class P10{

  def encode[A](xs: List[A]): List[(Int,A)] = {
	  def encodeR[A](result: List[(Int,A)],xs: List[A]): List[(Int,A)] = {
		  if(xs == Nil) result
		  else if(result == Nil) encodeR((1,xs.head) :: result,xs.tail)
		  else if(xs.head == result.head._2) encodeR((result.head._1 + 1, result.head._2) :: result.tail,xs.tail)
		  else  encodeR((1,xs.head) :: result,xs.tail)
	  }
	    encodeR(Nil,xs).reverse
  }
}