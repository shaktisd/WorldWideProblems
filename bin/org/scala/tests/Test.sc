package org.scala.tests

import org.scalaproblems.basic.P09

object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = List(1,5,13,44,59)                     //> xs  : List[Int] = List(1, 5, 13, 44, 59)
  xs.foldLeft(0)((l,r) => if(l == r) l else l + r)//> res0: Int = 122
  
  xs.foldLeft(0)((l,r) => { println(l + " " + r); (l + r)})
                                                  //> 0 1
                                                  //| 1 5
                                                  //| 6 13
                                                  //| 19 44
                                                  //| 63 59
                                                  //| res1: Int = 122
	val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
                                                  //> ls  : List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e
                                                  //| , 'e)
	
	// List('a, 'b, 'c, 'a, 'd, 'e)
	
	def compress(list: List[Any]): List[Any] =  {
		def compressR(result: List[Any], originalList: List[Any]): List[Any] = {
			if(originalList == Nil) result
			else if(originalList.size == 1) compressR(originalList.head :: result, originalList.tail)
			else if(originalList.head == originalList.tail.head) compressR(originalList.head :: result, originalList.tail)
			else compressR(originalList.tail.head :: originalList.head :: result, originalList.tail)
		}
		compressR(List(),list)
	}                                         //> compress: (list: List[Any])List[Any]

	compress(ls)                              //> res2: List[Any] = List('e, 'e, 'e, 'e, 'e, 'd, 'd, 'a, 'a, 'a, 'c, 'c, 'c, '
                                                  //| b, 'b, 'a, 'a, 'a, 'a)


	//val xs1 = List(1,1,2,2,3,3)
	val xs1 = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
                                                  //> xs1  : List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, '
                                                  //| e, 'e)
	val p9 = new P09()                        //> p9  : org.scalaproblems.basic.P09 = org.scalaproblems.basic.P09@19b0b39a
	p9.pack(xs1)                              //> java.util.NoSuchElementException: head of empty list
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:420)
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:417)
                                                  //| 	at org.scalaproblems.basic.P09.pack(P09.scala:12)
                                                  //| 	at org.scalaproblems.basic.P09.pack(P09.scala:6)
                                                  //| 	at org.scala.tests.Test$$anonfun$main$1.apply$mcV$sp(org.scala.tests.Tes
                                                  //| t.scala:31)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at org.scala.tests.Test$.main(org.scala.tests.Test.scala:5)
                                                  //| 	at org.scala.tests.Test.main(org.scala.tests.Test.scala)

}