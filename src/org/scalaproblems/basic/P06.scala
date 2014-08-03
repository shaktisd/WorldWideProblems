package org.scalaproblems.basic


class P06 {
	def isPalindrome(xs: List[Int]): Boolean = {
		xs == xs.reverse
	}
}