package array_1d_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testCanWinWhenCleanGame() {
		//Given
		int[] game = {0, 0, 0, 0, 0};
		int leap = 3;
		
		//WHen
		boolean result = Solution.canWin(leap, game);
		
		//Then
		assertTrue(result);
	}
	
	@Test
	void testCanWinWhenNotCleanGame() {
		//Given
		int[] game = {0, 0, 0, 1, 1, 1};
		int leap = 5;
		
		//WHen
		boolean result = Solution.canWin(leap, game);
		
		//Then
		assertTrue(result);
	}
	
	@Test
	void testCanNotWin1() {
		//Given
		int[] game = {0, 0, 1, 1, 1, 0};
		int leap = 3;
		
		//WHen
		boolean result = Solution.canWin(leap, game);
		
		//Then
		assertFalse(result);
	}
	
	@Test
	void testCanNotWin2() {
		//Given
		int[] game = {0, 1, 0};
		int leap = 1;
		
		//WHen
		boolean result = Solution.canWin(leap, game);
		
		//Then
		assertFalse(result);
	}
	
	@Test
	void testCanReachEndWhenCleanGameFromZero() {
		//Given
		int[] game = {0, 0, 0, 0, 0};
		int leap = 3;
		
		//WHen
		boolean result = Solution.canReachEnd(leap, game, 0);
		
		//Then
		assertTrue(result);
	}
	
	@Test
	void testCanReachEnd() {
		//Given
		int[] game = {0, 0, 0, 1, 1, 1};
		int leap = 5;
		
		//WHen
		boolean result = Solution.canReachEnd(leap, game, 0);
		
		//Then
		assertTrue(result);
	}

	
	@Test
	void testCanNotReachEndFromOne() {
		//Given
		int[] game = {0, 0, 1, 1, 1, 0};
		int leap = 3;
		
		//WHen
		boolean result = Solution.canReachEnd(leap, game, 0);
		
		//Then
		assertFalse(result);
	}
	
	@Test
	void testCanReachEnd1() {
		//Given
		int[] game = {0, 0, 1, 1, 0, 0, 1, 1, 0, 0};
		int leap = 3;
		
		//WHen
		boolean result = Solution.canReachEnd(leap, game, 0);
		
		//Then
		assertTrue(result);
	}
	
	@Test
	void testCanReachEnd2() {
		//Given
		int[] game = {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0};
		int leap = 19;
		
		//WHen
		boolean result = Solution.canReachEnd(leap, game, 0);
		
		//Then
		assertTrue(result);
	}
	
	@Test
	void testCanReachEndWhenHasToGoBackward() {
		//Given
		int[] game = {0, 1, 1, 0, 0, 1, 1, 0, 1};
		int leap = 4;
		
		//WHen
		boolean result = Solution.canReachEnd(leap, game, 0);
		
		//Then
		assertTrue(result);
	}
	
	
}
