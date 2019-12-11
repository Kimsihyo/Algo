package stack;

public class stack1 {
	
	public static int[] stack = new int[100];
	public static int top=-1;
	
	public static boolean push(int value) {
		if(top>=stack.length)return false;
		stack[++top]=value;
		return true; 
		
	}
	
	public static int pop() {
		if(top==-1) return -1;
		return stack[top--];
	}
	public static int peek() {
		return stack[top];
	}

	public static void main(String args[]) {
		push(1);
		push(2);
		push(3);
		
	}
}
