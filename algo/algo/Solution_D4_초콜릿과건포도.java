package algo;
import java.io.*;
import java.util.*;



public class Solution_D4_초콜릿과건포도 {
	static int result;
	static int n,m;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int m = sc.nextInt();
			int n =sc.nextInt();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			result = dfs(0,0,0,0,Integer.MAX_VALUE);
			System.out.println("#"+tc+" "+result);
		}//tc 끝
	}
	static int dfs(int y, int x, int h, int w,int min) {
		//end
		if(w==1&&h==1) {
			return 0;
		}
		//run
		//기존에 있던 덩어리의 건포도 개수
		int sum =0;
		for (int i = y; i < y+h; i++) {
			for (int j = x; j < x+w; j++) {
				sum+=map[i][j];
			}
		}
		//가로로 나누어서 비용을 최소비용으로 구한다.
		for (int i = 1; i < h; i++) {
			//위 비용
			int sum1 = dfs(y,x,i,w,min);
			//아래 비용
			int sum2 = dfs(y+i,x,h-i,w,min);
			int sum3 = sum + sum1 +sum2;
			min = Math.min(min, sum3);
		}
		//세로로 나누어서 비용을 최소비용을 구한다.
		for (int i = 0; i < w; i++) {
			//왼쪽 비용
			int sum1 = dfs(y,x,h,i,min);
			//오른쪽 비용
			int sum2 = dfs(y,x+i,h,w-i,min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		return result;
	}
}
