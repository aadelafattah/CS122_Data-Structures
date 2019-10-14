package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSizeS3 {

	@Test
	public void test() {
		SinglyLinkedList test = new SinglyLinkedList(); 
		
		int i = test.size();
		
		assertEquals(0, i);
	}

}
