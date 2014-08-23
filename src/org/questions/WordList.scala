package org.questions

import scala.io.Source

object WordList extends App{
  
  case class Trie(v: Option[String], m: Map[Char,Trie])
  
  def add(trie: Trie, word: String, prefix: String = "" ): Trie = {
    ???
  }
  
  
  def readFile(fileName: String):Unit = {
    val inputFile = Source.fromFile(fileName).getLines()
    while(inputFile.hasNext){
      println(inputFile.next())
    }
  }
  
  readFile("wordlist.txt")

}