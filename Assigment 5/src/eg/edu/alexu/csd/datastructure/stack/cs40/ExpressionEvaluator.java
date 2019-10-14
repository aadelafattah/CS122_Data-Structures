package eg.edu.alexu.csd.datastructure.stack.cs40;

public class ExpressionEvaluator implements IExpressionEvaluator {
	
	@Override
	public String infixToPostfix(String expression) {
		Stack stack = new Stack ();
		int k = 0;
		char temp[] = new char [expression.length()*2];
		for(int i = 0; i<expression.length() ; i++) {
			if(expression.charAt(i)=='(') {
				stack.push(expression.charAt(i));
				i++;
				if(expression.charAt(i)!=')' && expression.charAt(i)!='+' && expression.charAt(i)!='-' && expression.charAt(i)!='/' && expression.charAt(i)!='*' && expression.charAt(i)!=' ') {
					temp[k]=expression.charAt(i);
					k++;
					temp[k]=' ';
					k++;
				}
				else if(expression.charAt(i)=='*' || expression.charAt(i)=='/') {
					if(stack.size()==0) {
						stack.push(expression.charAt(i));
					}
					else if((char) stack.peek()=='/' ||(char)stack.peek()=='*') {
						temp[k]=(char) stack.pop();
						k++;
						temp[k]=' ';
						k++;
						stack.push(expression.charAt(i));
					}
					else {
						stack.push(expression.charAt(i));
					}
				}
				else if(expression.charAt(i)=='+' || expression.charAt(i)=='-') {
					if(stack.size()==0) {
						stack.push(expression.charAt(i));
					}
					else if((char) stack.peek()=='/' ||(char)stack.peek()=='*') {
						temp[k]=(char) stack.pop();
						k++;
						temp[k]=' ';
						k++;
						stack.push(expression.charAt(i));
					}
					else if((char) stack.peek()=='+' ||(char)stack.peek()=='-') {
						temp[k]=(char) stack.pop();
						k++;
						temp[k]=' ';
						k++;
						stack.push(expression.charAt(i));
					}
					else {
						stack.push(expression.charAt(i));
					}
				}
				else if(expression.charAt(i)==')') {
					while((char) stack.peek()!='(') {
						temp[k]=(char) stack.pop();
						k++;
						temp[k]=' ';
						k++;
					}
					stack.pop();
				}
			}
			else {
				if(expression.charAt(i)!=')' && expression.charAt(i)!='+' && expression.charAt(i)!='-' && expression.charAt(i)!='/' && expression.charAt(i)!='*' && expression.charAt(i)!=' ') {
					temp[k]=expression.charAt(i);
					k++;
					temp[k]=' ';
					k++;
				}
				else if(expression.charAt(i)=='*' || expression.charAt(i)=='/') {
					if(stack.size()==0) {
						stack.push(expression.charAt(i));
					}
					else if((char) stack.peek()=='/' ||(char)stack.peek()=='*') {
						temp[k]=(char) stack.pop();
						k++;
						temp[k]=' ';
						k++;
						stack.push(expression.charAt(i));
					}
					else {
						stack.push(expression.charAt(i));
					}
				}
				else if(expression.charAt(i)=='+' || expression.charAt(i)=='-') {
					if(stack.size()==0) {
						stack.push(expression.charAt(i));
					}
					else if((char) stack.peek()=='/' ||(char)stack.peek()=='*') {
						temp[k]=(char) stack.pop();
						k++;
						temp[k]=' ';
						k++;
						stack.push(expression.charAt(i));
					}
					else if((char) stack.peek()=='+' ||(char)stack.peek()=='-') {
						temp[k]=(char) stack.pop();
						k++;
						temp[k]=' ';
						k++;
						stack.push(expression.charAt(i));
					}
					else {
						stack.push(expression.charAt(i));
					}
				}
				else if(expression.charAt(i)==')') {
					while((char) stack.peek()!='(') {
						temp[k]=(char) stack.pop();
						k++;
						temp[k]=' ';
						k++;
					}
					stack.pop();
				}
			}
		}
		while(stack.size()!=0) {
			temp[k]=(char) stack.pop();
			k++;
			temp[k]=' ';
			k++;
		}
		String result = new String(temp);
		return result;
	}

	@Override
	public int evaluate(String expression) {
		Stack stack =  new Stack();
		int temp1=0, temp2=0;
		int result=0;
		for(int i=0; i<expression.length();i++) {
			if(expression.charAt(i)>='0' && expression.charAt(i)<='9') {
				stack.push(Character.getNumericValue(expression.charAt(i)));
			}
			else if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='/' || expression.charAt(i)=='*') {
				if(expression.charAt(i)=='+') {
					temp2=(int)stack.pop();
					temp1=(int)stack.pop();
					stack.push((temp1+temp2));
				}
				else if(expression.charAt(i)=='-') {
					temp2=(int)stack.pop();
					temp1=(int)stack.pop();
					stack.push((temp1-temp2));
				}
				else if(expression.charAt(i)=='*') {
					temp2=(int)stack.pop();
					temp1=(int)stack.pop();
					stack.push((temp1*temp2));
				}
				else if(expression.charAt(i)=='/') {
					temp2=(int)stack.pop();
					temp1=(int)stack.pop();
					stack.push((temp1/temp2));
				}
			}
		}
		result=(int)stack.pop();
		return result;
	}
	
	public static void main(String[] args) {
		String s = "6 2 / 3 - 4 2 * +";
		ExpressionEvaluator X = new ExpressionEvaluator();
		int i = X.evaluate(s);
		System.out.print(i);
	}
}
