package org.scala.tests


object Test4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  lazy val list1 = 10 to 20 toList                //> list1  : List[Int] = <lazy>
  val list2 = List(2,3,5,7)                       //> list2  : List[Int] = List(2, 3, 5, 7)

	list1.foreach(i => {if(list2.forall(j => i%j != 0)) println(i) })
                                                  //> 11
                                                  //| 13
                                                  //| 17
                                                  //| 19

val sizeOfDigit = 9                               //> sizeOfDigit  : Int = 9
val numbers = ((Math.pow(10, sizeOfDigit).toLong , (Math.pow(10, sizeOfDigit+1)-1).toLong))
                                                  //> numbers  : (Long, Long) = (1000000000,9999999999)
Math.pow(10,10).toLong                            //> res0: Long = 10000000000

	def f(arr:List[Int]):List[Int] = {
		def frecursive(result:List[Int],index:Int):List[Int] = {
			if(index > arr.length-1) result
			else frecursive( result ::: List(arr(index)),index+2)
		}
		
		frecursive(Nil,1)
	}                                         //> f: (arr: List[Int])List[Int]
	
	val list3 = List(8, 16, 8, 32 )           //> list3  : List[Int] = List(8, 16, 8, 32)
	
	val servers = List(8, 16, 8, 32)          //> servers  : List[Int] = List(8, 16, 8, 32)
	val sortBye = servers.sortBy(- _)         //> sortBye  : List[Int] = List(32, 16, 8, 8)
}