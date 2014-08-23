package org.scala.tests

object Test8 {
  val words = List("adoty","atody","adtoy","cat","mat","bat","sat","hat")
                                                  //> words  : List[String] = List(adoty, atody, adtoy, cat, mat, bat, sat, hat)
	val letters = "today".toList              //> letters  : List[Char] = List(t, o, d, a, y)
	
	val map = words.groupBy(_.size)           //> map  : scala.collection.immutable.Map[Int,List[String]] = Map(5 -> List(adot
                                                  //| y, atody, adtoy), 3 -> List(cat, mat, bat, sat, hat))
	
	 map.keys.toList.sortBy(- _).foreach(
	 	x => map.get(x).get.filter(_.diff(letters).isEmpty())
	 )
   def pickFromMax(w: List[String], l: List[Char]): List[String] = {
	 		w.filter(_.diff(l).isEmpty())
   }                                              //> pickFromMax: (w: List[String], l: List[Char])List[String]
   
	// map.keys.toList.sortBy(- _).
//		map.get(i).get.filter(_.diff(letters).isEmpty())
  	
  words.filter(_.diff(letters).isEmpty())         //> res0: List[String] = List(adoty, atody, adtoy)
  
}