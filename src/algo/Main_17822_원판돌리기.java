package algo;

import java.util.*;
import java.io.*;

public class Main_17822_원판돌리기 {
	static int cir[][], n, m, t;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception{
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		cir = new int[n][m];
		int x = 0;
		int d = 0;
		int k = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				cir[i][j] = Integer.parseInt(st.nextToken());
//				System.out.print(cir[i][j]+" ");
			}
//			System.out.println();
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken()); // 0 시계 1 반시계
			k = Integer.parseInt(st.nextToken());
			start(x, d, k);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans += cir[i][j];
			}
		}
		System.out.println(ans);
		br.close();
	}

	static void start(int nx, int nd, int nk) {
		int temp = 0;
		for (int i = 1; i <= nk; i++) { // 몇 바퀴 돌릴꺼 ?
			if (nx > 1) {
				for (int j = 1;; j++) {
					int a = j * nx;
					if (a > n)
						break;
					// 시계 방향
					if (nd == 0) {
						for (int k = m-1; k > 0; k--) {
							temp = cir[a -1][k];
							cir[a - 1][k] = cir[a - 1][k - 1];
							cir[a - 1][k - 1] = temp;
						}
					} else { // 반시계
						for (int k = 0; k < m - 1; k++) {
							temp = cir[a -1][k];
							cir[a - 1][k] = cir[a - 1][k + 1];
							cir[a - 1][k + 1] = temp;
						}
					}
				}

			} else { // nx가 1 이면 
				if (nd == 0) {
					for (int k = m-1; k > 0; k--) {
						temp = cir[nx - 1][k];
						cir[nx - 1][k] = cir[nx - 1][k - 1];
						cir[nx - 1][k - 1] = temp;
					}
					
				} else { // 반시계
					for (int k = 0; k < m - 1; k++) {
						temp = cir[nx - 1][k];
						cir[nx - 1][k] = cir[nx - 1][k + 1];
						cir[nx - 1][k + 1] = temp;
					}
				}
			}
		}
		find();
	}

	static void find() {
		// 탐색
		int sum = 0;
		int cnt =0;
		boolean chk = false;

		int[][] tcir = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(tcir[i], -1);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(cir[i][j] != 0) { // 어쩌피 chk가 false이면 변한게 없으니까 그냥 카운트 해주면된다.
					cnt++;
				}
				sum += cir[i][j];// 현재 위치 0 이면 패스
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					if (ni < 0)
						continue;
					if (ni >= n)
						continue;
					if (nj < 0) {
						if (cir[ni][m - 1] == cir[ni][0] 
								&& (cir[ni][m - 1] != 0 && cir[ni][0] != 0)) {
							tcir[ni][m - 1] = 0;
							tcir[ni][0] = 0;
							chk = true;
						}
					}
					if (nj >= m)
						continue;

					if (ni >= 0 && nj >= 0 && ni < n && nj < m 
							&& (cir[i][j] != 0 && cir[ni][nj] != 0)) {// 한번 바꿨으면 체크
						if (cir[i][j] == cir[ni][nj]) {
							tcir[i][j] = 0;
							tcir[ni][nj] = 0;
							chk = true;
						}
					}
				}
			}
		}

		if (!chk) {
			float avg = (float)sum / cnt;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if ((float)cir[i][j] > avg && cir[i][j] != 0) {
						cir[i][j] -= 1;
					} else if ((float)cir[i][j] < avg && cir[i][j] != 0) {
						cir[i][j] += 1;
					}else if((float)cir[i][j] == avg && cir[i][j] != 0){
						continue;
					}
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (tcir[i][j] == 0) {
						cir[i][j] = tcir[i][j];
					}
				}
			}
		}
	}
}
