public class MySpecialLinkedListUtils {
	
	/*problem 1*/
	public static double[] summary(LinkedListNode head){
		double info[]= {0,0,0,0,0};
		LinkedListNode start = head;
		/*info[0]is the sum, info[1] is max, info[2] is min, info[3] is average and info[4] is median*/
		int counter=0;
		if (head==null) {
			return info;
		}
		info[1]=head.getValue();
		info[2]=head.getValue();
		while(head!= null) {
			info[0]= info[0] + head.getValue();
			counter++;
			if (info[1] < head.getValue()){
				info[1]=head.getValue();
			}
			if (info[2] > head.getValue()) {
				info[2] = head.getValue();
			}
			head=head.getNext();
		}
		info[3]= info[0]/counter;
		if(counter%2 == 0) {
			counter=(counter/2) - 1;
			for(int i = 0; i< counter; i++) {
				start=start.getNext();
			}
			info[4]=info[4]+start.getValue();
			start = start.getNext();
			info[4]=info[4]+start.getValue();
			info[4]=info[4]/2.0;
		}
		else {
			counter=(counter/2);
			for(int i = 0; i< counter; i++) {
				start=start.getNext();
			}
			info[4]=info[4]+start.getValue();
		}
		return info;
	}
	
	/*problem 2*/
	public static LinkedListNode reverse (LinkedListNode head) {
		LinkedListNode before = null;
		LinkedListNode now = head;
		LinkedListNode after = null;
		while(now != null) {
			after=now.getNext();
			now.next = before;
			before= now;
			now = after;
		}
		head=before;
		return head;
	}
	
	/*problem 3*/
	public static LinkedListNode evenIndexedElements (LinkedListNode head) {
		LinkedListNode temp = head;
		LinkedListNode current = head;
		if (head.next==null) {
			return current;
		}
		else{
			while(head != null) {
				temp = temp.getNext().getNext();
				if (temp==null) {
					head.next=temp;
					return current;
				}
				else if(temp.next==null) {
					head.next=temp;
					head=head.getNext();
					head.next = temp.getNext();
					return current;
				}
				else if (temp.next != null) {
					head.next = temp;
					head = head.getNext();	
				}
			}
		}
		return current;
	}
	
	/*problem 4*/
	public static LinkedListNode insertionSort(LinkedListNode head) {
		if( head == null ){
			return head;
		}
		
		LinkedListNode helper = new LinkedListNode(0, null); 
		LinkedListNode current = head; 
		LinkedListNode previous = helper; 
		LinkedListNode next = null; 
		while( current != null ){
			next = current.next;
			while( previous.next != null && previous.next.value < current.value ){
				previous = previous.next;
			}
			current.next = previous.next;
			previous.next = current;
			previous = helper;
			current = next;
		}
		
		return helper.next;
	}
	
	/*problem 5*/
	public static LinkedListNode mergeSort(LinkedListNode head) {
		
	}
	
	/*problem 6*/
	public static LinkedListNode removeCentralNode(LinkedListNode head) {
		LinkedListNode start= head;
		LinkedListNode removed = start;
		LinkedListNode tail = start;
		int counter=0;
		if (tail==null) {
			return null;
		}
		else if (tail.next==null) {
			return null;
		}
		else if (tail.next.next==null) {
			return null;
		}
		else {
			while(head!=null) {
				counter++;
				head=head.getNext();
			}
			if(counter%2==0){
				counter=(counter/2)-2;
				for(int i=0; i<counter;i++) {
					tail=tail.getNext();
					start.next=tail;
					start=start.getNext();
				}
				tail=tail.getNext().getNext().getNext();
				start.next=tail;
			}else {
				counter=counter/2-1;
				for(int i=0; i<counter;i++) {
					tail=tail.getNext();
					start.next=tail;
					start=start.getNext();
				}
				tail=tail.getNext().getNext();
				start.next=tail;
				
			}
		}
		return removed;
	}
	
	/*problem 7*/
	/*making a copy of the original LinkedList*/
	public static LinkedListNode copyList(LinkedListNode head) {
		LinkedListNode current = head;
		LinkedListNode newList = null;
		LinkedListNode tail = null;
		
		while(current!=null) {
			if(newList==null) {
				newList = new LinkedListNode(current.getValue(), null);
				tail= newList;
			}
			else {
				tail.next=new LinkedListNode(0,null);
				tail = tail.getNext();
				tail.value=current.getValue();
				tail.next=null;
			}
			current=current.next;
		}
		return newList;
	}
	
	public static boolean palindrome(LinkedListNode head) {
		LinkedListNode normal = copyList(head);
		LinkedListNode reverse = reverse(head);
		while(normal != null) {
			if(normal.value==reverse.value) {
				normal=normal.getNext();
				reverse=reverse.getNext();
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}

