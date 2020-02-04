
import java.io.*;

import java.util.*;


public class 연습장 {
	static int n,m,arr[] , ans[];
	static boolean arr2[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[n];
		arr2 = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
//		System.out.println(Arrays.toString(arr));
		perm(0,0);
	}
	static void perm(int idx, int step) {
		if(step == m) {
			for (int i = 0; i < n; i++) {
				if(arr2[i]) {
					System.out.print(ans[i] + " ");								
				}
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!arr2[i]) {
				arr2[i] = true;
				ans[step] = arr[i];
				perm(i,step+1);
				arr2[i] = false;
			}
			
		}
	}
}

//	static void perm(int step) {
//		if(r == step) {
//			for (int i = 0; i < r; i++) {
//				System.out.print(arr2[i]+" ");
//			}
//			System.out.println();
//			return;
//		}else {
//			for (int i = 0; i < n; i++) {
//				if(!chk[i]) {
//					arr2[step]= arr[i];
//					chk[i] = true;
//					perm(step+1);
//					chk[i] = false;
//				}
//			}
//		}
//	}
//}
