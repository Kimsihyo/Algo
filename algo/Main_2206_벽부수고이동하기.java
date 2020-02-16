import java.io.*;
import java.util.*;


public class Main_2206_벽부수고이동하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()) ;
		int m = Integer.parseInt(st.nextToken()) ;
		char[][] tmap = new char[n][m];
		int[][] map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			tmap[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmap[i][j] - '0';
			}
		}
		
		//map이 1이면  부셔보고 탐색 .. 
		
	}

}
