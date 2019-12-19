package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {
	static int n, k, cnt;
	static boolean[] chk;
	static int[] load;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		q = new LinkedList<Integer>();
		load = new int[1000000];
		chk = new boolean[1000000];
		chk[n] = true;
		load[n] = 0;
		bfs(n);
		System.out.println(load[k]);
	}

	static void bfs(int x) {
		q.add(x);
		int cnt = 0;
		while (!q.isEmpty()) {
			int nx = q.poll();

			if (nx - 1 >= 0) {
				if (!chk[nx - 1]) {
					q.add(nx - 1);
					chk[nx - 1] = true;
					load[nx - 1] = load[nx] + 1;

				}
			}
			if (nx + 1 < k * 2) {
				if (!chk[nx + 1]) {
					q.add(nx + 1);
					chk[nx + 1] = true;
					load[nx + 1] = load[nx] + 1;
				}

			}
			if (nx * 2 < k * 2) {
				if (!chk[nx * 2]) {
					q.add(nx * 2);
					chk[nx * 2] = true;
					load[nx * 2] = load[nx] + 1;
				}
			}

		}

	}

}
