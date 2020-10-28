package 이론.stack2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MazeDfs3 {
	public static int[][] maze;                    
	//좌,우,상,하
	public static int[] di={ 0,0,-1,1};
	public static int[] dj={-1,1, 0,0};

	public static int N=100;
	public static int[][] visit;
	public static Stack<int[]> stack;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_D4_1227_미로2.txt"));
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			stack=new Stack<int[]>();
			visit=new int[N][N];
			maze=new int[N][N];
			int T=sc.nextInt();
			for(int i=0; i<N; i++) {
				String s=sc.next();
				for(int j=0; j<N; j++) {
					maze[i][j]=s.charAt(j)-'0';
				}
			}
			System.out.println("#"+tc+" "+dfsr(1,1,0));
			//System.out.println("#"+tc+" "+dfs(1,1,0));
		}
	}
	public static int dfsr(int i,int j,int cnt) {
		visit[i][j]=1;
		if(maze[i][j]==3) {
			//System.out.println("i="+i+", j="+j+", cnt="+cnt);
			return 1;
		}
		
		for(int d=0; d<di.length; d++){
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && maze[ni][nj]!=1 && visit[ni][nj]==0) {
				if(dfsr(ni,nj,cnt+1)==1) return 1;
			}
		}
		return 0;
	}
	public static int dfs(int i,int j,int cnt){
		stack.push(new int[]{i,j,cnt});
		while(!stack.empty()){
			int[] curr=stack.pop();
			i=curr[0];
			j=curr[1];
			cnt=curr[2];
			if(visit[i][j]!=1){
				visit[i][j]=1;
				if(maze[i][j]==3) {
					//System.out.println("i="+i+", j="+j+", cnt="+cnt);
					return 1;
				}
				
				for(int d=0; d<di.length; d++){
					int ni=i+di[d];
					int nj=j+dj[d];
					if(0<=ni&&ni<N && 0<=nj&&nj<N && maze[ni][nj]!=1 && visit[ni][nj]==0){
						stack.push(new int[]{ni,nj,cnt+1});
					}
				}
			}
		}
		return 0;
	}
}



