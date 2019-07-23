package palindrome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testIsPalindromeTrueImpar() {
		// Given
		String word = "madam";
		
		// WHen
		String result = Solution.isPalindrome(word);
		
		// Then
		assertEquals("Yes", result);
	}
	
	@Test
	void testIsPalindromeTruePar() {
		// Given
		String word = "ommo";
		
		// WHen
		String result = Solution.isPalindrome(word);
		
		// Then
		assertEquals("Yes", result);
	}
	
	@Test
	void testIsPalindromeFalse() {
		// Given
		String word = "madame";
		
		// WHen
		String result = Solution.isPalindrome(word);
		
		// Then
		assertEquals("No", result);
	}

}
