package varargs_simple_addition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddTest {

	@Test
	void test_add_two() {
		//Given
		Add ob = new Add();
		
		//When
		String result = ob.add(1, 2);
		
		//Then
		assertEquals("1+2=3", result);
		
	}
	
	@Test
	void test_add_three() {
		//Given
		Add ob = new Add();
		
		//When
		String result = ob.add(1, 2, 3);
		
		//Then
		assertEquals("1+2+3=6", result);
		
	}
	
	@Test
	void test_add_four() {
		//Given
		Add ob = new Add();
		
		//When
		String result = ob.add(1, 2, 3, 4);
		
		//Then
		assertEquals("1+2+3+4=10", result);
		
	}
	
	@Test
	void test_add_five() {
		//Given
		Add ob = new Add();
		
		//When
		String result = ob.add(1, 2, 3, 4, 5);
		
		//Then
		assertEquals("1+2+3+4+5=15", result);
		
	}

}
