package algo;
import java.util.*;

public class Solution_모의SW역량테스트_홈방범서비스 {
	static int n,m,map[][],safe,smap[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			
			m = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 방범 서비스를 키워 보자
			// 집이 1개면 비용은 m*1 > k*k + (k-1)*(k-1) 최대 이어야함
			// 방범 서비스 범위안에 집이 몇갠지 어떻게 카운트하냐 ...
			safe = 1; // 
			while(true) {
				int safe_range = (safe * safe) + ((safe - 1)*(safe - 1));
				range();
				
				
				
				
			}
			
			
			
			
			
		}//tc 끝
	} //main 끝
	static void range() {
		smap = new int[(safe*2)-1][(safe*2)-1];
		for (int i = 0; i < (safe*2)-1; i++) {
			for (int j = 0; j < (safe*2)-1; j++) {
				if(i==0) {
					smap[i][safe] = 1; 
				}
			}
		}
	}
}
