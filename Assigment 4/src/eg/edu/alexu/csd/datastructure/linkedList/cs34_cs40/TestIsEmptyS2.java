package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIsEmptyS2 {

	@Test
	public void test() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		
		boolean i = test.isEmpty();
		
		assertEquals(true, i);
	}

}
