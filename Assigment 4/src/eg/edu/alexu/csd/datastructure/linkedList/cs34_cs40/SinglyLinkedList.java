package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

public class SinglyLinkedList implements ILinkedList {
	
	private int size;
	private SNode head;
	
	public SinglyLinkedList() {
		size=0;
		head= new SNode (null,null);
	}
	
	@Override
	public void add(int index, Object element) {
		SNode insert =  new SNode (element, null);
		SNode current=head;
		if(size==0) {
			head=insert;
			size++;
		}
		else if((index<size)&&(index>=0)) {
			for (int i=0 ; i< index-1; i++) {
				current=current.getNext();
			}
			if(index==0) {
				insert.setNext(head);
				head=insert;
				size++;
			}else {
				insert.setNext(current.getNext());
				current.setNext(insert);
				size++;
			}
		}
		else if (index==size) {
			while(current.getNext()!=null) {
				current=current.getNext();
			}
			current.setNext(insert);
			size++;
		}
	}

	@Override
	public void add(Object element) {
		SNode insert = new SNode (element, null);
		SNode current=head;
		if(size==0) {
			head=insert;
			size++;
		}
		else {
			while(current.getNext()!= null) {
				current=current.getNext();
			}
			current.setNext(insert);
			size++;
		}
	}

	@Override
	public Object get(int index) {
		if((size==0) || (index >= size) || (index<0)) {
			return null;
		}
		else {
			SNode current =  head;
			for(int i=0; i<index ; i++) {
				current=current.getNext();
			}
			return current.getValue();
		}
	}

	@Override
	public void set(int index, Object element) {
		SNode current=head;
		if(index==0 && size==0) {
			head.setValue(element);
			size++;
		}
		else if(index==0) {
			head.setValue(element);
		}
		else if((index<size)&&(index>=0) && size != 0) {
			for (int i=0 ; i< index; i++) {
				current=current.getNext();
			}
			current.setValue(element);
		}
	}

	@Override
	public void clear() {
		SNode current=head;
		if(size>0) {
			for(int i=0; i<size; i++) {
				current.setValue(null);
				current=current.getNext();
			}
			head.setValue(null);
			head.setNext(null);
			size=0;
		}
	}

	@Override
	public boolean isEmpty() {
		if(size==0){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void remove(int index) {
		SNode current=head;
		if(index==0 && size!=0) {
			head=head.getNext();
			size--;
		}
		else if((index<size)&&(index>=0)) {
			for (int i=0 ; i< index-1; i++) {
				current=current.getNext();
			}
			SNode remove = current.getNext();
			current.setNext(remove.getNext());
			remove.setNext(null);
			remove=null;
			size--;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if((fromIndex<size) &&(toIndex<size) && (fromIndex>=0) && (toIndex >=0)&& (size !=0) && (toIndex >= fromIndex)) {
			SinglyLinkedList subList = new SinglyLinkedList();
			SNode first = head;
			int point=0;
			for(int i=0; i<fromIndex;) {
				first=first.getNext();
				i++;
				point=i;
			}
			SNode last= new SNode(first.getValue(),null);
			subList.head=last;
			subList.size++;
			while(point<toIndex) {
				first=first.getNext();
				subList.add(first.getValue());
				point++;
			}
			subList.size=toIndex - fromIndex +1;
			return subList;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean contains(Object o) {
		if(size != 0) {
			SNode current = head;
			while((current.getValue() != o) && (current.getNext() != null)) {
				current=current.getNext();
			}
			if(current.getValue() == o) {
				return true;
			}
			else {
				return false;
			}
		}else {
			return false;
		}
	}

}
