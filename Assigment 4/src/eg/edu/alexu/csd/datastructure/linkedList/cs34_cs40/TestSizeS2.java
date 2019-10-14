package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSizeS2 {

	@Test
	public void test() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		
		int i = test.size();
		
		assertEquals(5, i);
	}

}
