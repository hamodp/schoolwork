import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/***************************************************************************
 * tests if the methods from the MySet work
 * 
 * @author Patrick
 *
 */

public class MySetTest {

	MySet<String>  set1, set2;
	
	
	@Before
	public void setUp() throws Exception {
		set1 =new MySet<String>();
		set2 = new MySet<String>();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMySet() {
		assertEquals(0, set1.card());
	}

	@Test
	public void testContainsElement() {
		
	}

	@Test
	public void testIsEmpty() {
		assertTrue(set1.isEmpty());
	}

	@Test
	public void testRemoveFromSet() {
		set1.addToSet("test1");
		assertEquals(1, set1.card());
		set1.removeFromSet("test2");
		assertEquals(1, set1.card());
		set1.removeFromSet("test1");
		assertEquals(0, set1.card());
	}

	@Test
	public void testContainsSet() {
		set1.addToSet("test1");
		set2.addToSet("test1");
		assertTrue(set1.containsSet(set2));
	}

	@Test
	public void testEqualsMySetOfT() {
		set1.addToSet("test1");
		set2.addToSet("test1");
		assertTrue(set1.equals(set2));
		assertTrue(set2.equals(set1));
	}

	@Test
	public void testIsContainedIn() {
		set1.addToSet("test1");
		set2.addToSet("test1");
		assertTrue(set1.isContainedIn(set2));
	}

	@Test
	public void testAddToSet() {
		set1.addToSet("test1");
		assertEquals(1, set1.card());
		set1.addToSet("test1");
		assertEquals(1, set1.card());
	}

}
