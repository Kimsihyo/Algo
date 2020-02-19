import java.util.*;
import java.io.*;

public class Solution_모의SW역량테스트_보호필름 {
	static int D,W,K,map[][],tmap[][],ans,arr[],arr2[];
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//검사 
		//안되면 각 막에 약품 투입 후 검사
		//안되면 조합으로 2개 막을 골라 검사
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			arr = new int[D];
			K = sc.nextInt();
			map = new int[D][W];
			tmap = new int[D][W];
			ans = -1;
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < D; i++) {
				arr[i] = i+1;
			}
			chk = new boolean[D];
			for (int i = 0; i <= 2; i++) {// 약품 투입

				if(i==0) {
					for (int k = 0; k < map.length; k++) {
					 	System.arraycopy(map[k], 0, tmap[k], 0, map[k].length);
					 }					
					if(check()) {
						ans = 0;
					}
				}else {
					arr2 = new int[i];
					shoot(i,0,0);
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}//tc끝
	}//main 끝
	
	static boolean check() {
		int all_cnt = 0;
		for (int i = 0; i < W; i++) {
			int cnt = 1;//각 열마다 초기화 해줘야함
			for (int j = 0; j < D; j++) {
				if(cnt==K) {
					all_cnt++;
					break; // 세로방향으로 K번 연속된 특성을 갖는다면 ok 
				}
				
				if(j+1 == D)break;
				if(tmap[j][i] == tmap[j+1][i]) {
					cnt++;
				}else {
					cnt = 1;
				}
			}
		}
		if(all_cnt == W) {
			return true;
		}else {
			return false;
		}
	}//check 끝
	
	static void shoot(int shoot_cnt, int step,int idx) {
		if(ans != -1) {
			return;
		}
		if(shoot_cnt == step) {
			//카피
			for (int i = 0; i < map.length; i++) {
			 	System.arraycopy(map[i], 0, tmap[i], 0, map[i].length);
			 }
			int cnt = 0;
			while(cnt < step) {
				for (int i = 0; i < W; i++) {
					tmap[arr2[cnt]][i] = 0;
				}
			}
			
			return;
		}
			

		
		//어느 셀에 주입할지 고르고 
		for (int i = idx; i < D; i++) {
			arr2[step] = arr[i];
			shoot(shoot_cnt, step+1,i+1);
		}
		
	}//shoot 끝
	
	
}
