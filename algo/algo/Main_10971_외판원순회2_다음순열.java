package algo;

import java.util.Scanner;

public class Main_10971_외판원순회2_다음순열 {
	public static boolean perm(int[] a) {
		int i = a.length-1;
		while(i > 0 && a[i] <= a[i-1]) {
			i-=1;
		}
		if(i <=0) {
			return false;
		}
		int j = a.length-1;
		while(a[j] < a[i-1]) {
			j-=1;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		int[] a = new int[n];
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i<n;i++) {
			a[i] = i;
		}
		int min = Integer.MAX_VALUE;
		do{
			if(a[0]==0) {
				int sum = 0;
				boolean chk = true;
				for(int i = 0; i<n-1;i++) {
					if(map[a[i]][a[i+1]]==0) {
						chk = false;
					}else {
						sum += map[a[i]][a[i+1]];
					}
				}
				if(chk && map[a[n-1]][a[0]] != 0) {
					sum += map[a[n-1]][a[0]];
					if(min > sum) {
						min = sum;
					}
				}
			}
			else {
				break;
			}
			
		}while(perm(a));
		System.out.println(min);
	}

}
