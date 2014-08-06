package org.questions

/*
 * Write a method to return first five 10 digit prime numbers.
 */

object PrimeNumber extends App{
  def isPrime(number: Int): Boolean = {
    def isPrimeR(result: Boolean, currentNumber: Int,number: Int):Boolean = {
      if(number <= 3) true
      else if(currentNumber > Math.sqrt(number)) true
      else if(number % currentNumber == 0) false
      else isPrimeR(false,currentNumber + 2 , number)
    }
    isPrimeR(false, 3,number)
  }
  
  def getPrimeUsingSieveOfEratosthenes(noOfPrimesRequired: Int): List[Int] = {
    // range of numbers = 10 ^ noOfDigits to (10 ^ noOfDigits+1) -1
    val max = 100000
    val xs = 2 until max toList
    def myFilter(x: Int,y: Int):Boolean = {
		  if(x ==y) true
		  else if(x % y != 0) true
		  else false
	  }
    
    def primeR(result: List[Int],index: Int):List[Int] = {
      val lastPrimeNumber = result(index)
      if((lastPrimeNumber * lastPrimeNumber) > max ) result
      else primeR(result.filter(x => myFilter(x,lastPrimeNumber)), index+1)
    }
    
    primeR(xs,0)
  }
  
  println(getPrimeUsingSieveOfEratosthenes(1))
          
}