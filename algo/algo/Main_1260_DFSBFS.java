package algo;

import java.util.*;
import java.io.*;

public class Main_1260_DFSBFS {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점 갯수
		int m = Integer.parseInt(st.nextToken()); // 간선 갯수
		int v = Integer.parseInt(st.nextToken()); // 정점 번호
		int[][] map = new int[n][n];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		int tmap[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, tmap[i], 0, map[i].length);
		}
		dfs(0, n);
	}
	static void dfs(int step, int n) {
		if(step == n) {
		
			return;
		}
		for (int i = 0; i < n; i++) {
			
		}
	}
}
