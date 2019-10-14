package eg.edu.alexu.csd.datastructure.stack.cs40;

import java.util.Scanner;

public class UI {

	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		Stack stack = new Stack();
		while(true){
			System.out.println("Please choose an action :");
			System.out.println("--------------------------");
			System.out.println("1- Push");
			System.out.println("2- Pop");
			System.out.println("3- Peek");
			System.out.println("4- Get size");
			System.out.println("5- Check if Empty");
			System.out.println("============================");
			int input;
			input = scan.nextInt();
			if(input == 1) {
				Object push;
				System.out.println("Enter your element:");
				push =  scan.next();
				stack.push(push);
			}
			else if (input == 2) {
				System.out.println("You just popped: " + stack.pop());
			}
			else if (input == 3) {
				System.out.println("You just peeked: " + stack.peek());
			}
			else if (input == 4) {
				System.out.println("Size = " + stack.size());
			}
			else if (input == 5) {
				System.out.println(stack.isEmpty());
			}
		}
	}
	
}
