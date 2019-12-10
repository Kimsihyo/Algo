package algo;

/*
 * 추가 생각 :  모든 .에 x를 놓는게 아니고 그냥 x 주변에 x를 놓아보면 될듯 
 */

import java.util.Scanner;

public class Main_16955_오목이길수있을까 {
	static int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static boolean ans;

	public static void main(String[] args) {
		// x를 다 놓아보고 연속된 5개 라면 이긴다 . 1
		Scanner sc = new Scanner(System.in);
		char map[][] = new char[10][10];
		ans = false;
		for (int i = 0; i < 10; i++) {
			map[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 'X' || map[i][j] == '.') {
					for (int k = 0; k < 8; k++) {
						boolean tmp = map[i][j] == 'X' ? false : true;
						dfs(map, i, j, k, tmp, 1);
						if (ans) {
							System.out.println("1");
							return;
						}
					}
				}
			}
		}
		System.out.println("0");
	}

	private static void dfs(char[][] map, int i, int j, int dir, boolean put, int len) {
		if (len < 5) {
			int rx = i + di[dir];
			int ry = j + dj[dir];
			if (rx >= 0 && rx < 10 && ry >= 0 && ry < 10) {
				if (map[rx][ry] == 'X')
					dfs(map, rx, ry, dir, put, len + 1);
				else if (map[rx][ry] == '.' && !put)
					dfs(map, rx, ry, dir, true, len + 1);
			}
		} else {
			ans = true;
			return;
		}
	}
}
