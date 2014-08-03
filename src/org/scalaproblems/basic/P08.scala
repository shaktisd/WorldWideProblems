package org.scalaproblems.basic

class P08 {
	def compressR[A](xs: List[A]):List[A] = {
	  xs.foldRight(List[A]()){
	    ((h,r) => if(r.isEmpty || r.head != h) h :: r else r)
	  }
	}
	
	def compressL[A](xs: List[A]): List[A] = {
	  val x = xs.foldLeft(List[A]())({
	    (l,r) => if (l.isEmpty || l.head != r) r :: l else l
	  })
	  x.reverse
	}
}