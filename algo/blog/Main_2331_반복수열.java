package blog;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2331_반복수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int p = sc.nextInt();
		boolean[] arr = new boolean[10000];
		int nn = 0;
		int cnt = 0;
		char[] arr2 = new char[n.length()];
		int[] arr3 = new int[n.length()];
		arr2 = n.toCharArray();
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr2[i] -  '0';
		}
		while (true) {

			
			for (int i = 0; i < arr2.length; i++) {
				int mul = arr3[i];
				for (int j = 0; j < p; j++) {
					arr3[i] *= mul;
				}
			}
			
			nn = 0 ;
			for (int i = 0; i < arr3.length; i++) {
				nn += arr3[i];
				arr3[i] = 0;
			}
			
			while (nn > 0) {
	            ans += pow(a%10, p);
	            nn /= 10;
	        }
			
			if(arr[nn]) {
				break;
			}else {
				arr[nn] = true;
			}

		}
		System.out.println(cnt);
	}

}
