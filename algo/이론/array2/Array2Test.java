package 이론.array2;

import java.util.Arrays;

public class Array2Test {
	public static void main(String[] args) {
		// 1.선언
		int[][] a; // int a[][]; // int[] a[];
		// 2.생성
		a = new int[3][3];
		// 1+2
		int[][] b = new int[3][];
		// 3.초기화
		b[0][0] = 10;
		b[1][1] = 11;
		b[2][2] = 12;
		// 1,2+3
		int[][] c = { { 10, 0, 0 }, { 0, 11, 0 }, { 0, 0, 12 } };
		int[][] d = new int[][] { { 10, 0, 0 }, { 0, 11, 0 }, { 0, 0, 12 } };

		int[][] e;
//		e= {{10,0,0},
//			{0,11,0},
//			{0,0,12}}; //err
		e = new int[][] { { 10 }, { 0, 11 }, { 0, 0, 12 } };// ok
		// 4.출력
//		for(int i=0; i<e.length; i++) {
//			for(int j=0; j<e[i].length; j++) {
//				System.out.print(e[i]+" ");
//			}
//			System.out.println();
//		}
//		for(int[] w:e) { // w가 1차원 배열이 됨
//			for(int v:w) {
//				System.out.print(v+ " ");
//			}
//			System.out.println();
//		}
//		for(int[] w:e) System.out.println(Arrays.toString(w));
//		
		//5. 복제
		int[][] f=new int[e.length][];
		for(int i=0; i<e.length; i++) {
//			f[i] = new int[e[i].length];
//			System.arraycopy(e[i],  0, f[i], 0, e[i].length);
			f[i]=Arrays.copyOf(e[i], e[i].length);
		}
		e[0][0] = 0;
		for(int[] w:e) System.out.println(Arrays.toString(w));
		for(int[] w:f) System.out.println(Arrays.toString(w));
	}
}