package 이론.stack2;
import java.util.Arrays;
import java.util.Stack;
public class Postfix2Calc {
   // public static String msg="234*5/+";//6528-*2/+
    public static String msg="6528-*2/+";//6528-*2/+
    public static Stack<Integer> stack=new Stack<Integer>();
    public static void main(String[] args) {
        for(int i=0;i<msg.length();i++) {
            char c=msg.charAt(i);
            if(Character.isDigit(c))
                stack.push(c-'0');
            else {System.out.println(Arrays.toString(stack.toArray()));
                int n2=stack.pop();
                int n1=stack.pop();
                int nn=0;
                System.out.println(n1+" "+n2);
                switch(c) {
                case '+':
                    nn=n1+n2;
                    break;
                case '-':
                    nn=n1-n2;
                    break;
                case '*':
                    nn=n1*n2;
                    break;
                case '/':
                    nn=n1/n2;
                    break;
                }
                stack.push(nn);
            }
        }
        System.out.println(stack.pop());
    }
}