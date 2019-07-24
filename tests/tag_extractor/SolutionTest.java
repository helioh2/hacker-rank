package tag_extractor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testExtractFromTagOneTag() {
		//Given
		String line = "<h1>Nayeem loves counseling</h1>";
		
		//When
		List<String> result = Solution.extractFromTag(line);
		
		//Then
		assertTrue(result.contains("Nayeem loves counseling"));
	}
	
	@Test
	void testExtractFromTagTwoTags() {
		//Given
		String line = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
		
		//When
		List<String> result = Solution.extractFromTag(line);
		
		//Then
		assertTrue(result.contains("Sanjay has no watch"));
		assertTrue(result.contains("So wait for a while"));
	}
	
	@Test
	void testExtractFromTagDifferentTags() {
		//Given
		String line = "<Amee>safat codes like a ninja</amee>";
		
		//When
		List<String> result = Solution.extractFromTag(line);
		
		//Then
		assertTrue(result.contains("None"));
		assertTrue(result.size() == 1);
	}

}
