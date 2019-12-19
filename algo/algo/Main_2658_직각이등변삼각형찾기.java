package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_2658_직각이등변삼각형찾기 {
	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[10][10];
		boolean chk = false;
		char[] c = new char[10];
		ArrayList<Pair> list_col = new ArrayList<Pair>();
		ArrayList<Pair> list_row = new ArrayList<Pair>();

		for (int i = 0; i < 10; i++) {
			c = sc.nextLine().toCharArray();
			for (int j = 0; j < 10; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		// col을 체크
		int lastI = -1;
		for (int j = 0; j < 10; j++) {
			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				if (map[i][j] == 1) {
					cnt += map[i][j];
					lastI = i;
				}
			}
			if (cnt == 1)
				list_col.add(new Pair(lastI, j));
		}
		// row 체크
		int lastJ = -1;
		for (int i = 0; i < 10; i++) {
			int cnt = 0;
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					cnt += map[i][j];
					lastJ = j;
				}
			}
			if (cnt == 1) {
				list_row.add(new Pair(i, lastJ));
			}
		}
		// 밑변이 가로인지 세로인지
		// row가 밑변이면
		if (list_row.size() == 2) {
			Pair p = list_row.remove(0);
			int firstrow_x = p.x + 1;
			int firstrow_y = p.y + 1;
			Pair p2 = list_row.remove(0);
			int secondrow_x = p2.x + 1;
			int secondrow_y = p2.y + 1;
			int row_size = Math.abs(firstrow_x-secondrow_x)+1;
			
			//사이즈가 홀수여야함
			if((row_size)%2 == 1) {
				Pair pp = list_col.remove(0);
				int firstcol_x = pp.x + 1;
				int firstcol_y = pp.y + 1;
				
				if(firstcol_x ==(row_size/2)+firstrow_x) {
					System.out.println(firstrow_x + " " + firstrow_y);
					System.out.println(firstcol_x + " " + firstcol_y);
					System.out.println(secondrow_x + " " + secondrow_y);
				}
			}else {
				System.out.println("0");
			}
		}
	}

}
