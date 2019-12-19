package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15649_N과M1 {
	static int[] arr;
	static boolean[] chk;
	static int n, m,cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 4
		m = sc.nextInt(); // 2
		arr = new int[n];
		chk = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (i - 1 >= 0) {
				arr[i] = arr[i - 1] + 1;
			} else {
				arr[i] = 1;
			}
		}
		cnt = 0;
		perm();
	}

	static void perm() {
		
		if(cnt < m) {
			for (int i = 0; i < m; i++) {
				System.out.println(Arrays.toString(arr));
			}
			return;
		}else {
			for (int i = 1; i <= n; i++) {
				if(!chk[i]) {
					chk[i] = true;
					arr[i] = i;
				}
				cnt++;
				perm();
			}
		}
	}
}
