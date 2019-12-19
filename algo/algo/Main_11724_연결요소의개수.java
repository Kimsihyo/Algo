package algo;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11724_연결요소의개수 {
	public static int V;
	public static int E;
	public static int[][] arr;
	public static boolean[] ck;
	public static Queue<Integer> queue;
	public static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		queue = new LinkedList<Integer>();
		arr = new int[V + 1][V + 1];
		for (int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		// for(int[] a : arr){
		// System.out.println(Arrays.toString(a));
		// }
		ck = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			bfs(i);
		}
		System.out.print(cnt);
	}

	public static void bfs(int node) {
		ck[0] = true;
		if (ck[node] == false) {
			cnt++;
			queue.offer(node);
			while (!queue.isEmpty()) {
				int now = queue.poll();
				if (ck[now] == false) {
					ck[now] = true;
					// System.out.println(Arrays.toString(ck));
					for (int i = 1; i <= V; i++) {
						if (ck[i] == false && arr[now][i] == 1) {
							queue.offer(i);
						}

					}
				}

			}

		}

	}

}
