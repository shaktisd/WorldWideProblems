package org.questions

object FirstNthPrimeNumbers extends App{
  def calculatefirstNPrimeNumbersOfAGivenNumberOfDigits(numberOffirstNPrimes: Int, numberOfDigits: Int){
    // for 10 digits find square root of first 10+1 digit number 
    val upperBound = Math.sqrt(Math.pow(10, numberOfDigits+1)).toLong
    // get all primes till square root of first 10+1 digit number
    val previousPrimes = getPrimesUsingSieveOfEratosthenes(upperBound)
    val numbersRange = ((Math.pow(10, numberOfDigits).toLong , (Math.pow(10, numberOfDigits+1)-1).toLong))
    calculatePrimeNumbersInARangeUsingPreviousPrimes(numbersRange,previousPrimes,numberOffirstNPrimes)
  }
  
   def calculatePrimeNumbersInARangeUsingPreviousPrimes(numbers: (Long,Long), previousPrimeNumbers: List[Long], countOfPrimesRequired: Int){
      var i = numbers._1
      var count = 0
      while(i < numbers._2 && count < countOfPrimesRequired){
        if(previousPrimeNumbers.forall(j => i%j != 0)) {println(" PRIME " + i); count+=1}
        i += 1
      }
  }
  
  def getPrimesUsingSieveOfEratosthenes(upperBound: Long): List[Long] = {
    lazy val xs = 2L until upperBound toList 
    def myFilter(x: Long,y: Long):Boolean = {
		  if(x ==y) true
		  else if(x % y != 0) true
		  else false
	  }
    
    def primeR(result: List[Long],index: Int):List[Long] = {
      val lastPrimeNumber = result(index)
      if((lastPrimeNumber * lastPrimeNumber) > upperBound || index == result.size -1) result
      else primeR(result.filter(x => myFilter(x,lastPrimeNumber)), index+1)
    }
    	primeR(xs,0)  
  }
  
  calculatefirstNPrimeNumbersOfAGivenNumberOfDigits(5,10)
}