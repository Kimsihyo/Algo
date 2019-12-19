package algo;

import java.util.Scanner;

public class Main_2468_안전영역 {
	public static int n, max, cnt;
	public static int[][] map;
	public static boolean[][] chk, chk2;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		chk = new boolean[n][n];

		max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (max < map[i][j]) {
					max = map[i][j];
				}
			}
		}
		int temp = Integer.MIN_VALUE;
		for (int k = 1; k <= max; k++) {

			cnt = 0;
			chk2 = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!chk2[i][j] && map[i][j] >= k) {
						cnt++;
						dfs(i, j , k);
					}
				}
			}
			
			if(temp < cnt) {
				temp = cnt;
			}
		}
		System.out.println(temp+" ");
	}

	public static void dfs(int i, int j, int k) {
		chk2[i][j] = true;
		for (int a = 0; a < 4; a++) {
			int ni = i + di[a];
			int nj = j + dj[a];
			if (ni >= 0 && nj >= 0 && ni < n && nj < n && !chk2[ni][nj] && map[ni][nj] >= k) {
				dfs(ni,nj,k);
				
			}
		}
	}

}
