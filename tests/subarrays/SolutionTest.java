package subarrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testCountSubArraysWithNegativeSum() {
		// Given
		int[] a = {1, -2, 4, -5, 1};
		
		// When
		int result = Solution.countSubArraysWithNegativeSum(a);
		
		// Then
		assertEquals(9, result);
	}

}
