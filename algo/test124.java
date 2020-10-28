import java.util.*;
import java.io.*;

public class test124 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 열
		int m = sc.nextInt();// 행
		
		int[][] box = new int[m][n];// 상자
		
		Queue<int[]> tomato = new LinkedList<>();
		
		int answer = 0; //날짜 입력
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j] == 1) {
					tomato.add(new int[] {i,j});
				}
			}
		}//end loop
		
		int[] di = {0,0,1,-1}; int[] dj = {1,-1,0,0}; // 사방 탐색
		
		while(!tomato.isEmpty()) {
			int[] temp = tomato.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + di[i];
				int ny = y + dj[i];
				if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if(box[nx][ny] == 0) {
						box[nx][ny] = box[x][y] + 1;
						tomato.add(new int[] {nx,ny});
					}
				}
				
			}
			
		}
		
		//익었는지 체크하자
		boolean chk = true;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(box[i][j] == 0) {
					chk = false;
				}
			}
		}
		//안익은게 있다면!!
		if(!chk) {
			System.out.println(-1);
		}
		
		//다 익었다면!!
		else {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					answer = Math.max(answer, box[i][j]);
				}
			}
			System.out.println(answer - 1);
		}
	}
}
