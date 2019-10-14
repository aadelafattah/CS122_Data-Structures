package eg.edu.alexu.csd.datastructure.queue.cs34_cs40;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test1() {
		ArrayBased Que = new ArrayBased(10);
		assertEquals(true, Que.isEmpty());
	}
	
	@org.junit.Test
	public void test2() {
		ArrayBased Que = new ArrayBased(10);
		Que.enqueue(1);
		Que.enqueue(2);
		Que.enqueue(3);
		Que.enqueue(4);
		Que.enqueue(5);
		Que.enqueue(6);
		Que.enqueue(7);
		Que.enqueue(8);
		Que.enqueue(9);
		Que.enqueue(10);
		assertEquals(1, (int)Que.dequeue());
		assertEquals(2, (int)Que.dequeue());
		assertEquals(3, (int)Que.dequeue());
		assertEquals(4, (int)Que.dequeue());
		assertEquals(5, (int)Que.dequeue());
		assertEquals(6, (int)Que.dequeue());
		assertEquals(7, (int)Que.dequeue());
		assertEquals(8, (int)Que.dequeue());
		assertEquals(9, (int)Que.dequeue());
		assertEquals(10, (int)Que.dequeue());
		assertEquals(true, Que.isEmpty());
	}
	
	@org.junit.Test
	public void test3() {
		ArrayBased Que = new ArrayBased(3);
		Que.enqueue(1);
		Que.enqueue(2);
		Que.enqueue(3);
		Que.dequeue();
		Que.dequeue();
		Que.dequeue();
		Que.enqueue(4);
		Que.enqueue(5);
		assertEquals(4, (int)Que.dequeue());
	}

}
