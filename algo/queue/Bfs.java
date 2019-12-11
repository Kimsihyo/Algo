   package queue;

import java.io.FileInputStream;
import java.util.*;

public class Bfs {
	public static int V;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;
	public static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input_bfs.txt"));
		Scanner sc = new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		graph=new int[V][V];
		//visit=new boolean[V];
		queue=new LinkedList<Integer>();
		
		for(int i=0; i<E; i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			graph[v1][v2]=graph[v2][v1]=1;
		}
		for(int[] a:graph) System.out.println(Arrays.toString(a));
		bfs(0);
	}

	private static void bfs(int node) {
		visit=new boolean[V];
		
		queue.offer(node);
		while(!queue.isEmpty()) {
			int curr=queue.poll();
			if(visit[curr]==false) {
				visit[curr]=true;
				System.out.println(curr+" ");
				
				for(int next=0; next<V; next++) {
					if(visit[next]==false && graph[curr][next]==1) {
						queue.offer(next);
					}
				}
			}
		}
	}
	

	}


