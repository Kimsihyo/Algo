package array2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch2 {
	public static int[] a= {2,4,7,9,11,19,23};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int key=sc.nextInt();
		System.out.println(binarySearch(0, a.length, key));
	}

	private static boolean binarySearch(int low, int high, int key) {
		if(low>high)
			return false;
		
		int middle=(low+high)/2;
		
		if(key==a[middle])
			return true;
		else if(key<a[middle])
			return binarySearch(low, middle-1, key);
		else
			return binarySearch(middle+1, high, key);
	}

}
