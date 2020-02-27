package algo;
import java.util.*;

/*
    3
	2 2 2
	4 4 4
	8 8 8
 */
public class Main_2048 {
	static int di[] = { -1, 1, 0, 0 }, dj[] = { 0, 0, -1, 1 }, max, n, tmap[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] map = new int[n][n];
		tmap = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				tmap[i][j] = map[i][j];
			}
		}
		
		//up
		up();up();up();up();up();
		up();up();up();up();down();

		
		
		
	}
	
	static void up() {
		//같으면 합쳐
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n; j++) {
				if(tmap[i][j] == tmap[i+1][j] && tmap[i][j] != 0) { 
					tmap[i][j] += tmap[i+1][j];
					tmap[i+1][j] = 0;
				}
			}
		}
		//이동하고 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(tmap[i][j]==0) {
					for (int k = i; k < n; k++) {
						if(tmap[k][j] != 0) {
							tmap[i][j] = tmap[k][j];
							tmap[k][j] = 0;
							i = k;
							break;
						}
					}
				}
			}
		}
	}
	static void down() {
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < n; j++) {
				if(tmap[i][j] == tmap[i-1][j] && tmap[i][j] != 0) { 
					tmap[i][j] += tmap[i-1][j];
					tmap[i-1][j] = 0;
				}
			}
		}
		//이동하고 
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < n; j++) {
				if(tmap[i][j]==0) {
					for (int k = i-1; k > 0; k--) {
						if(tmap[k][j] != 0) {
							tmap[i][j] = tmap[k][j];
							tmap[k][j] = 0;
							i = k;
							break;
						}
					}
				}
			}
		}
	}
	static void right() {
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j > 0; j--) {
				if(tmap[i][j] == tmap[i][j-1] && tmap[i][j] != 0) { 
					tmap[i][j] += tmap[i][j-1];
					tmap[i][j-1] = 0;
				}
			}
		}
		//이동하고 
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j > 0; j--) {
				if(tmap[i][j]==0) {
					for (int k = j-1; k > 0; k--) {
						if(tmap[i][k] != 0) {
							tmap[i][j] = tmap[i][k];
							tmap[i][k] = 0;
							j=k;
							break;
						}
					}
				}
			}
		}
	}
}