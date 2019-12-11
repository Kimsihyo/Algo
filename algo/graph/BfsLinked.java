package graph;

import java.io.*;
import java.util.*;

import graph.DfsLinked.Node;

public class BfsLinked {
	public static class Node{
		int data;
		Node link;
	}
	public static int V;
	public static int E;
	public static Node[] graph;
	public static boolean[] visit;
	public static Queue<Node> queue;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bfs.txt"));
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();//7
		E=sc.nextInt();//8
		graph=new Node[V];
		queue=new LinkedList<Node>();
		
		for(int i=0; i<E; i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			
			Node n1=new Node();
			n1.data=v2;
			if(graph[v1]==null) {
				n1.link=graph[v1];
				graph[v1]=n1;
			}else{
				Node t=graph[v1];
				while(t.link!=null) t=t.link;
				n1.link=t.link;
				t.link=n1;
			}
			
			Node n2=new Node();
			n2.data=v1;
			if(graph[v2]==null) {
				n2.link=graph[v2];
				graph[v2]=n2;
			}else{
				Node t=graph[v2];
				while(t.link!=null) t=t.link;
				n2.link=t.link;
				t.link=n2;
			}
		}
/*
0:->1->2
1:->0->3->4
2:->0->4
3:->1->5
4:->1->2->5
5:->3->4->6
6:->5
0 cnt=0
1 2 cnt=1
3 4 cnt=2
5 cnt=3
6 cnt=4
0 1 2 3 4 5 6

0:->2->1
1:->4->3->0
2:->4->0
3:->5->1
4:->5->2->1
5:->6->4->3
6:->5
0 cnt=0
2 1 cnt=1
4 3 cnt=2
5 cnt=3
6 cnt=4
0 2 1 4 3 5 6 
*/
		for(int i=0; i<V; i++) {
			System.out.print(i+":->");
			if(graph[i]!=null) {
				Node t=graph[i];
				while(t.link!=null){
					System.out.print(t.data+"->");
					t=t.link;
				}
				System.out.println(t.data);
			}
		}
		
		//bfs(0);
		bfs2(0);
		System.out.println();
	}
	public static void bfs2(int node){
		int cnt=0;
		visit=new boolean[V];
		visit[node]=true;
		Node n=new Node();
		n.data=node;
		queue.offer(n);
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0; i<size; i++) {
				Node curr=queue.poll();
				System.out.print(curr.data+" ");
				
				Node t=graph[curr.data];
				while(t.link!=null) {
					if(visit[t.data]==false) {
						visit[t.data]=true;
						queue.offer(t);
					}
					t=t.link;
				}
				if(visit[t.data]==false) {
					visit[t.data]=true;
					queue.offer(t);
				}
			}
			System.out.println("cnt="+cnt++);
		}
	}
	public static void bfs(int node){
		int cnt=0;
		visit=new boolean[V];
		Node n=new Node();
		n.data=node;
		queue.offer(n);
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0; i<size; i++) {
				Node curr=queue.poll();
				if(visit[curr.data]==false){
					visit[curr.data]=true;
					System.out.print(curr.data+" ");
					
					Node t=graph[curr.data];
					while(t.link!=null) {
						if(visit[t.data]==false) {
							queue.offer(t);
						}
						t=t.link;
					}
					if(visit[t.data]==false) {
						queue.offer(t);
					}
				}
			}
			System.out.println("cnt="+cnt++);
		}
	}
}



