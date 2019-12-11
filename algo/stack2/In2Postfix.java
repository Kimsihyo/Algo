package stack2;
import java.util.Stack;
public class In2Postfix {
   public static String msg = "(6+5*(2-8)/2)";
   public static Stack<Character> stack = new Stack<Character>();
   public static void main(String[] args) {
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < msg.length(); i++) {
           char c = msg.charAt(i);
           if ('0' <= c && c <= '9')
               sb.append(c);
           else if (c == ')') {
               char op;
               while ((op = stack.pop()) != '(') {
                   sb.append(op);
               }
           } else {
               while (getIcp(c) <= getIsp()) {
                   char op = stack.pop();
                   sb.append(op);
               }
               stack.push(c);
           }
       }
       while (!stack.empty()) {
           sb.append(stack.pop());
       }
       System.out.println(sb.toString());
   }
   public static int getIcp(char c) {
       switch (c) {
       case '+':
       case '-':
           return 1;
       case '*':
       case '/':
           return 2;
       case '(':
           return 3;
       default:
           return 0;
       }
   }
   public static int getIsp() {
       char c = (stack.empty()) ? ' ' : stack.peek();
       switch (c) {
       case '+':
       case '-':
           return 1;
       case '*':
       case '/':
           return 2;
       case '(':
       default:
           return 0;
       }
   }
}