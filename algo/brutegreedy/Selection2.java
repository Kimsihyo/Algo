package brutegreedy;

import java.util.Arrays;

public class Selection2 {
	public static int n=5;
	public static int[] a= {64,25,10,22,11};
	public static int minidx(int i,int j) {
		if(i==j) return i;
		int min=minidx(i+1, j);
		return a[i]<a[min]? i:min;
	}
	public static void selection(int index) {
		if(index==n) return;
		int min =minidx(index,n-1);
		if(index!=min) {
			int T=a[index]; a[index] = a[min]; a[min]=T;
			System.out.println(Arrays.toString(a));
		}
		selection(index+1);
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		System.out.println();
		selection(0);
		for(int i=0;i<a.length-1;i++) {
			int min=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min])
					min=j;
			}
			int T=a[i];
			a[i]=a[min];
			a[min]=T;
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		System.out.println(Arrays.toString(a));
	}

}
