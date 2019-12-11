
import java.io.*;
import java.util.*;

public class Dfs {
	public static int V;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		graph=new int[V][V];
		visit=new boolean[V];
		
		for(int i=0; i<E; i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			graph[v1][v2]=graph[v2][v1]=1;
		}
//		for(int[] a:graph) System.out.println(Arrays.toString(a));
		dfs(0);
	}

	
	private static void dfs(int node) {
		visit[node]=true;
		System.out.print(node+" ");
				for(int next=0; next<V; next++) {
					if(visit[next]==false && graph[node][next]==1) {
						dfs(next);
					}
				}
			
		}
	}


