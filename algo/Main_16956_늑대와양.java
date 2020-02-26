import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_16956_늑대와양 {
	static int R, C;
	static char[][] map;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static List<Info> list;
	static boolean flag;

	static class Info {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}

	static void solve() {
		// wolf들 4방향 주변에 sheep이 있다면 무조건 잡아먹힘
		// 없다면 wolf 주변에 울타리를 쳐 sheep를 못먹게 할 수 있음
		for (int i = 0; i < list.size(); i++) {
			Info wolf = list.get(i);
			for (int d = 0; d < 4; d++) {
				int nextR = wolf.r + dir[d][0];
				int nextC = wolf.c + dir[d][1];

				if (isRange(nextR, nextC)) {
					if (map[nextR][nextC] == 'S') {
						flag = true;
					} else if (map[nextR][nextC] == '.') {
						map[nextR][nextC] = 'D';
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				// WOlf들 리스트에 저장
				if (map[i][j] == 'W') {
					list.add(new Info(i, j));
				}
			}
		}

		flag = false;
		solve();

		if (flag) {
			System.out.println(0);
		} else {
			System.out.println(1);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
