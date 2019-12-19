package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_1260_DFSBFS {
	public static boolean[] visit;
	public static Stack<Integer> stack;
	public static int V;
	public static int E;
	public static int[][] arr;
	public static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); // 노드
		E = sc.nextInt(); // 간선
		arr = new int[V + 1][V + 1];
		int s = sc.nextInt(); // 시작
		stack = new Stack<Integer>();
		queue = new LinkedList<Integer>();
		visit = new boolean[V + 1];
		for (int i = 0; i < E; i++) {
			int input1 = sc.nextInt();
			int input2 = sc.nextInt();
			arr[input1][input2] = 1;
			arr[input2][input1] = 1;
		}
		// for (int[] a : arr)
		// System.out.println(Arrays.toString(a));
		// visit = new boolean[V];
		dfs(s);
		bfs(s);
		
	}

	public static void bfs(int node) {
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			if (visit[now] == false) {
				visit[now] = true;
				for (int i = 1; i <= V; i++) {
					if (visit[i] == false && arr[now][i] == 1) {
						if (!queue.contains(i)) {
							queue.offer(i);
						}

					}
				}
			}
		}
		System.out.println();

	}


	public static void dfs(int node) {
		stack.push(node);
		

		while (!stack.empty()) {
			int now = stack.pop();
			if (visit[now] == false) {
				visit[now] = true;
				System.out.print(now + " ");
				for (int i = V; i >= 1; i--) {
					if (visit[i] == false && arr[now][i] == 1) {
						stack.push(i);
					}
				}

			}
		}
		System.out.println();

	}

}
