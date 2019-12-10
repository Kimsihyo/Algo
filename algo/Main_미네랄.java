

import java.util.*;

public class Main_미네랄 {
	static char map[][];
	static int r, c, n;
	static ArrayList<int[]> cluster;
	static Queue<int[]> q;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = Integer.parseInt(sc.next());
		c = Integer.parseInt(sc.next());
		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = sc.next().toCharArray();
//			System.out.println(Arrays.toString(map[i]));
		}
		n = Integer.parseInt(sc.next());
		cluster = new ArrayList<int[]>();
		q = new LinkedList<int[]>();

		for (int i = 0; i < n; i++) {
			int fire = Integer.parseInt(sc.next()); // 부셔버릴 높이

			if (i % 2 == 0) {
				// 짝수는 가장 왼쪽 부수기
				for (int j = 0; j < c; j++) {
					if (map[r - fire][j] == 'x') {
						map[r - fire][j] = '.';

						// 클러스터 확인하러 가자 bfs로
						bfs();
						
						break;
					}
				}
			} else {
				// 홀수면 가장 오르쪽 부수기
				for (int j = c-1; j > 0; j--) {
					if (map[r - fire][j] == 'x') {
						map[r - fire][j] = '.';
						// 클러스터 확인하러 가자 bfs로
						bfs();
						
						break;
					}
				}

			}
			down();
		}
		for (int i = 0; i < r; i++) {
			
			System.out.println(map[i]);
		}

	}

	// 클러스터 확인하기
	// 마지막에 list 초기화 하자
	static void bfs() {
		int ccnt =0; // 클러스터 갯수 
		int[][] tmap = new int[r][c]; 
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == 'x' && tmap[i][j] == 0) {
					ccnt++; 
					q.add(new int[] {i,j});
					cluster.add(new int[] {i,j,ccnt});
					while(!q.isEmpty()) {
						tmap[i][j] = ccnt;
						int[] a = new int[2];
						a = q.remove();
						int x = a[0];
						int y = a[1];
						for (int k = 0; k < 4; k++) {
							int ni = x + di[k];
							int nj = y + dj[k];
							if(ni>=0&&nj>=0&&ni<r&&nj<c
									&&map[ni][nj]=='x' 
									&& tmap[ni][nj]==0) {
								q.add(new int[] {ni,nj});
								tmap[ni][nj] = ccnt;
								cluster.add(new int[] {ni,nj,ccnt});
							}
						}
					}// 클러스팅 끝
				}
			}
		}
		
		
	}

	static void down() {
		
	}

}
