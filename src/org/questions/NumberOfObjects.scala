package org.questions
/*
 * http://www.javaranch.com/journal/200408/ScjpTipLine-javap.html
 * //Total number of objects created will be 1 // Constant ABC
 * 
 */

object NumberOfObjects {
  def testNumberOfObjects = {
    val temp = "A" + "B" + "C"
  }
}