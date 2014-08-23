package org.scala.tests

import scala.collection.immutable.TreeSet
import com.sun.xml.internal.ws.policy.spi.PrefixMapper

object Test6 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val map1: Map[Char,String] = Map('a' -> "Alpha" , 'b' -> "Beta" )
                                                  //> map1  : Map[Char,String] = Map(a -> Alpha, b -> Beta)
  val map2: Map[String,Int] = Map("Alpha" -> 1, "Beta" -> 2)
                                                  //> map2  : Map[String,Int] = Map(Alpha -> 1, Beta -> 2)
	
	val result = map2.get(map1.getOrElse('c',"Not found"))
                                                  //> result  : Option[Int] = None
	
	case class Trie(value: Option[String], map: Map[Char,Trie])
	
	def add(result: Trie, v: String,prefix: String = ""): Trie = {
	???
	}                                         //> add: (result: org.scala.tests.Test6.Trie, v: String, prefix: String)org.scal
                                                  //| a.tests.Test6.Trie
	
	val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
                                                  //> ts  : scala.collection.immutable.TreeSet[Int] = TreeSet(0, 1, 2, 3, 4, 5, 6,
                                                  //|  7, 8, 9)
	ts.find(_ == 3)                           //> res0: Option[Int] = Some(3)
	
	
	
}