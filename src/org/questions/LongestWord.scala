package org.questions
/*
 * Find the longest words in a given list of words that can be constructed from a given list of letters. 
Your solution should take as its first argument the name of a plain text file that contains one word per line. 
The remaining arguments define the list of legal letters. A letter may not appear in any single word more times 
than it appears in the list of letters (e.g., the input letters ‘a a b c k’ can make ‘back’ and ‘cab’ but not ‘abba’). 

Here's an example of how it should work: 

prompt> word-maker WORD.LST w g d a s x z c y t e i o b 
['azotised', 'bawdiest', 'dystocia', 'geotaxis', 'iceboats', 'oxidates', 'oxyacids', 'sweatbox', 'tideways'] 


Tip: Just return the longest words which match, not all.
 */

object LongestWord {
  val words = List("azotised", "bawdiest", "dystocia", "geotaxis", "iceboats", "oxidates", "oxyacids", "sweatbox", "tideways", "wgda", "wgdaasxzcyteiob") 
	val letters = "wgdasxzcyteiob".toList
	
	words.groupBy(_.size)
}