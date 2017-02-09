/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.remove(0));
		assertEquals("Check second", "B", shortList.remove(0));
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
		
		}
		
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			//longerList.set(i, LONG_LIST_LENGTH - i);
			assertEquals("Check "+i+ " element", (Integer)i, longerList.remove(0));
		}
		
		// test off the end of the longer array
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			longerList.remove(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
			
		}
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.add(null);
			fail("Check null to be added");
		}catch (NullPointerException e) {
			
		}
		
		emptyList.add(0);
		assertEquals("Check first", (Integer)0, emptyList.get(0));
		
		// test short list, first contents, then out of bounds
		shortList.add("C");
		assertEquals("Check first", "C", shortList.get(shortList.size() - 1));
		
		// test longer list contents
		// test off the end of the longer array
		try {
			longerList.add(null);
			fail("Check null to be added");
		}catch (NullPointerException e) {
			
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("TestSize: check size is correct ", 0, emptyList.size());
		assertEquals("TestSize: check size is correct ", LONG_LIST_LENGTH, longerList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.add(0, null);
			fail("Check null to be added");
		}catch (NullPointerException e) {
			
		}
		
		emptyList.add(0, 0);
		assertEquals("Check first", (Integer)0, emptyList.get(0));
		
		// test short list, first contents, then out of bounds
		shortList.add(2, "C");
		assertEquals("Check first", "C", shortList.get(shortList.size() - 1));
		
		// test longer list contents
		// test off the end of the longer array
		try {
			longerList.add(-1, LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			longerList.add(longerList.size() + 1, LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.set(0, 1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		shortList.set(0, "C");
		shortList.set(1, "D");
		assertEquals("Check first", "C", shortList.get(0));
		assertEquals("Check second", "D", shortList.get(1));
		
		try {
			shortList.set(-1, "X");
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.set(2, "X");
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
		
		}
		
		try
		{
			shortList.set(0, null);
			fail("Check null to be set");
		}catch(NullPointerException n)
		{
			
		}
		
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			longerList.set(i, LONG_LIST_LENGTH - i);
			assertEquals("Check "+i+ " element", (Integer)(LONG_LIST_LENGTH - i), longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.set(-1, 99);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			longerList.set(LONG_LIST_LENGTH, 99);
			fail("Check out of bounds");
		}catch (IndexOutOfBoundsException e) {
			
		}
		
		try{
			longerList.set(LONG_LIST_LENGTH/2, null);
			fail("Check null to be set");
		}catch(NullPointerException n){
			
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
