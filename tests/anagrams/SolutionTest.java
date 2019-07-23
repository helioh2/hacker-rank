package anagrams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testIsAnagramTrue() {
		//Given
		String a = "anagram";
		String b = "margana";
		
		//When
		Boolean result = Solution.isAnagram(a, b);
		
		//Then
		assertTrue(result);
		
	}
	
	@Test
	void testIsAnagramFalse() {
		//Given
		String a = "anagramm";
		String b = "marganaa";
		
		//When
		Boolean result = Solution.isAnagram(a, b);
		
		//Then
		assertFalse(result);
		
	}
	
	@Test
	void testIsAnagramTrueWhenCaseDifferent() {
		//Given
		String a = "Hello";
		String b = "hello";
		
		//When
		Boolean result = Solution.isAnagram(a, b);
		
		//Then
		assertTrue(result);
		
	}

}
