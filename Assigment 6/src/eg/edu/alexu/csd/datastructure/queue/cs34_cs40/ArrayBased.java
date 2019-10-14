package eg.edu.alexu.csd.datastructure.queue.cs34_cs40;

public class ArrayBased implements IQueue, IArrayBased  {
	
	int n;
	Object [] queue;
	int f=0, r=0;
	int count=0;
	
	public ArrayBased(int size) {
		n = size;
		queue = new Object [n];
	}

	@Override
	public void enqueue(Object item) {
		if (count == n) {
			System.out.println("ERROR: Full queue");
			return;
		}
		else {
			if(r==n) {
				r=0;
				queue[r]=item;
				r=r+1;
				count++;
			}
			else {
				queue[r]=item;
				r=r+1;
				count++;
			}
		}
	}

	@Override
	public Object dequeue() {
		if(count==0) {
			return null;
		}
		else {
			if(f==n-1) {
				Object temp=queue[f];
				queue[f]=null;
				f=0;
				count--;
				return temp;
			}
			else {
				Object temp=queue[f];
				queue[f]=null;
				f=f+1;
				count--;
				return temp;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if(count==0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int size() {
		return count;
	}

}
