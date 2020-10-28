import java.util.*;
import java.io.*;

public class test123 {

	static int[][] map;
	static int n,m;
	static boolean[][] visit;
	static Queue<int[][]> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
        visit = new boolean[n][m];
		q = new LinkedList<int[][]>();
		int total = n*m;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					total--;
				}
				if(map[i][j] == 2) {
					q.add(new int[i][j]);
				}
			}
		}// end loop
		
		build(0);

		
	}
	//벽 세우기 
	static void build(int buildWallCnt) {
		if(buildWallCnt ==3) {
			//바이러스 퐝퐝
			
			
			return ;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					buildWallCnt++;
				}
			}
		}
		
	}
}
