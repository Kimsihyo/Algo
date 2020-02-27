package algo;
import java.io.*;
import java.util.*;

public class Main_젤다 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };
		int tc = 0;// 테스트케이스
		while (true) {
			tc++;
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			int[][] map = new int[n][n]; // 입력 맵
			int[][] tmap = new int[n][n]; // 최소값 넣는 맵
			int INF = Integer.MAX_VALUE;
			boolean[][] visit = new boolean[n][n];
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2], o2[2]);
				}
			});
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmap[i][j] = INF;
				}
			}
			tmap[0][0] = map[0][0]; // 스타트 지점은 항상 최소값이다
			q.add(new int[] { 0, 0, map[0][0] });
			while (!q.isEmpty()) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];
				int w = arr[2];
				
				if (x == n - 1 && y == n - 1) {
					System.out.println("Problem " + tc + ":" + " " + w);
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nx = x + di[i];
					int ny = y + dj[i];
					if (nx >= 0 && ny >= 0 && nx < n && ny < n &&!visit[nx][ny] && 
							tmap[nx][ny] > tmap[x][y] + map[nx][ny]) {
						tmap[nx][ny] = tmap[x][y] + map[nx][ny];
						q.add(new int[] { nx, ny, tmap[nx][ny] }); 
					}
				}
				visit[x][y] = true;

			}

		}
	}

}
