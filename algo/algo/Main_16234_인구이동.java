package algo;
import java.io.*;
import java.util.*;

public class Main_16234_인구이동 {
	static int N, R, L;
	static int[][] map;
	static boolean[][] visit;
	static int di[] = { 0, 1, 0, -1 }, dj[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		ArrayList<int[]> arr = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(map[i]));
		} // loop end
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						int cnt = 1;
						int sum = 0;
						for (int k = 0; k < 4; k++) {
							int nx = i + di[k];
							int ny = j + dj[k];
							if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
								if (Math.abs(map[nx][ny] - map[i][j]) >= R && Math.abs(map[nx][ny] - map[i][j]) <= L) {
									
								}
							}
						}

					}
				}
			}

		}

	}// main end

}
