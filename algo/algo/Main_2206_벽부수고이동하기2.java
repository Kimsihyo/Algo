package algo;
import java.io.*;
import java.util.*;
/*
 * 1,1에서 시작해서 n,m까지 가야한다
 * 
 */

public class Main_2206_벽부수고이동하기2 {
	static int di[] = { 0, 1, 0, -1 }, dj[] = { 1, 0, -1, 0 }, visit[][], n, m, ans,map[][];
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		char[][] tmap = new char[n][m];
		map = new int[n][m];
		q = new LinkedList<int[]>();
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmap[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmap[i][j] - '0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		ans = Integer.MAX_VALUE;
		bfs(0,0);
		if (ans == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(ans);
	}

	static void bfs(int x, int y) {
		
		q.add(new int[] {x,y,1,0});
		visit[0][0] = 0;// 처음
		
		while (!q.isEmpty()) {
			int[] temp = q.remove();
			x = temp[0];
			y = temp[1];
			int cnt = temp[2];
			int break_wall = temp[3];
			if (x == n - 1 && y == m - 1) {
				ans = cnt;
				break;
			}

			// 만약 벽을 부셨으면 break_wall = 1 안부셨으면 0

			for (int i = 0; i < 4; i++) {
				int nx = di[i] + x;
				int ny = dj[i] + y;
				if (nx >= 0 && ny >= 0 && nx < n && ny < m 
						&& visit[nx][ny] > break_wall) {
					if (map[nx][ny] == 0) {
						visit[nx][ny] = break_wall;
						q.add(new int[] { nx, ny, cnt+1, break_wall });
						
					} else {
						visit[nx][ny] = break_wall + 1;
						q.add(new int[] { nx, ny, cnt+1 , break_wall + 1 });
					}
				}

			}
		}
	}

}
