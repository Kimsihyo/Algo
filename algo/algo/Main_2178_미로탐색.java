package algo;
/*


 * 단순한 bfs 0,0 부터 탐색하면서 1이고 미방문 한곳을 방문함 + 한칸 움직일 때마다 +1 증가해서 카운팅한다.
 * 
 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_2178_미로탐색 {
	public static Queue<Integer> que1;
	public static Queue<Integer> que2;
	public static int n;
	public static int m;
	public static int cnt;
	public static int[][] map;
	public static boolean[][] chk;

	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void bfs(int si, int sj) {

		que1.add(si);
		que2.add(sj);
		while (!que1.isEmpty() && !que2.isEmpty()) {
			si = que1.poll();
			sj = que2.poll();
			chk[si][sj] = true;

			for (int a = 0; a < 4; a++) {
				int ni = si + di[a];
				int nj = sj + dj[a];

				if (ni >= 0 && nj >= 0 && ni < n && nj < m && map[ni][nj] == 1 && chk[ni][nj] == false) {
					que1.add(ni);
					que2.add(nj);
					chk[ni][nj] = true;
					map[ni][nj] = map[si][sj]+1;
				}
			}

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 4
		m = sc.nextInt(); // 6
		map = new int[n][m];
		chk = new boolean[n][m];
		que1 = new LinkedList<>();
		que2 = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		System.out.println(map[n - 1][m - 1]);

	}
}
