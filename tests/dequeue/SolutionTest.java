package dequeue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

	Deque<Integer> deque;
	Map<Integer, Integer> map;
	int m;
	
	@BeforeEach
	void setUp() {
		deque = new ArrayDeque<>();
		map = new HashMap<>();
		m = 3;
	}
	
	@Test
	void testRemoveOldWhenEmpty() {
		//Given
		
		
		//When
		Solution.removeOld(deque, map, m);
		
		//Then
		assertTrue(deque.isEmpty());
		assertTrue(map.isEmpty());
	}
	
	@Test
	void testRemoveOldWhenNotFull() {
		//Given	
		deque.add(1);
		map.put(1, 1);
		
		//When
		Solution.removeOld(deque, map, m);
		
		//Then
		assertTrue(deque.size() == 1);
		assertFalse(map.isEmpty());
	}
	
	@Test
	void testRemoveOldWhenFullAndOldIsUnique() {
		//Given
		deque.add(1);
		map.put(1, 1);
		
		deque.add(2);
		map.put(2, 1);
		
		deque.add(3);
		map.put(3, 1);
		
		//When
		Solution.removeOld(deque, map, m);
		
		//Then
		assertTrue(deque.size() == 2);
		assertFalse(deque.contains(1));
		assertFalse(map.containsKey(1));
	}
	
	@Test
	void testRemoveOldWhenFullAndOldIsNotUnique() {
		//Given
		deque.add(1);
		map.put(1, 1);
		
		deque.add(2);
		map.put(2, 1);
		
		deque.add(1);
		map.put(1, 2);
		
		//When
		Solution.removeOld(deque, map, m);
		
		//Then
		assertTrue(deque.size() == 2);
		assertTrue(deque.contains(1));
		assertTrue(map.containsKey(1));
		assertEquals(1, (int) map.get(1));
	}

	@Test
	void testAddNewWhenEmpty() {
		//Given
		
		
		//When
		Solution.addNew(deque, map, 10);
		
		//Then
		assertEquals(1, (int) map.get(10));
		assertEquals(1, deque.size());
		assertTrue(deque.contains(10));
		 
	}
	
	@Test
	void testAddNewWhenRepeating() {
		//Given
		
		
		//When
		Solution.addNew(deque, map, 10);
		Solution.addNew(deque, map, 10);
		
		//Then
		assertEquals(2, (int) map.get(10));
		assertEquals(2, deque.size());
		assertTrue(deque.contains(10));
		 
	}
	
	@Test
	void testAddNewWhenNotRepeating() {
		//Given
		
		
		//When
		Solution.addNew(deque, map, 10);
		Solution.addNew(deque, map, 20);
		
		//Then
		assertEquals(1, (int) map.get(10));
		assertEquals(1, (int) map.get(20));
		assertEquals(2, deque.size());
		assertTrue(deque.contains(10));
		assertTrue(deque.contains(20));
		 
	}
	
}
