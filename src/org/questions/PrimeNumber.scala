package org.questions
import scala.math.BigInt
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
  
  def isPrime(number: Long,previousPrimes: List[Long]):Boolean = {
    var i = 0
    var result = true
    while(result && i < previousPrimes.size){
    	if(number != previousPrimes(i) && number % previousPrimes(i) ==0) {
    	  result = false
    	}
    	i+=1
    }
    result
  }
  
  def getAllPrimesUsingSieveOfEratosthenes(max: Long,ls: List[Long]): List[Long] = {
    // range of numbers = 10 ^ noOfDigits to (10 ^ noOfDigits+1) -1
    lazy val xs = 2L until max toList 
    
    def myFilter(x: Long,y: Long):Boolean = {
		  if(x ==y) true
		  else if(x % y != 0) true
		  else false
	}
    
    def primeR(result: List[Long],index: Int):List[Long] = {
      val lastPrimeNumber = result(index)
      if((lastPrimeNumber * lastPrimeNumber) > max || index == result.size -1) result
      else primeR(result.filter(x => myFilter(x,lastPrimeNumber)), index+1)
    }
    
    def primeRR(ls :List[Long],result: List[Long],index: Int):List[Long] = {
      val lastPrimeNumber = result(index)
      if((lastPrimeNumber * lastPrimeNumber) > max || index == result.size -1) result
      else primeR(ls.filter(x => myFilter(x,lastPrimeNumber)), index+1)
    }
    
    if(ls == Nil){
    	primeR(xs,0)  
    }else {
      primeR(ls,0)
    }
    
  }
  
 //square root of max digit + 1
  
  def calculatefirstNPrimeNumbersOfAGivenSize(n: Int, sizeOfDigit: Int){
    val firstIterationLimit = Math.sqrt(Math.pow(10, sizeOfDigit+1)).toLong
    println("firstIterationLimit " + firstIterationLimit)
    val primeListTillFirstIterationLimit = getAllPrimesUsingSieveOfEratosthenes(firstIterationLimit,Nil)
    println("primeListTillFirstIterationLimit " + primeListTillFirstIterationLimit.size)
    val tenDigitNumbers = ((Math.pow(10, sizeOfDigit).toLong , (Math.pow(10, sizeOfDigit+1)-1).toLong))
    getPrimeNumbers(tenDigitNumbers,primeListTillFirstIterationLimit,5)
    //val finalPrimeList = getAllPrimesUsingSieveOfEratosthenes((Math.pow(10, sizeOfDigit+1)-1).toLong,primeListTillFirstIterationLimit)
    //println(finalPrimeList)
  }
  
  def getPrimeNumbers(numbers: (Long,Long), previousPrimeNumbers: List[Long], countOfPrimesRequired: Int){
    //10000000000,99999999999
      var i = numbers._1
      var count = 0
      while(i < numbers._2 && count < countOfPrimesRequired){
        if(previousPrimeNumbers.forall(j => i%j != 0)) {println(" PRIME " + i); count+=1}
        i += 1
      }
  }
  
  calculatefirstNPrimeNumbersOfAGivenSize(5,12)
          
}
