package algo;
import java.util.*;
import java.io.*;

public class Solution_D4_수지의수지맞는여행 {
	static int r,c,ans;
	static int[][] map;
	static boolean[] visit;
	static int di[] = {0,1,0,-1}, dj[] = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			char[][] tmap = new char[r][c];
			map = new int[r][c];
			visit = new boolean[26];
			for (int i = 0; i < r; i++) {
				tmap[i] = br.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					map[i][j] = tmap[i][j] - '0' - 17;
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			visit[map[0][0]] = true;
			ans = 0;
			tour(0,0,1);
			System.out.println("#" + tc + " "+ans);
		}//tc 끝
	}// main 끝
	private static void tour(int x, int y,int cnt) {
		ans = Integer.max(ans, cnt);
		for (int i = 0; i < 4; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			if(nx>=0&&ny>=0&&nx<r&&ny<c
					&&!visit[map[nx][ny]]) {
				visit[map[nx][ny]] = true;
				tour(nx,ny,cnt+1);
				visit[map[nx][ny]] = false;
			}
		}
	}//tour 끝
}
