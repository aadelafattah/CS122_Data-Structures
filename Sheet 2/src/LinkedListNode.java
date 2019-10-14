public class LinkedListNode {
	
	int value;
	LinkedListNode next;
	
	public LinkedListNode (int v, LinkedListNode n){
		value = v;
		next = n;
	}
	public int getValue() {
		return value;
	}
	public LinkedListNode getNext() {
		return next;
	}
}