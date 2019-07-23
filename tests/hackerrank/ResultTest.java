package hackerrank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import datetime.Result;

class ResultTest {

	@Test
	void testFindDay() {
		// Given
		int month = 7;
		int day = 23;
		int year = 2019;
		
		// When
		String result = Result.findDay(month, day, year);
		
		// Then
		assertEquals("TUESDAY", result);
	}

}
