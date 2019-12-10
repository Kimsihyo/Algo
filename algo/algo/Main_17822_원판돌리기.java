package algo;

import java.util.*;
import java.io.*;

public class Main_17822_원판돌리기 {
	static int cir[][], n, m, t;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 원판의 크기
		m = Integer.parseInt(st.nextToken()); // 각 원판의 정점 갯수
		t = Integer.parseInt(st.nextToken()); // t번 회전 시킴

		cir = new int[n][m]; // 원판	
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
		// t번 돌리자 
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // x배수 원판을 돌리자
			d = Integer.parseInt(st.nextToken()); // 0 시계 1 반시계
			k = Integer.parseInt(st.nextToken()); // k 칸 돌림
			
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
	
	
	//
	static void start(int nx, int nd, int nk) {
		int temp = 0;
		for (int i = 1; i <= nk; i++) { // 몇 바퀴 돌릴꺼 ?
				for (int j = 1;; j++) {
					// x 배수 원판을 돌리자 
					int a = j * nx;
					// 원판 크기 보다 커지면 멈춤 
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
		}
		find(); 
	}

	static void find() {
		// 탐색
		int sum = 0; // 원판의 총합
		boolean chk = false; // true이면 인접한 수 중 같은 수가 있을 때  / false면 같은 수가 없을 때 
		int cnt = 0; // chk가 false일때 써먹을거 0이 아닌 수가 몇개 인지 찾음 

		int[][] tcir = new int[n][m];// temp map
		for (int i = 0; i < n; i++) {
			Arrays.fill(tcir[i], -1);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				if(cir[i][j] != 0) {
					cnt++;
				}
				
				sum += cir[i][j]; // 현재 위치 0 이면 패스
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					if (ni < 0)
						continue;
					if (ni >= n)
						continue;
					if (nj < 0) { // 1번 정점과 마지막 정점을 비교 해줌
						if (cir[ni][m - 1] == cir[ni][0] 
								&& (cir[ni][m - 1] != 0 && cir[ni][0] != 0)) {// 한번도 변한적 없는 것만 바꿔 주자
							tcir[ni][m - 1] = 0;
							tcir[ni][0] = 0;
							chk = true;
						}
					}
					if (nj >= m) // 위에 마지막 정점은 1번 정점과 비교해줬음
						continue;

					//위에서 예외는 다 처리해줬으니 그냥 찾아 보자
					if (ni >= 0 && nj >= 0 && ni < n && nj < m 
							&& (cir[i][j] != 0 && cir[ni][nj] != 0)) {// 한번도 변한적 없는 것만 바꿔 주자
						if (cir[i][j] == cir[ni][nj]) {
							tcir[i][j] = 0;
							tcir[ni][nj] = 0;
							chk = true;
						}
					}
				}
			}
		}
		// 인접한 정점에 같은것이 하나도 없었을때 
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
			// 인접한 정점에 같은것이 있었을 때 
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
