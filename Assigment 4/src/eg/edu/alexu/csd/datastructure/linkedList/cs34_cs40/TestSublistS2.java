package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSublistS2 {

	@Test
	public void test() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		
		ILinkedList sublist;
		
		sublist= test.sublist(0, 10);
		
		assertEquals(null, sublist);
	}

}
