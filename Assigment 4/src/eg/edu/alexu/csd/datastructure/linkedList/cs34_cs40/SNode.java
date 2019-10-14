package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

public class SNode {
	
	private Object value;
	private SNode next;
	
	public SNode (Object v, SNode n) {
		value= v;
		next = n;
	}
	public Object getValue() {
		return value;
	}
	public SNode getNext() {
		return next;
	}
	public void setValue(Object v) {
		value= v;
	}
	public void setNext(SNode n) {
		next = n;
	}
}
