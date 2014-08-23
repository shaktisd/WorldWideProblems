package org.questions

import scala.io.Source

class Repo extends App {
  //can't pattern match on string in 2.9, so if (s.isEmpty) is used instead. 
  //Alt: use List[Cha] instead, would be faster to repeatedly slice off first character

  case class Trie(v: Option[String], m: Map[Char, Trie])

  def add(t: Trie, s: String, p: String = ""): Trie = {
    if (s.isEmpty) t 
    else Trie(t.v, t.m.updated(
                    s.head, 
                    add(t.m.getOrElse(s.head, Trie(Some(p + s.head), Map.empty)), 
                        s.tail, 
                        p + s.head)))
  }
  
  
  val trie0 = Trie(None,Map(('1',null)))
  val trie1 = add(trie0,"Hello")
  
  def process(args: Array[String]): Unit = {
    val inputFiles = Source.fromFile("wordlist.txt").getLines()
    while(inputFiles.hasNext){
      println(inputFiles.next())
    }
  }
  
  
  
}