package algo;
import java.io.*;
import java.util.*;

public class Main_14890_경사로 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int map[][] = new int[n][n];
		boolean[] col = new boolean[n];
		boolean[] row = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
h:		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n-1; j++) {
				if(j+1 < n && map[i][j] == map[i][j+1]) {
					cnt++;
				}else if(j+1 < n && map[i][j] == map[i][j+1]-1){
					for (int k = 0; k < l; k++) {
						if(j+k+1 < n && map[i][j]==map[i][j+k+1]-1) {
							cnt++;
						}else {
							continue h;
						}
					}
					j+=l-1;
				}else if(j+1 < n && map[i][j] == map[i][j+1]+1) {
					for (int k = 0; k < l; k++) {
						if(j+k+1 < n && map[i][j]==map[i][j+k+1]+1) {
							cnt++;
						}else {
							continue h;
						}
					}
					j+=l-1;
				}
			}
			if(cnt == n-1) {
				row[i] = true;
			}
		}
		
h1:		for (int j = 0; j < n; j++) {
			int cnt = 0;
			for (int i = 0; i < n-1; i++) {
				if(i+1 < n && map[i][j] == map[i+1][j]) {
					cnt++;
				}else if(i+1 < n && map[i][j] == map[i+1][j]-1){
					for (int k = 0; k < l; k++) {
						if(i+k+1 < n && map[i][j]==map[i+k+1][j]-1) {
							cnt++;
						}else {
							continue h1;
						}
					}
					i+=l-1;
				}else if(i+1 < n && map[i][j] == map[i+1][j]+1) {
					for (int k = 0; k < l; k++) {
						if(i+k+1 < n && map[i][j]==map[i+k+1][j]-1) {
							cnt++;
						}else {
							continue h1;
						}
					}
					i+=l-1;
				}
			}
			if(cnt == n-1) {
				col[j] = true;
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if(col[i]) {
				ans++;
			}
			if(row[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}//main 끝

}
