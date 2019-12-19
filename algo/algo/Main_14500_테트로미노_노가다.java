package algo;

import java.util.*;

public class Main_14500_테트로미노_노가다 {
	public static int[][][] block = { 
			{ { 0, 1 }, { 0, 2 }, { 0, 3 } }, // 1
			{ { 1, 0 }, { 2, 0 }, { 3, 0 } }, // 2
			{ { 0, 1 }, { 1, 0 }, { 1, 1 } }, // 3
			{ { 1, 0 }, { 2, 0 }, { 2, 1 } }, // 4
			{ { 0, 1 }, { 0, 2 }, { -1, 2 } }, // 5
			{ { 0, 1 }, { 1, 1 }, { 2, 1 } }, // 6
			{ { 1, 0 }, { 0, 1 }, { 0, 2 } }, // 7
			{ { 0, 1 }, { 1, 0 }, { 2, 0 } }, // 8
			{ { 1, 0 }, { 1, 1 }, { 1, 2 } }, // 9
			{ { 1, 0 }, { 2, 0 }, { 2, -1 } }, // 10
			{ { 0, 1 }, { 0, 2 }, { 1, 2 } }, // 11
			{ { 1, 0 }, { 1, 1 }, { 2, 1 } }, // 12
			{ { 0, 1 }, { 1, 0 }, { 1, -1 } }, // 13
			{ { 1, 0 }, { 0, 1 }, { -1, 1 } }, // 14
			{ { 0, 1 }, { 1, 1 }, { 1, 2 } }, // 15
			{ { 1, 0 }, { 1, -1 }, { 2, 0 } }, // 16
			{ { 0, 1 }, { 0, 2 }, { -1, 1 } }, // 17
			{ { 0, 1 }, { 0, 2 }, { 1, 1 } }, // 18
			{ { 1, 0 }, { 2, 0 }, { 1, 1 } } // 19
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 19; k++) {
					boolean chk = true;
					int sum = arr[i][j];
					for (int l = 0; l < 3; l++) {
						int x = i + block[k][l][0];
						int y = j + block[k][l][1];
						if (0 <= x && x < n && 0 <= y && y < m) {
							sum += arr[x][y];
						} else {
							chk = false;
							break; // 좋타
						}
					}
					if (chk == true && ans < sum) {
	                    ans = sum;
	                }
				}
			}
		}
		 System.out.println(ans);
	}
}
