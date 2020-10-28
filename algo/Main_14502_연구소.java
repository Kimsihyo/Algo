import java.io.*;
import java.util.*;

public class Main_14502_연구소 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };
	static int n, m, map[][];
	static int virusCnt, wallCnt;
	static boolean visit[][];
	static int ans;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		int totalCnt = n * m;
		wallCnt = 3;
		virusCnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {// 벽!!!!
					wallCnt++;
				}
			}
		} // end loop
			// 벽세우고 > 조합으로
			// 바이러스 퍼트림 > 조건에 맞춰서 4방으로 2(바이러스)를 퍼트림
			// 최대 영역 구하기 > 무조건 다 돌려봐야함
		ans = 10000000;
		comb(0);

		System.out.println(totalCnt - wallCnt - ans);
	}// end main

	static void comb(int cnt) {
		virusCnt = 0;
		if (cnt == 3) {
			visit = new boolean[n][m];
			h: for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 2 && !visit[i][j]) {
						virusCnt++;
						visit[i][j] = true;
						addVirus(i, j);
					}
//					System.out.println("n*m = " + n * m + " virusCnt =" + virusCnt + "wallCnt = " + wallCnt);
					if (n * m == virusCnt + wallCnt) {
						break h;
					}
				}
			}
			ans = Math.min(ans, virusCnt);
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					comb(cnt + 1);
					map[i][j] = 0;
				}
			}
		}

	}// end comb

	static void addVirus(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]
					&& (map[nx][ny] == 0 || map[nx][ny] == 2)) {
				visit[nx][ny] = true;
				virusCnt++;
				addVirus(nx, ny);

			}
		}
	}
}
