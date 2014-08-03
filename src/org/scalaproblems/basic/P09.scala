package org.scalaproblems.basic

class P09 {
  
 def pack[A](ls: List[A]): List[List[A]] = {
   pack(List(List()),ls).reverse
 }
  
 private def pack[A](result: List[List[A]], ls: List[A]): List[List[A]] = {
		if(ls == Nil) result
		else if(result.head.isEmpty) pack(List(List(ls.head)),ls.tail)
		else if(ls.head == result.head.head) {
		  pack((ls.head :: result.head ) :: result.tail,ls.tail)
		}
		else pack(List(ls.head) :: result,ls.tail)
	}  

}

object P09 {
  def main(args: Array[String]):Unit = {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val p09 = new P09()
    val result = p09.pack(list)
    println(result);
  }
}