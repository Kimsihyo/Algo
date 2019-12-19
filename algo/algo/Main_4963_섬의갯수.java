package algo;

import java.util.Scanner;



public class Main_4963_섬의갯수 {
	static int n, m,cnt;
	static int[][] map, chk;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			
			m = sc.nextInt();
			n = sc.nextInt();
			map = new int[n][m];
			chk = new int[n][m];
			// 맵 생성
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (chk[i][j] == 0 && map[i][j] == 1) {
						cnt += 1;
						chk[i][j] = cnt;
						dfs(i, j);
					}
				}
			}
			if(n!=0 && m !=0) {
				System.out.println(cnt);
			}
		}
		sc.close();
	}

	public static void dfs(int x, int y) {

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny >= 0 && nx >= 0 && ny < m && nx < n && chk[nx][ny] == 0) {
				if (map[nx][ny] == 1) {
					chk[nx][ny] = 1;
					dfs(nx, ny);
					chk[nx][ny] = cnt;
				}
			}

		}
	}
}
