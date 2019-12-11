package queue;
import java.io.*;
import java.util.*;
public class Bfs2 {
    public static int V;
    public static int E;
    public static int[][] graph;
    public static boolean[] visit;
    public static Queue<Integer> queue;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_dfs.txt"));
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 1; tc++) {
            V = sc.nextInt();
            E = sc.nextInt();
            graph = new int[V][V];
            queue = new LinkedList<Integer>();
            for (int i = 0; i < E; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                graph[v1][v2] = graph[v2][v1] = 1;
            }
        bfs(0);
            bfs2(0);
        }
    }
    public static void bfs(int node) {
        visit = new boolean[V];
        queue.offer(node);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visit[curr] == false) {
                visit[curr] = true;
                System.out.print(curr + " ");
                // 0 1 2 3 4 5 6
                for (int next = 0; next < V; next++) {
                    if (visit[next] == false && graph[curr][next] == 1)
                        queue.offer(next);
                }
            }
        }
    }
    public static void bfs2(int node) {
        int cnt = 0;
        visit = new boolean[V];
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (visit[curr] == false) {
                    visit[curr]=true;
                    System.out.print(curr + " ");
                    // 0 1 2 3 4 5 6
                    for (int next = 0; next < V; next++) {
                        if (visit[next] == false && graph[curr][next] == 1) {
                            queue.offer(next);
                        }
                    }
                }
            }
            System.out.println("cnt=" + cnt++);
        }
    }
}