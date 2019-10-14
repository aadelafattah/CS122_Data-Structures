package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGetS1 {

	@Test
	public void test() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		
		Object i= test.get(0);
		
		assertEquals(null, i);
		
	}
}
