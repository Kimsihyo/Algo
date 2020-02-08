import java.io.*;
import java.util.*;

public class Main_연구소 {
	static int map[][], tmap[][], n, m, ans, dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 }, wall;
	static Queue<int[]> virus;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		virus = new LinkedList<int[]>();
		wall =3;
		ans = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					wall++;
				}
			}
		}
		comb(0);
		System.out.println(ans);
		br.close();
	}

	static void comb(int cnt) {
		if (cnt == 3) {

			diffusion();

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
	}

	static void diffusion() {
		// 맵 복사
		tmap = new int[n][m];
		int init_virus = 0;
		for (int i = 0; i < n; i++) {
//			System.arraycopy(map[i], 0, tmap[i], 0, map[i].length);
			for (int j = 0; j < m; j++) {
				tmap[i][j] = map[i][j];
				if(tmap[i][j] == 2) {
					virus.add(new int[] {i,j});
					init_virus++;
				}
			}
		}
		int cnt =0 ;
		while (!virus.isEmpty()) {
			int[] temp = virus.remove();
			int x = temp[0];
			int y = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m && tmap[nx][ny] == 0) {
					tmap[nx][ny] = 2;
					virus.add(new int[] { nx, ny });
					cnt++;
				}
			}
		}
		int max = (n*m) - (wall+cnt+init_virus);
		ans = Math.max(max, ans);
	}
}
