package algo;

import java.util.Scanner;

public class Main_15969_행복 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<n;i++) {
			a[i] = sc.nextInt();
			if(min > a[i]) {
				min = a[i];
			}
			if(max < a[i]) {
				max = a[i];
			}
		}
		System.out.println(max-min);
		
	}

}
