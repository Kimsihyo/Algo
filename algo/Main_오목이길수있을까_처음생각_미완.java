
/*
 * 추가 생각 :  모든 .에 x를 놓는게 아니고 그냥 x 주변에 x를 놓아보면 될듯 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_오목이길수있을까_처음생각_미완 {
	static int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static char map[][];
	static boolean chk[][];
	static Queue<int[]> q ;
	public static void main(String[] args) {
		// x를 다 놓아보고 연속된 5개 라면 이긴다 . 1
		Scanner sc = new Scanner(System.in);
		map = new char[10][10];
		chk = new boolean[10][10];
		q = new LinkedList<int[]>();
		boolean ans = false;
		for (int i = 0; i < 10; i++) {
			map[i] = sc.next().toCharArray();
			for (int j = 0; j < 10; j++) {
				if(map[i][j]=='X') {
//					chk[i][j] = true;
				}
			}
		}

		here: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 'X') {
					for (int k = 0; k < 8; k++) { // 8방 탐색
						chk[i][j] = true;
						q.add(new int[] {i,j});
						int ni = i + di[k];;
						int nj = j + dj[k];
						if (ni >= 0 && nj >= 0 && ni < 10 && nj < 10 
								&& !chk[ni][nj] 
										&& map[ni][nj]=='.') {
							map[ni][nj] = 'X';
							if (dfs(i, j, 0)) {
								System.out.println("1");
								ans = true;
								break here;
							} else {
								map[ni][nj] = '.';
							}
						}
					}
					chk[i][j] = false;
				}
			}
		}
		if (!ans) {
			System.out.println("0");
		}
	}

	static boolean dfs(int i, int j, int cnt) {
		// 5개 연속되는지 확인하자
		boolean cchk = false;
		if (cnt == 5) {
			cchk=true;
			return cchk;
		} else {
			for (int k = 0; k < 8 && !cchk; k++) { // 8방 탐색
				int ni = i + di[k];
				int nj = j + dj[k];
				if (ni >= 0 && nj >= 0 && ni < 10 && nj < 10 && map[ni][nj] == 'X' && !chk[ni][nj]) {
					chk[ni][nj] = true;
					cchk=dfs(ni, nj, cnt+1);
				}
			}
		}
		return cchk;
	}
}
