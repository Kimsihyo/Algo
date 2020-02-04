
import java.util.*;
import java.io.*;

public class Main {
	static int node, e, graph[][];
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		node = sc.nextInt();
		e = sc.nextInt();
		graph = new int[node][e];
		boolean[] visit = new boolean[node];
		
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}
		
		dfs(0);
	}
	static void dfs(int node) {
		
	}
}
