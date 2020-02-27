package algo;
import java.util.Scanner;

public class Main_1085_직사각형에서탈출 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
//		if(w-x>h-y) {
//			System.out.println(h-y);
//		}else {
//			System.out.println(w-x);
//		}
		int min = x;
	    if (min > w - x)
	        min = w - x;
	    if (min > y)
	        min = y;
	    if (min > h - y)
	        min = h - y;
	
	System.out.println(min);
	}
}
