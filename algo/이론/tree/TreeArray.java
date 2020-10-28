package 이론.tree;

import java.util.Scanner;

public class TreeArray {
	public static int N;
	public static char[] a;

	public static void preorder(int i) {
		if (1 <= i && i <= N && a[i] != 0) {
			System.out.print(a[i] + " ");
			preorder(2 * i); // L
			preorder(2 * i + 1); // R
		}
	}
	public static void inorder(int i) {
		if (1 <= i && i <= N && a[i] != 0) {
			inorder(2 * i); // L
			System.out.print(a[i] + " ");
			inorder(2 * i + 1); // R
		}
	}
	public static void postorder(int i) {
		if (1 <= i && i <= N && a[i] != 0) {
			postorder(2 * i); // L
			postorder(2 * i + 1); // R
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		N = sc.nextInt();
//		a = new int[N + 1];
		N=13;
		a=new char[] {'\u0000','A','B','C','D','E','F','G','H','I','J','K','L','M'};
//		for (int i = 1; i <= N; i++)
//			a[i] = sc.nextInt();
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();
	}

}
