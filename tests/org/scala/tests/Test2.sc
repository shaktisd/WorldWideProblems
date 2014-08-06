package org.scala.tests

object Test2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  11 % 3                                          //> res0: Int(2) = 2
	1234567891 % 2                            //> res1: Int(1) = 1
	1234567891 % 3                            //> res2: Int(1) = 1
	1234567891 % 5                            //> res3: Int(1) = 1
	1234567891 % 7                            //> res4: Int(4) = 4
	Math.sqrt(1234567891)                     //> res5: Double = 35136.41830067487
	val x= 0 until 10                         //> x  : scala.collection.immutable.Range = Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                                                  //| 
  x.filter(_ % 2 != 0).filter(_ % 3 != 0).filter(_ % 5 != 0).filter(_ % 7 != 0).filter(_ % 11 != 0)
                                                  //> res6: scala.collection.immutable.IndexedSeq[Int] = Vector(1)
	
	def myFilter(x: Int,y: Int):Boolean = {
		if(x ==y) true
		else if(x % y != 0) true
		else false
	}                                         //> myFilter: (x: Int, y: Int)Boolean
	
  //(100 until (9999)).filter(x => myFilter(x,2)).filter( x=> myFilter(x,3))

	 val xs = 10 until 99                     //> xs  : scala.collection.immutable.Range = Range(10, 11, 12, 13, 14, 15, 16, 1
                                                  //| 7, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 3
                                                  //| 6, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 5
                                                  //| 5, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 7
                                                  //| 4, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 9
                                                  //| 3, 94, 95, 96, 97, 98)
   xs.filter(x => myFilter(x,2))                  //> res7: scala.collection.immutable.IndexedSeq[Int] = Vector(11, 13, 15, 17, 19
                                                  //| , 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55, 57
                                                  //| , 59, 61, 63, 65, 67, 69, 71, 73, 75, 77, 79, 81, 83, 85, 87, 89, 91, 93, 95
                                                  //| , 97)

}