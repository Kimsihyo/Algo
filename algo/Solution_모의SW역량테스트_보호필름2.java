import java.io.*;
import java.util.*;

public class Solution_모의SW역량테스트_보호필름2 {
	
	static int T, D, W, K;
	static int[][] map, tmap;
	static int min_cnt;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			tmap = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < map.length; i++) {
			 	System.arraycopy(map[i], 0, tmap[i], 0, map[i].length);
			 }
			
            if(check()) {
                System.out.println("#"+tc+" "+0);
            } else {
            	min_cnt = Integer.MAX_VALUE;
                for (int i = 1; i < D + 1; i++) {
                    arr = new int[i];
                    shoot(0, 0, i);
                }
                if (min_cnt == Integer.MAX_VALUE)
                    System.out.println("#" + tc + " " + 0);
                else
                    System.out.println("#" + tc + " " + min_cnt);

            }
			
			
		}//tc 끝
	}// main 끝
	static void shoot(int start, int count, int col) {
        if (count == col) {
            if (min_cnt > col) {
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < W; j++) {
                        tmap[arr[i]][j] = 0; // 0으로 바꾸는 경우
                    }
                }

                if (check()) { // 연속하는게 있으면
                	min_cnt = col;
                }
                
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < W; j++) {
                        tmap[arr[i]][j] = 1; // 1로 바꾸는 경우
                    }
                }
                if (check()) { // 연속하는게 있으면
                	min_cnt = col;
                }
                for (int i = 0; i < D; i++) {
                    for (int j = 0; j < W; j++) {
                        tmap[i][j] = map[i][j];
                    }
                }
             }
             return;
        }
        
        for (int i = start; i < D; i++) {
            arr[count] = i;
            shoot(i + 1, count + 1, col);
        }
 
    }
	
	
	static boolean check() {
		 
        int cntW = 0;
        for (int w = 0; w < W ; w++) { // 가로
            int cntD = 0;
            for (int d=0; d < D - 1; d++) {
                if (tmap[d][w] == tmap[d + 1][w])
                    cntD++;
                else
                    cntD = 0;
 
                if (cntD == K - 1) {
                    cntW++;
                    break;
                }
            }
        }
 
        if (cntW == W) {             
            return true;
        } else
            return false;
 
    }// check 끝 
}