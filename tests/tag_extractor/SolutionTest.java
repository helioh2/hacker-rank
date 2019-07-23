package tag_extractor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testExtractFromTag() {
		//Given
		String line = "<h1>Nayeem loves counseling</h1>";
		
		//When
		String result = Solution.extractFromTag(line);
		
		//Then
		assertEquals("Nayeem loves counseling", result);
	}

}
