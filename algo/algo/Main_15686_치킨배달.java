package algo;
/*
 	1. 음 .. 치킨가게, 집 위치 받음
 	2. 순열로 치킨가게 선택
 	3. 각 집의 거리 체크
 	4. 최소값 저장
 */

import java.util.*;

public class Main_15686_치킨배달 {
	static int n,m,min,ans,real_ans,bsize,hsize;
	static ArrayList<int []> bbq, home;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();// 맵 크기
		m = sc.nextInt();// 최대 치킨집 
		
		bbq = new ArrayList<int[]>(); // 치킨집 
		home = new ArrayList<int[]>(); // 집
		min = Integer.MAX_VALUE;
		real_ans = Integer.MAX_VALUE;
		ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int number = sc.nextInt();
				if(number == 1) {
					home.add(new int[] {i,j,min});
				}
				else if(number == 2) {
					bbq.add(new int[] {i,j});
				}
			}
		}
		bsize = bbq.size();
		hsize = home.size();
		chk = new boolean[bbq.size()];
		perm(0,0);
		System.out.println(real_ans);
		
	}
	// 한번 가봤던 집의 거리를 저장해주면 시간 줄어들듯 ;;
	static void perm(int step, int idx) {
		if(step == m) {
			for (int i = 0; i < bsize; i++) {
				if(chk[i]) {
					int[] arr = bbq.get(i);					
					distance(arr[0], arr[1]);
				}
			}
			ans = 0;
			for (int i = 0; i < hsize; i++) {
				int arr[] = home.remove(0);
				ans += arr[2];
				home.add(new int[] {arr[0], arr[1], min});
			}
			if(ans < real_ans) {
				real_ans = ans;
			}
			return;
		}
		for (int i = idx; i < bsize; i++) {
			if(!chk[i]) {
				chk[i] = true;
				perm(step+1, i+1);
				chk[i] = false;
			}
		}
	}
	static  void distance(int x, int y) {
		
		for (int i = 0; i < hsize; i++) {
			int[] arr = home.remove(0);
			int hx = arr[0];
			int hy = arr[1];
			int dis = Math.abs(hx-x) + Math.abs(hy-y);
			if(dis < arr[2]) {
				home.add(new int[] {hx,hy,dis});
			}else {
				home.add(new int[] {hx,hy,arr[2]});
			}
		}
	}
}
