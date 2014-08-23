package org.scala.tests

object Test5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val serverCapacity = List(8, 16, 8, 32 )        //> serverCapacity  : List[Int] = List(8, 16, 8, 32)
  val tasks = List(18, 4, 8, 4, 6, 6, 8, 8)       //> tasks  : List[Int] = List(18, 4, 8, 4, 6, 6, 8, 8)
  val s = serverCapacity.sortBy(- _) // desc sort //> s  : List[Int] = List(32, 16, 8, 8)
  val t = tasks.sortBy(- _)                       //> t  : List[Int] = List(18, 8, 8, 8, 6, 6, 4, 4)
  for( i <- s; j <- t)yield (i,j)                 //> res0: List[(Int, Int)] = List((32,18), (32,8), (32,8), (32,8), (32,6), (32,6
                                                  //| ), (32,4), (32,4), (16,18), (16,8), (16,8), (16,8), (16,6), (16,6), (16,4), 
                                                  //| (16,4), (8,18), (8,8), (8,8), (8,8), (8,6), (8,6), (8,4), (8,4), (8,18), (8,
                                                  //| 8), (8,8), (8,8), (8,6), (8,6), (8,4), (8,4))
  // try to fit in self if capacity permits
  // if overcapacity pick the next server
  // if last one fails

 

}