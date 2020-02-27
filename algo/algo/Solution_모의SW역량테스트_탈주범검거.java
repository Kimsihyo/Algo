package algo;
import java.util.*;

public class Solution_모의SW역량테스트_탈주범검거 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int start_x = sc.nextInt();
			int start_y = sc.nextInt();
			int l = sc.nextInt();
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][] visit = new boolean[n][m];
			q.add(new int[] {start_x,start_y,1});
			//상하좌우 주어진 터널 종류 
			int[][] tunnel_di = {{},{-1,1,0,0},{-1,1,0,0},{0,0,0,0},{-1,0,0,0},{0,1,0,0},{0,1,0,0},{-1,0,0,0}};
			int[][] tunnel_dj = {{},{0,0,-1,1},{0,0,0,0},{0,0,-1,1},{0,0,0,1},{0,0,0,1},{0,0,-1,0},{0,0,-1,0}};
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			//돌면서 터널이 연결되는지 확인해야함 .. ㅠㅠ 
			while(!q.isEmpty()) {
				int[] temp = q.remove();
				int x = temp[0];
				int y = temp[1];
				int cnt = temp[2];
				if(cnt > l) break;
				
				visit[x][y] = true;
				int tunnel_type = map[x][y];// 몇 번 터널이 있는지 확인하자 

				for (int i = 0; i < 4; i++) {
					int nx = x + tunnel_di[tunnel_type][i];
					int ny = y + tunnel_dj[tunnel_type][i];
					if(nx >=0 && ny >= 0 && nx < n && ny < m && map[nx][ny]!=0 && !visit[nx][ny]) {
						
						if(map[x][y] == 2 && i == 0 // 2번 파이프  위로 올라갈 수 있냐 ?
								&& (map[nx][ny]==1||map[nx][ny]==2||map[nx][ny]==5||map[nx][ny]==6)) {
							cnt++;							
							q.add(new int[] {nx,ny,cnt});
							cnt--;
							
						}else if(map[x][y] == 2 && i == 1 // 2번 파이프 아래로 갈 수 있냐 ?
								&& (map[nx][ny]==2||map[nx][ny]==1||map[nx][ny]==4||map[nx][ny]==7)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
							
						}
						
						if(map[x][y] == 3 && i == 2 // 3번 파이프 좌 방향
								&& (map[nx][ny]==1||map[nx][ny]==3||map[nx][ny]==4||map[nx][ny]==5)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}else if(map[x][y] == 3 && i == 3 // 3번 파이프 우 방향
								&& (map[nx][ny]==1||map[nx][ny]==3||map[nx][ny]==6||map[nx][ny]==7)){
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}
						
						if(map[x][y] == 4 && i==0 // 4번 파이프 위 방향
								&& (map[nx][ny]==1||map[nx][ny]==2||map[nx][ny]==5||map[nx][ny]==6)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}else if(map[x][y] == 4 && i==3 // 4번 파이프 우
								&& (map[nx][ny]==1||map[nx][ny]==3||map[nx][ny]==6||map[nx][ny]==7)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}
						
						if(map[x][y] == 5 && i == 1// 5번 파이프 하
								&& (map[nx][ny]==2||map[nx][ny]==1||map[nx][ny]==4||map[nx][ny]==7)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}else if(map[x][y] == 5 && i == 3// 5번 파이프 우
								&& (map[nx][ny]==1||map[nx][ny]==3||map[nx][ny]==6||map[nx][ny]==7)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}
						
						if(map[x][y] == 6 && i == 1// 6번 파이프 하
						&& (map[nx][ny]==1||map[nx][ny]==2||map[nx][ny]==4||map[nx][ny]==7)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}else if(map[x][y] == 6 && i == 2// 6번 파이프 좌
								&& (map[nx][ny]==1||map[nx][ny]==3||map[nx][ny]==4||map[nx][ny]==5)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}
						
						if(map[x][y] == 7 &&  i==0 
								&&(map[nx][ny]==1||map[nx][ny]==2||map[nx][ny]==5||map[nx][ny]==6)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}else if(map[x][y] == 7 &&  i==2
								&&(map[nx][ny]==1||map[nx][ny]==3||map[nx][ny]==4||map[nx][ny]==5)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}
						if(map[x][y] == 1&& i==0
								&& (map[nx][ny]==1||map[nx][ny]==2||map[nx][ny]==5||map[nx][ny]==6)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}else if(map[x][y] == 1&& i==1
								&& (map[nx][ny]==2||map[nx][ny]==1||map[nx][ny]==4||map[nx][ny]==7)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}else if(map[x][y] == 1&& i==2
								&& (map[nx][ny]==1||map[nx][ny]==3||map[nx][ny]==4||map[nx][ny]==5)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}else if(map[x][y] == 1&& i==3
								&& (map[nx][ny]==1||map[nx][ny]==3||map[nx][ny]==6||map[nx][ny]==7)) {
							cnt++;
							q.add(new int[] {nx,ny,cnt});
							cnt--;
						}
						
					}
				}
			
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(visit[i][j])ans++;
				}
			}
			System.out.println("#"+tc+" "+ ans);
		}//tc끝
	}
}
