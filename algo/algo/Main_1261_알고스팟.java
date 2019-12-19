package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static char[][] inmap;
	static int[][] map, map2;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static Queue<Pair> q;
	static boolean[][] chk;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		inmap = new char[n][m];
		map = new int[n][m];
		chk = new boolean[n][m];
		q = new LinkedList<Pair>();
		for (int i = 0; i < n; i++) {
//			inmap[i] = br.readLine().toCharArray();
			inmap[i] = sc.next().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = inmap[i][j] - '0';
			}
		}
		map2 = new int[n][m];
		q.add(new Pair(0, 0));
		
		
		while (!q.isEmpty()) {
			
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			if(x==n-1 && y==m-1) {
				q.clear();
				break;
			}
			chk[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + di[i];
				int ny = y + dj[i];
				if(nx>0&&ny>0&&nx<n&&ny<m ) {
					if(map[nx][ny] == 0) {
						q.add(new Pair(nx,ny));
						if(map2[nx][ny] > map2[x][y]) {
							map2[nx][ny] = map2[x][y];
						}
						
					}else if(map[nx][ny] == 1) {
						q.add(new Pair(nx,ny));
						if(map2[nx][ny] < map2[x][y]) {
							map2[nx][ny] = map2[x][y];
						}else {
							map2[nx][ny] = map2[x][y] + 1;
						}
					}
				}
			}

		}
		System.out.println(map2[n-1][m-1]);
		sc.close();
	}


}
