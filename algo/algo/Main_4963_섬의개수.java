package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4963_섬의개수 {
	static int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static Queue<Integer> que;
	static boolean[][] chk;
	static int cnt;
	static int[][] map;
	static int h, w;

	public static void bfs(int i, int j) {
		
		que.offer(map[i][j]);
		chk[i][j] = true;
		if (!que.isEmpty()) {
			que.poll();
			for(int a =0; a<8;a++){
				int ni= i + di[a];
				int nj= j + dj[a];
				if(ni>=0 && nj>=0 && ni< h && nj< w && chk[ni][nj] == false && map[ni][nj] == 1){
					bfs(ni,nj);
				}
				
			}
			
		}
		
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			w = sc.nextInt();
			h = sc.nextInt();
			map = new int[h][w];
			chk = new boolean[h][w];
			que = new LinkedList<>();
			cnt = 0;
			if(w==0 && h==0) {
				break;
			}
			else{
				
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						map[i][j] = sc.nextInt();
					}
				}
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (map[i][j] == 1 && chk[i][j] == false){
							bfs(i, j);
							cnt++;
						}
					}
				}
				System.out.println(cnt);
				
			}
		}
	}

}
