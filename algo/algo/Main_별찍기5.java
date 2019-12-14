package algo;
/*
 * 5개면 4 1 4
 * 	   2 3 2
 *     0 5 0
 */
import java.util.Scanner;

public class Main_별찍기5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() * 2;
		for (int i = 1; i <= n/2; i++) {
			for (int j = 1; j <= n; j++) {
				if(j > (n/2)-i) {
					System.out.print(" ");
				}else if(j < (n/2)+i) {
					break;
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
