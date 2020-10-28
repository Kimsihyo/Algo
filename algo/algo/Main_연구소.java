package algo;
import java.io.*;
import java.util.*;

public class Main_연구소 {

	static int n, m, total_wall, ans;
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 세로
		m = Integer.parseInt(st.nextToken());// 가로
		map = new int[n][m];
		total_wall = 0;
		ans = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					total_wall++;
				}
			}
		}
		build(0,0,0);
		System.out.println(ans);
	}// main_끝

	static void build(int cnt, int x, int y) {
		if (cnt == 3) {
			
			ans = Math.max(ans, n*m - addVirus()-total_wall-3);
			
			return;
		}
		for (int i = x; i < n; i++) {
			for (int j = y; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					build(cnt+1,i,j);
					map[i][j] = 0;
				}
			}
		}
	}// 벽세우기 끝

	static int addVirus() {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };
		int[][] tmap = new int[n][m];
		int virus = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmap[i][j] = map[i][j];
				if (tmap[i][j] == 2) {
					q.add(new int[] { i, j });
					virus++;
				}
			}
		}
		while (!q.isEmpty()) {
			int[] temp = q.remove();
			int x = temp[0];
			int y = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + di[i];
				int ny = y + dj[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m 
								&& tmap[nx][ny] == 0) {
					tmap[nx][ny] = 2;
					q.add(new int[] {nx,ny});
					virus++;
				}
			}
			
		}
		
		return virus;
	}
}
