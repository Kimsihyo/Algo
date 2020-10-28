import java.util.*;
import java.io.*;

public class Main_17142_연구소3 {
	static int[]dy= {-1,1,0,0};
	static int[]dx = {0,0,-1,1};
	static int n,m;
	static int [][]map;
	static int [][]copy;
	static boolean [][]visit;
	static int ans;
	static int viruscnt;
	static Point[] virus;
	static boolean[]select;
	static Queue<Point>q;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		virus = new Point[10];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					virus[viruscnt++] = new Point(i,j);
				}
			}
		}
		ans =Integer.MAX_VALUE;
		select = new boolean[viruscnt];
		combi(0,0);
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
	
	static void combi(int idx, int cnt) {
		if(cnt == m) {
			q = new LinkedList<Point>();
			visit = new boolean[n][n];
			for (int i = 0; i < viruscnt; i++) {
				if(select[i]) {
					q.offer(virus[i]);
					visit[virus[i].i][virus[i].j] = true;
				}
			}
			deepcopy();
			bfs();
			return;
		}
		for (int i = idx; i < viruscnt; i++) {
			select[i] = true;
			combi(i+1,cnt+1);				
			select[i] = false;
		}
	}
	static void bfs() {
		int time=0;
		while(!q.isEmpty()) {
			if(check()) {
				if(ans > time)
					ans = time;
				break;
			}
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point now = q.poll();
				for (int d = 0; d < 4; d++) {
					int ni = now.i + dy[d];
					int nj = now.j + dx[d];
					
					if(ni>=0 && nj>=0 && ni<n && nj<n &&
							!visit[ni][nj]&& copy[ni][nj]!=1) {
						visit[ni][nj] = true;
						q.offer(new Point(ni,nj));
					}
				}
			}
			time++;
		}
	}
	static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(copy[i][j] == 0 && !visit[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	static void deepcopy() {
		copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	static class Point {
		int i;
		int j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}