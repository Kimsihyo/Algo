package blog;

import java.io.*;
import java.util.*;

public class Main_1260_dfsbfs {
	static int di[] = {-1,1,0,0} , dj[] = {0,0,-1,1},map[][],n,m,v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       m = sc.nextInt();
       v = sc.nextInt();
       map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
		}
        
        dfs();
    }
	static void dfs() {
		
		dfs()
	}
}
