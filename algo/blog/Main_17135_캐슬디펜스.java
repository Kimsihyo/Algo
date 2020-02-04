package blog;

/*
 * 1. 궁수 배치
 * 2. 격발
 * 3. 죽음 체크
 * 		1. 왼쪽 우선
 * 4. 이동 
 */

import java.util.*;

public class Main_17135_캐슬디펜스 {
	static int n, m, d, map[][], tmap[][], bow_master[], di[] = { 0, 0, -1 }, dj[] = { -1, 1, 0 }, tans, rans;
	static Queue<int[]> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt() + 1;
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n][m];
		
		rans = -1;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		q = new LinkedList<int[]>();
		bow_master = new int[m];
		perm(0, 0);
		System.out.println(rans);

	}

	static void perm(int step, int idx) {
		if (step == 3) {
			// 궁수 배치
			// 전에 temp 맵 받아 보자
			tmap = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					tmap[i][j] = map[i][j];
				}
			}
			for (int j = 0; j < m; j++) {
				tmap[n-1][j] = bow_master[j];
			}
			// 격발
			boolean chk = false;
			tans = 0;
			boolean[][] visit = new boolean[n][m];
			while (!chk) {
				chk = true;
				// 궁수 위치 찾고, 사거리 안에 적이 있는지 확인
				for (int i = 0; i < m; i++) {
					if (tmap[n-1][i] == 2) {// 궁수 위치에서 bfs
						q.add(new int[] { n - 2, i, 1 });// 사거리 1일때
						visit[n-2][i] = true;
						while (!q.isEmpty()) {
							int[] temp = q.remove();
							int x = temp[0];
							int y = temp[1];
							int dist = temp[2];
							
							if (dist > d) {// 사거리 내 없을 때
								q.clear();
								break;
							}
							if (tmap[x][y] == 1) { // 거리 내 있을때
								tmap[x][y] = 0;
								tans ++;
								q.clear();
								break;
							}
							// 3방 탐색하면서 사거리 내 적 찾기
							for (int j = 0; j < 3; j++) {
								int nx = x + di[j];
								int ny = y + dj[j];
								if (nx >= 0 && ny >= 0 && nx < n - 1 && ny < m && !visit[nx][ny]) {
									visit[nx][ny] = true;
									q.add(new int[] { nx, ny, dist + 1 });
								}
							}
						}

					}
				}
				// 이동
				for (int i = n - 2; i >= 0; i--) {
					for (int j = 0; j < m; j++) {
						if (tmap[i][j] == 1) {
							chk = false; // 적이 map 안에 있으면 계속 돌아야 한다.
						}
						if (i > 1) {
							tmap[i][j] = tmap[i - 1][j];
						} else if (i == 0) {
							tmap[0][j] = 0;
						}
					}
				}

			}
			if(rans < tans) {
				rans = tans;
			}
			return;
		}
		for (int i = idx; i < m; i++) {
			bow_master[i] = 2;
			perm(step + 1, i + 1);
			bow_master[i] = 0;
		}
	}
}
