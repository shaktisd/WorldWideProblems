package org.scala.tests

object Test3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def multiple_of = (base: Long, target: Long) => target % base == 0;
                                                  //> multiple_of: => (Long, Long) => Boolean

  val twoFilter = multiple_of(2, _: Long)         //> twoFilter  : Long => Boolean = <function1>
  val threeFilter = multiple_of(3, _: Long)       //> threeFilter  : Long => Boolean = <function1>

  println(twoFilter(4))                           //> true
  println(twoFilter(5))                           //> false
  println(twoFilter(6))                           //> true
  println(threeFilter(4))                         //> false
  println(threeFilter(5))                         //> false
  println(threeFilter(6))                         //> true

  def filter = (x: Long) => multiple_of(x, _: Long);
                                                  //> filter: => Long => (Long => Boolean)

  val fs = List(filter(2), filter(3))             //> fs  : List[Long => Boolean] = List(<function1>, <function1>)
  for (f <- fs) {
    println("Eight is a multiple of this " + f + "filter: " + f(8))
                                                  //> Eight is a multiple of this <function1>filter: true
                                                  //| Eight is a multiple of this <function1>filter: false
  }

  def relatively_prime(fs: List[(Long) => Boolean], target: Long): Boolean = {
    for (f <- fs) {
      if (f(target)) {
        return false;
      }
    }
    return true;
  }                                               //> relatively_prime: (fs: List[Long => Boolean], target: Long)Boolean

  println("4 is prime? " + relatively_prime(fs, 4))
                                                  //> 4 is prime? false
  println("5 is prime? " + relatively_prime(fs, 5))
                                                  //> 5 is prime? true

  val list = List[Long](2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
                                                  //> list  : List[Long] = List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
  println(list.map(relatively_prime(fs, _)))      //> List(false, false, false, true, false, true, false, false, false, true)

  def next_prime(fs: List[(Long) => Boolean], x: Long): Long = {
    if (relatively_prime(fs, x)) {
      return x
    }
    return next_prime(fs, x + 1)
  }                                               //> next_prime: (fs: List[Long => Boolean], x: Long)Long

  println(next_prime(fs, 4))                      //> 5
  println(next_prime(fs, 8))                      //> 11
  
  
  
}