package array_2d;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testMaxHourglassLength() {
		// Given
		int[][] arr = {
				{1,1,1,0,0,0},
				{0,1,0,0,0,0},
				{1,1,1,0,0,0},
				{0,0,2,4,4,0},
				{0,0,0,2,0,0},
				{0,0,1,2,4,0}
				};
		
		// When
		int result = Solution.maxHourglassLength(arr);
		
		// Then
		assertEquals(19, result);
	}
	
	@Test
	void testHourglassSumSecondQuadrant() {
		// Given
		int[][] arr = {
				{1,1,1,0,0,0},
				{0,1,0,0,0,0},
				{1,1,1,0,0,0},
				{0,0,2,4,4,0},
				{0,0,0,2,0,0},
				{0,0,1,2,4,0}
				};
		
		// When
		int result = Solution.hourglassSum(arr, 0, 0);
		
		// Then
		assertEquals(7, result);
	}
	
	@Test
	void testHourglassSumFirstQuadrant() {
		// Given
		int[][] arr = {
				{1,1,1,0,0,0},
				{0,1,0,0,0,0},
				{1,1,1,0,0,0},
				{0,0,2,4,4,0},
				{0,0,0,2,0,0},
				{0,0,1,2,4,0}
				};
		
		// When
		int result = Solution.hourglassSum(arr, 0, 3);
		
		// Then
		assertEquals(0, result);
	}
	
	@Test
	void testHourglassSumThirdQuadrant() {
		// Given
		int[][] arr = {
				{1,1,1,0,0,0},
				{0,1,0,0,0,0},
				{1,1,1,0,0,0},
				{0,0,2,4,4,0},
				{0,0,0,2,0,0},
				{0,0,1,2,4,0}
				};
		
		// When
		int result = Solution.hourglassSum(arr, 3, 3);
		
		// Then
		assertEquals(14, result);
	}

	
	@Test
	void testHourglassSumMax() {
		// Given
		int[][] arr = {
				{1,1,1,0,0,0},
				{0,1,0,0,0,0},
				{1,1,1,0,0,0},
				{0,0,2,4,4,0},
				{0,0,0,2,0,0},
				{0,0,1,2,4,0}
				};
		
		// When
		int result = Solution.hourglassSum(arr, 3, 2);
		
		// Then
		assertEquals(19, result);
	}
}
