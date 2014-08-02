package org.scalaproblems.basic

class P01 {
	def last(xs: List[Int]):Int = {
	  xs(xs.length-1)
	}
	
	def lastRecursive(xs: List[Int]):Int = xs match {
	  case x :: Nil => x
	  case _ :: tail => lastRecursive(tail)
	}
}