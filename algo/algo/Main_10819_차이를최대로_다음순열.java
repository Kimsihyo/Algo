package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10819_차이를최대로_다음순열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i =0; i< n ; i++) {
			a[i] = sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		Arrays.sort(a);
		int sum;
		do {
			int temp = 0;
			sum = 0;
			for(int i = 0; i< n-1;i++) {
				temp = Math.abs(a[i]-a[i+1]);
				sum += temp;
			}
			if(max <= sum) {
				max = sum;
			}
		}while(perm(a));
		System.out.println(max);
	}
	
	public static boolean perm(int[] a) {
		int i = a.length-1;
		while(i>0 && a[i] <= a[i-1]) {
			i-=1;
		}
		if(i<=0) {
			return false;
		}
		int j = a.length-1;
		while(a[j] <= a[i-1]) {
			j-=1;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}

}
