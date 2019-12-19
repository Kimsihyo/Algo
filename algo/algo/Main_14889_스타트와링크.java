package algo;

import java.util.Scanner;

public class Main_14889_스타트와링크 {
	static int n,map[][],sum,ans,select,total,min;
	static boolean chk[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		chk =new boolean[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		select = n/2;
		sum =0;
		total = 0;
		ans =0;
		min = Integer.MAX_VALUE;
		perm(0,0);
		System.out.println(min);
		sc.close();
	}
	static void perm(int x, int cho) {
		if(select==cho) {
			dfs();
			return;
			
		}else {
			for (int i =x; i < n; i++) {
				if(!chk[i]) {
					chk[i] = true;
					cho++;
					perm(i,cho);
					chk[i] =false;
					cho--;
				}
			}
		}
	}
	
	static void dfs() {
		sum =0;
		total =0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(chk[i] && chk[j]) {
					sum += map[i][j];
				}
				if(!chk[i]&&!chk[j]) {
					total += map[i][j];
				}
			}
		
		}
		ans = Math.abs(sum-total);
//		System.out.println(ans);
		if(min > ans) {
			min = ans;
		}
	}
}
