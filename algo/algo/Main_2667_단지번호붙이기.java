package algo;

import java.util.*;
 final class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Main_2667_단지번호붙이기 {
	
	static int n, cnt;
	static char[][] map ;
	static int[][]imap;
	static Queue<Pair> qq;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		map = new char[n][n];
		imap = new int[n][n];
		visit = new boolean[n][n];
		for(int i =0;i<n;i++) {
			String s = sc.nextLine();
			for(int j=0;j<n;j++) {
				char c = s.charAt(j);
				map[i][j] = c;
				imap[i][j] = c -'0';
			}
			//			System.out.println(Arrays.toString(map[i]));
		}
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(imap[i][j] == 1) {
					cnt++;
					bfs(cnt, i,j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(imap[i]));
		}
	}
	public static void bfs(int n, int ni,int nj){
		Queue<Pair> q = new LinkedList<Pair>();
		visit[ni][nj] = true;
		q.add(new Pair(ni,nj));
		if(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n && visit[nx][ny] == false && map[nx][ny] =='1' ) {
					imap[nx][ny] = n;
					bfs(n,nx,ny);
				}
			}
		}
		
		
	}
}
