
/*
 * map, linked로도 풀것 
 */

import java.io.*;
import java.util.*;

public class Main_1012_유기농배추_map_bfs {
	static int di[] = { -1, 1, 0, 0 }, dj[] = { 0, 0, -1, 1 }, n, m, k, map[][];
	static Queue<int[]> q;

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
			q = new LinkedList<>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int tm = Integer.parseInt(st.nextToken());
				int tn = Integer.parseInt(st.nextToken());
				map[tn][tm] = 1;
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						map[i][j] = 0;
						q.add(new int[] {i,j});
						
						while(!q.isEmpty()) {
							int[] temp = q.poll();
							int nm = temp[0];
							int nn = temp[1];
							for (int k = 0; k < 4; k++) {
								int ni = nm + di[k];
								int nj = nn + dj[k];
								if (ni >= 0 && nj >= 0 && ni < n && nj < m
										&& map[ni][nj] == 1 ) {
									map[ni][nj] = 0;
									q.add(new int[] {ni,nj});
								}
							}
						}
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
