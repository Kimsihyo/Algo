package array2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch1 {
	public static int[] a= {2,4,7,9,11,19,23};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int key=sc.nextInt();
//		System.out.println(binarySearch(key));
		System.out.println(Arrays.binarySearch(a, key));
	}

	private static boolean binarySearch(int key) {
		int start=0, end=a.length-1;	// .length는 상수 .length()는 함수
		// a.length=5은 에러
		while(start<=end) {
			int middle=(start+end)/2;
			if(a[middle]==key)
				return true;
			else if(a[middle]>key)
				end=middle-1;
			else
				start=middle+1;
		}
		return false;
	}

}
