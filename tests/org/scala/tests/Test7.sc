package org.scala.tests

object Test7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	val words = List("apqsr","avadavat","avail","availability","available","avalanche","avantgarde","avarice","avaricious","avast","avatar","avaunt")
                                                  //> words  : List[String] = List(apqsr, avadavat, avail, availability, available
                                                  //| , avalanche, avantgarde, avarice, avaricious, avast, avatar, avaunt)
	val chars = List('p','q','r','s','a')     //> chars  : List[Char] = List(p, q, r, s, a)
/*
	for{w <- words
		  if(w.forall(p => chars.contains(p)))
  } yield w

	words.find(x => x.forall(p => chars.contains(p)))
*/

 words.find(_.diff(chars).isEmpty)                //> res0: Option[String] = Some(apqsr)



}