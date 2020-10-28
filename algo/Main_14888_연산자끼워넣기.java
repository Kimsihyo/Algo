import java.util.*;
import java.io.*;
public class Main_14888_연산자끼워넣기 {
	static int n, max, min;
	static int[] number , cal2, cal;
	static boolean[] chk;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE ;
		min = Integer.MAX_VALUE;
		number = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		cal = new int[4];
		int size = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
			size += cal[i];
		}
		// n-1 개를 순열로고르는 경우
		cal2 = new int[size];
		for (int i = 0; i < size; i++) {
			if(i <= cal[0]-1) {
				cal2[i] = 1;
			}
			else if(i <= cal[0] + cal[1] -1) {
				cal2[i] = 2;
			}
			else if( i <= cal[0] + cal[1] + cal[2] -1) {
				cal2[i] = 3;
			}
			else if(i <= cal[0] + cal[1] + cal[2] + cal[3] -1) {
				cal2[i] = 4;
			}
		}
		chk = new boolean[size];
		cal = new int[n-1];
		perm(0,0);
		System.out.println(max);
		System.out.println(min);
		br.close();
	}//main end
	
	static void perm(int cnt, int idx) {
		if(cnt == n-1) {
			int temp = number[0];
			for (int i = 0; i < n-1; i++) {
				if(cal[i] == 1) {
					temp = temp + number[i+1];
				}
				else if(cal[i] == 2) {
					temp = temp - number[i+1];
				}
				else if(cal[i] == 3) {
					temp *= number[i+1];
				}
				else if(cal[i] == 4) {
					temp /= number[i+1];
				}
				
			}
			max = Math.max(max, temp);
			min = Math.min(min, temp);
			return;
		}
		else {
			for (int i = 0; i < n-1; i++) {
				if(!chk[i]) {
					chk[i] = true;
					cal[cnt] = cal2[i];
					perm(cnt+1,idx+1);
					chk[i] = false;
				}
			}
		}
	}

}
