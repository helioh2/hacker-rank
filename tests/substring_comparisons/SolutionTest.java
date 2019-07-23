package substring_comparisons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testGetSmallestAndLargest() {
		// Given
		String s = "welcometojava";
		int k = 3;
		
		// When
		String result = Solution.getSmallestAndLargest(s, k);
		
		// Then
		assertEquals("ava\n" + "wel", result);
			
	}

}
