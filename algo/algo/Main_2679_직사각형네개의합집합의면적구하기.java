package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2679_직사각형네개의합집합의면적구하기 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] map = new int[100][100];
		int startx = 0;
		int starty = 0;
		int endx = 0;
		int endy = 0;
		for (int i = 0; i < 4; i++) {
			starty = sc.nextInt();
			startx = sc.nextInt();
			endy = sc.nextInt()-1;
			endx = sc.nextInt()-1;
			for (int j = startx; j <= endx; j++) {
				for (int j2 = starty; j2 <= endy; j2++) {
					map[j][j2] = 1;
				}
			}
		}
		int cnt=0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1) {
					cnt++;
				}
				
			}
		}
		System.out.println(cnt);
		
	}

}
