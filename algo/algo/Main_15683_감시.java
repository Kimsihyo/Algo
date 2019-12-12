package algo;

/*
 * 1번 CCTV는 한 쪽 방향만 감시할 수 있다. 4개
 * 2번과 3번은 두 방향을 감시할 수 있는데, 
 * 2번은 감시하는 방향이 서로 반대방향이어야 하고,  2개
 * 3번은 직각 방향이어야 한다.  4개
 * 4번은 세 방향, 4개
 * 5번은 네 방향을 감시할 수 있다. 1개
 * 
 * #이 가장 많이 만들어지는 경우
 */

import java.io.*;
import java.util.*;

public class Main_15683_감시 {
	static int map[][], n, m, ans;
	static ArrayList<int[]> cctv;

	static void up(int x, int y) {
		for (int i = x; i >= 0; i--) {
			if (map[i][y] == 6)
				break;
			else if (map[i][y] <= 0)
				map[i][y]--;

		}
	}

	static void down(int x, int y) {
		for (int i = x; i < n; i++) {
			if (map[i][y] == 6)
				break;
			else if (map[i][y] <= 0)
				map[i][y]--;

		}
	}

	static void right(int x, int y) {
		for (int i = y; i < m; i++) {
			if (map[x][i] == 6)
				break;
			else if (map[x][i] <= 0)
				map[x][i]--;

		}
	}

	static void left(int x, int y) {
		for (int i = y; i >= 0; i--) {
			if (map[x][i] == 6)
				break;
			else if (map[x][i] <= 0)
				map[x][i]--;

		}
	}

	static void clearup(int x, int y) {
		for (int i = x; i >= 0; i--) {
			if (map[i][y] == 6)
				break;
			if (map[i][y] <= -1) {
				map[i][y]++;
			}
		}
	}

	static void cleardown(int x, int y) {
		for (int i = x; i < n; i++) {
			if (map[i][y] == 6)
				break;
			if (map[i][y] <= -1) {
				map[i][y]++;
			}
		}
	}

	static void clearleft(int x, int y) {
		for (int i = y; i >= 0; i--) {
			if (map[x][i] == 6)
				break;
			if (map[x][i] <= -1) {
				map[x][i]++;
			}
		}
	}

	static void clearright(int x, int y) {
		for (int i = y; i < m; i++) {
			if (map[x][i] == 6)
				break;
			if (map[x][i] <= -1) {
				map[x][i]++;
			}
		}
	}

	static void go(int idx) {
		if (idx >= cctv.size()) {
			int cnt = checkHide();
			ans = Math.min(ans, cnt);
			return;
		}

		if (cctv.get(idx)[2] == 1) { // 1번 4방향
			up(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearup(cctv.get(idx)[0], cctv.get(idx)[1]);

			down(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			cleardown(cctv.get(idx)[0], cctv.get(idx)[1]);

			left(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearleft(cctv.get(idx)[0], cctv.get(idx)[1]);
			right(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearright(cctv.get(idx)[0], cctv.get(idx)[1]);
		}

		else if (cctv.get(idx)[2] == 2) {
			up(cctv.get(idx)[0], cctv.get(idx)[1]);
			down(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearup(cctv.get(idx)[0], cctv.get(idx)[1]);
			cleardown(cctv.get(idx)[0], cctv.get(idx)[1]);

			left(cctv.get(idx)[0], cctv.get(idx)[1]);
			right(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearleft(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearright(cctv.get(idx)[0], cctv.get(idx)[1]);
		}

		else if (cctv.get(idx)[2] == 4) {
			up(cctv.get(idx)[0], cctv.get(idx)[1]);
			left(cctv.get(idx)[0], cctv.get(idx)[1]);
			right(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearleft(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearright(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearup(cctv.get(idx)[0], cctv.get(idx)[1]);

			up(cctv.get(idx)[0], cctv.get(idx)[1]);
			right(cctv.get(idx)[0], cctv.get(idx)[1]);
			down(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearup(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearright(cctv.get(idx)[0], cctv.get(idx)[1]);
			cleardown(cctv.get(idx)[0], cctv.get(idx)[1]);

			right(cctv.get(idx)[0], cctv.get(idx)[1]);
			down(cctv.get(idx)[0], cctv.get(idx)[1]);
			left(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearright(cctv.get(idx)[0], cctv.get(idx)[1]);
			cleardown(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearleft(cctv.get(idx)[0], cctv.get(idx)[1]);

			down(cctv.get(idx)[0], cctv.get(idx)[1]);
			left(cctv.get(idx)[0], cctv.get(idx)[1]);
			up(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			cleardown(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearleft(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearup(cctv.get(idx)[0], cctv.get(idx)[1]);
		}

		else if (cctv.get(idx)[2] == 3) {
			up(cctv.get(idx)[0], cctv.get(idx)[1]);
			left(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearup(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearleft(cctv.get(idx)[0], cctv.get(idx)[1]);

			up(cctv.get(idx)[0], cctv.get(idx)[1]);
			right(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearup(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearright(cctv.get(idx)[0], cctv.get(idx)[1]);

			down(cctv.get(idx)[0], cctv.get(idx)[1]);
			left(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			cleardown(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearleft(cctv.get(idx)[0], cctv.get(idx)[1]);

			down(cctv.get(idx)[0], cctv.get(idx)[1]);
			right(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			cleardown(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearright(cctv.get(idx)[0], cctv.get(idx)[1]);
		} else {
			up(cctv.get(idx)[0], cctv.get(idx)[1]);
			left(cctv.get(idx)[0], cctv.get(idx)[1]);
			down(cctv.get(idx)[0], cctv.get(idx)[1]);
			right(cctv.get(idx)[0], cctv.get(idx)[1]);
			go(idx + 1);
			clearup(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearleft(cctv.get(idx)[0], cctv.get(idx)[1]);
			cleardown(cctv.get(idx)[0], cctv.get(idx)[1]);
			clearright(cctv.get(idx)[0], cctv.get(idx)[1]);
		}
	}

	public static int checkHide() {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cctv = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new int[] { i, j, map[i][j] });
				}
			}
		}
		ans = Integer.MAX_VALUE;
		go(0);
		System.out.println(ans);
		br.close();
	}

}
