package org.scalaproblems.basic

class P02 {
	def lastButOne(xs: List[Int]):Int =xs match {
	  case x :: y :: Nil => x
	  case _ :: tail => lastButOne(tail)
	}
}