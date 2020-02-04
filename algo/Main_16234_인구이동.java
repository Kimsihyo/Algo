import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main_16234_인구이동 {
	static int di[] = {1,0,0,-1}, dj[] = {0,1,-1,0};// 하 우 좌 상
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<int[]> q2 = new LinkedList<int[]>();
		int ans = 0;
		while(true) {
			boolean[][] visit = new boolean[N][N];
			boolean chk = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						q.add(new int[] {i,j});
						q2.add(new int[] {i,j});
						visit[i][j] = true;
						int sum = map[i][j];
						int cnt = 0;
						while(!q.isEmpty()) {
							int temp[] = q.remove();
							int x = temp[0];
							int y = temp[1];
							cnt++;
							for (int k = 0; k < 4; k++) {
								int nx = x + di[k];
								int ny = y + dj[k];
								if(nx>=0 && ny >= 0 && nx < N && ny <N
										&&!visit[nx][ny] 
											&& Math.abs(map[x][y] - map[nx][ny]) >= L 
												&& Math.abs(map[x][y] - map[nx][ny]) <= R) {
									visit[nx][ny] = true;
									q.add(new int[] {nx,ny});
									q2.add(new int[] {nx,ny});
									sum += map[nx][ny];
									chk = true;
								}
							}
						}
						
						while(!q2.isEmpty()) {
							int temp[] = q2.remove();
							map[temp[0]][temp[1]] = sum/cnt;
						}
					}
					q2.clear();
				}
			}
			if(!chk) break;
			ans++;
		}
		System.out.println(ans);
		br.close();
	}
	
}
