package algo;

/*
 * map, linked로도 풀것 
 */

import java.io.*;
import java.util.*;

public class Main_1012_유기농배추_map_dfs {
	static int di[] = { -1, 1, 0, 0 }, dj[] = { 0, 0, -1, 1 }, n, m, k, map[][];
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());// 가
			n = Integer.parseInt(st.nextToken());// 세
			k = Integer.parseInt(st.nextToken());// 갯수
			map = new int[n][m];
			visit = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int tm = Integer.parseInt(st.nextToken());
				int tn = Integer.parseInt(st.nextToken());
				map[tn][tm] = 1;
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1&& !visit[i][j]) {
						visit[i][j] = true;
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static void dfs(int nm, int nn) {
		for (int i = 0; i < 4; i++) {
			int ni = nm + di[i];
			int nj = nn + dj[i];
			if (ni >= 0 && nj >= 0 && ni < n && nj < m
					&& map[ni][nj] == 1 && !visit[ni][nj]) {
				visit[ni][nj] = true;
				dfs(ni,nj);
			}
		}

	}
}
