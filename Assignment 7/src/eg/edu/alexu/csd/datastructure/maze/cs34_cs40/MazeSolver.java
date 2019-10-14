package eg.edu.alexu.csd.datastructure.maze.cs34_cs40;

import java.io.File;
import java.util.Scanner;

public class MazeSolver implements IMazeSolver {

	private class Node {
		
		private Object value;
		private Node next;
		
		private Node (Object v , Node n) {
			value = v;
			next = n;
		}
		
		private Object getValue() {
			return value;
		}
		
		private Node getNext() {
			return next;
		}
		
		private void setValue(Object v) {
			value= v;
		}
		
		private void setNext(Node n) {
			next = n;
		}
	}
	private class QueueLinkedBased{
		
		private int size;
		private Node head;
		private Node tail;
		
		private QueueLinkedBased() {
			size = 0;
		}

		private void enqueue(Object item) {
			Node node = new Node (item,null);
			if (isEmpty()) {
				head = node;
			}
			else {
				tail.setNext(node);
			}
			tail = node;
			size ++;
		}

		private Object dequeue(){
			if (isEmpty()) {
				return null;
			}
			else {
				Object temp = head.getValue();
				head = head.getNext();
				size --;
				if (isEmpty()) {
					tail = null;
				}
				return temp;
			}
		}
		private boolean isEmpty() {
			return (size == 0);
		}
		
		private int size() {
			return size;
		}
	}
	private class Stack {
		
		private Node top;
		private int size;
		
		private Stack() {
			top = null;
			size = 0;
		}
		
		private Object pop() {
			/**
			 * can't pop if it is empty
			 */
			if (isEmpty()) {
				return null;
			}
			else {
				Object result = top.getValue();
				top = top.getNext();
				size--;
				return result;
			}
		}

		
		private Object peek(){
			/**
			 * empty stack has no peek
			 */
			if (isEmpty()) {
				return null;
			}
			else {
				return top.getValue();
			}
		}

		
		private void push(Object element) {
			Node input = new Node(element, top);
			top = input;
			size++;
		}

		
		private boolean isEmpty() {
			if (size == 0) {
				return true;
			}
			else {
				return false;
			}
		}

		
		private int size() {
			return size;
		}

	}

	
	@Override
	public int[][] solveBFS(File maze) {
		Scanner scan;
		try {
			scan = new Scanner (maze);
		}
		catch(Exception e) {
			return null;
		}
		int row = scan.nextInt();
		int column = scan.nextInt();
		String [] prototype = new String[row];
		for(int i=0; i<row; i++) {
			prototype[i]=scan.next();
		}
		scan.close();
		
		char[][] ogMaze = new char[row][column];
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<column ; j++) {
				ogMaze[i][j]=prototype[i].charAt(j);
			}
		}
		char[][] tempMaze = new char [row][column];
		tempMaze = ogMaze;
		
		
		QueueLinkedBased S = new QueueLinkedBased();
		int T[]=new int[2];
		int E[]=new int[2];
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<column ; j++) {
				if(ogMaze[i][j]=='S') {
					T[0]=i;
					T[1]=j;
				}
				if(ogMaze[i][j]=='E') {
					E[0]=i;
					E[1]=j;
				}
			}
		}
		int N[]= new int [2];
		int [][] tempArr = new int [row*column][2];
		int k=0;
		S.enqueue (new int [] {T[0],T[1]});
		tempMaze[T[0]][T[1]]='x';
		int flag=0;
		while(S.size!=0){
			T=(int[]) S.dequeue();
			flag=0;
			for(int i=-1; i<2; i=i+2) {
				if(T[0]+i<0 || T[0]+i>=row) {
					continue;
				}
				else {
					if(tempMaze[T[0]+i][T[1]] == '.') {
						N[0]=(T[0]+i);
						N[1]=(T[1]);
						tempMaze[N[0]][N[1]]='x';
						S.enqueue(new int [] {N[0],N[1]});
						flag=1;
					}
					else if((T[0]+i)==E[0]&&(T[1])==E[1]) {
						S.size=0;
						tempArr[k]=T;
						k++;
						tempArr[k]=E;
						k++;
						flag=-1;
						break;
					}
				}
			}
			if(flag==-1) {
				break;
			}
			for(int i=-1; i<2; i=i+2) {
				if((T[1]+i)<0 || (T[1]+i)>=column){
					continue;
				}
				else {
					if(tempMaze[T[0]][T[1]+i] == '.') {
						N[0]=(T[0]);
						N[1]=(T[1]+i);
						tempMaze[N[0]][N[1]]='x';
						S.enqueue(new int [] {N[0],N[1]});
						flag=1;
					}
					else if(T[0]==E[0]&&(T[1]+i)==E[1]) {
						S.size=0;
						tempArr[k]=T;
						k++;
						tempArr[k]=E;
						k++;
						flag=-1;
						break;
					}
				}
			}
			if(flag==-1) {
				break;
			}
			if(flag==1) {
				tempArr[k]=T;
				k++;
			}
		}
		for(int i=k-1; i>0; i--) {
			if((Math.abs(tempArr[i][0]-tempArr[i-1][0])==1) && (tempArr[i][1]==tempArr[i-1][1])) {
				continue;
			}
			else if((Math.abs(tempArr[i][1]-tempArr[i-1][1])==1) && (tempArr[i][0]==tempArr[i-1][0])) {
				continue;
			}
			else {
				for(int v=i-1; v<k-1; v++) {
					tempArr[v]=tempArr[v+1];
				}
				i++;
				k--;
			}
		}
		int [][] Final = new int [k][2];
		for(int i = 0; i<k; i++) {
			Final[i]=tempArr[i];
		}
		return Final;
	}

	@Override
	public int[][] solveDFS(File maze) {
		return null;
	}
	
	public static void main (String[] args) {
		MazeSolver test =  new MazeSolver();
		File maze1 = new File("C:\\Users\\Adel\\Desktop\\maze1.txt");
		File maze2 = new File("C:\\Users\\Adel\\Desktop\\maze2.txt");
		File maze3 = new File("C:\\Users\\Adel\\Desktop\\maze3.txt");
		File maze4 = new File("C:\\Users\\Adel\\Desktop\\maze4.txt");
		File maze5 = new File("C:\\Users\\Adel\\Desktop\\maze5.txt");
		File maze6 = new File("C:\\Users\\Adel\\Desktop\\maze6.txt");
		File maze7 = new File("C:\\Users\\Adel\\Desktop\\maze7.txt");
		File maze8 = new File("C:\\Users\\Adel\\Desktop\\maze8.txt");
		System.out.println(test.solveBFS(maze1));
		System.out.println(test.solveBFS(maze2));
		System.out.println(test.solveBFS(maze3));
		System.out.println(test.solveBFS(maze4));
		System.out.println(test.solveBFS(maze5));
		System.out.println(test.solveBFS(maze6));
		System.out.println(test.solveBFS(maze7));
		System.out.println(test.solveBFS(maze8));
	}

}
