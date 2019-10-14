package eg.edu.alexu.csd.datastructure.stack.cs40;

public class Stack implements IStack {
	
	public class Node{
		private Object value;
		private Node next;
		
		public Node (Object v, Node n) {
			value = v;
			next = n;
		}
		public Object getValue() {
			return value;
		}
		public Node getNext() {
			return next;
		}
		public void setValue(Object v) {
			value=v;
		}
		public void setNext(Node n) {
			next=n;
		}
	}
	
	private int size;
	private Node head;
	
	public Stack() {
		size=0;
		head=new Node(null,null);
	}
	
	@Override
	public Object pop() {
		if(size == 0) {
			return null;
		}
		else {
			Node current = head;
			head=head.getNext();
			size--;
			return current.getValue();
		}
	}

	@Override
	public Object peek() {
		if(size==0) {
			return null;
		}
		else {
			return head.getValue();
		}
	}

	@Override
	public void push(Object element) {
		Node current = new Node (element, null);
		current.setNext(head);
		head = current;
		size++;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

}
