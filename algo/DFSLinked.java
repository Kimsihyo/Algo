
import java.io.*;
import java.util.*;

public class DFSLinked {
	
	public static class Node{
		int data;
		Node link;
		Node(){}
		Node(int data){
			this(data,null);
		}
		Node(int data, Node link){
			this.data=data;
			this.link=link;
		}
	}
	public static int V;
	public static int E;
	public static Node[] graph;
	public static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();//7
		E=sc.nextInt();//8
		graph=new Node[V];
		
		for(int i=0; i<E; i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			
			Node n1=new Node();
			n1.data=v2;
				n1.link=graph[v1];
				graph[v1]=n1;
			
			Node n2=new Node();
			n2.data=v1;
				n2.link=graph[v2];
				graph[v2]=n2;
		}

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
		
		System.out.println();
		
	}
	public static void dfsr(int node) {
		visit[node]=true;
		System.out.print(node+" ");		
		
		Node t=graph[node];
		while(t.link!=null) {
			if(visit[t.data]==false) {
				dfsr(t.data);
			}
			t=t.link;
		}
		if(visit[t.data]==false) {
			dfsr(t.data);
		}
	}
	
}



