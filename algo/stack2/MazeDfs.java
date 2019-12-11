package stack2;

import java.util.Arrays;
import java.util.Stack;

public class MazeDfs {
	public static int[][] maze= {
		{0,0,1,1,1,1,1,1},	
		{1,0,0,0,0,0,0,1},	
		{1,1,1,0,1,1,1,1},	
		{1,1,1,0,1,1,1,1},	
		{1,0,0,0,0,0,0,1},	
		{1,0,1,1,1,1,1,1},	
		{1,0,0,0,0,0,0,0},	
		{1,1,1,1,1,1,1,0}	
	};                    
	//좌,우,상,하
	public static int[] di={ 0,0,-1,1};
	public static int[] dj={-1,1, 0,0};

	public static int N=maze.length;//8
	public static int cnt=0;
	public static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception{
		cnt=0;
		stack=new Stack<Integer>();
		
		maze[0][0]=-1;
		//dfsr(0,0);
		dfs(0,0);
		
		System.out.println();
		for(int[] a:maze) System.out.println(Arrays.toString(a));
	}
	public static void dfsr(int i,int j) {
		//maze[i][j]=--cnt;
		//System.out.println();
		//for(int[] a:maze) System.out.println(Arrays.toString(a));
		if(i==N-1 && j==N-1) {
			System.out.println(maze[i][j]*-1);
			return;
		}
		
		for(int d=0; d<di.length; d++){
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && maze[ni][nj]==0) {
				maze[ni][nj]=maze[i][j]-1;
				dfsr(ni,nj);
			}
		}
	}
	public static void dfs(int i,int j){
		stack.push(i*N+j);
		while(!stack.empty()){
			int curr=stack.pop();
			i=curr/N;
			j=curr%N;
			if(maze[i][j]<=0){
			//if(maze[i][j]==0){
				//maze[i][j]=--cnt;
				//System.out.println();
				//for(int[] a:maze) System.out.println(Arrays.toString(a));
				if(i==N-1 && j==N-1) {
					System.out.println(maze[i][j]*-1+"?");
					return;
				}
				
				for(int d=0; d<di.length; d++){
					int ni=i+di[d];
					int nj=j+dj[d];
					if(0<=ni&&ni<N && 0<=nj&&nj<N && maze[ni][nj]==0){
						maze[ni][nj]=maze[i][j]-1;
						stack.push(ni*N+nj);
					}
				}
			}
		}
	}
}



