package org.questions
/*
 * Given 2 set of arrays of size N(sorted +ve integers ) find the median of the resultant array of size 2N. 
(dont even think of sorting the two arrays in a third array , though u can sort them.
Try something better than order NLogN
 */

object Median extends App{
  val list1 = List(1,2,3,4,5,6,7,8,9)
  val list2 = List(5,6,7,8,9,10,11,12,13)
  
  def medianOfSortedArrays(ls1: List[Int], ls2: List[Int]): Int = {
    val N = list1.size
    val m1 = median(ls1)
    val m2 = median(ls2)
    println("Median " + m1 + " list1 " + m2 + " list2 ")
    
    if(m1 == m2) m1
    else if(m1 < m2) median(ls1)
    else {???}
    0
    
  }
  
  def median(s: Seq[Int])  =  {
    val (lower, upper) = s.sortWith(_<_).splitAt(s.size / 2)
    if (s.size % 2 == 0) (lower.last + upper.head) / 2.0 else upper.head
  }
  
  medianOfSortedArrays(list1,list2)
  
}