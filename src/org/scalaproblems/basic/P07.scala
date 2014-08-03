package org.scalaproblems.basic

class P07 {
  
  def flat(xs: List[Any]): List[Any] = xs flatMap {
    case ms: List[_] => flat(ms)
    case e => List(e)
  }

}