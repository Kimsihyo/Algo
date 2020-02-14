
import java.util.*;

public class Solution_모의SW역량테스트_등산로조성 {
	static int map[][],n,top, 
				di[] = {-1,1,0,0}, dj[] = {0,0,-1,1}, ans;//사방 탐색
	static ArrayList<int[]> top_list, top_list2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			int k = sc.nextInt();
			map = new int[n][n];
			top_list = new ArrayList<int[]>();
			top_list2 = new ArrayList<int[]>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();

				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					//가장 높은 봉우리 찾기
					if(map[i][j] > top) {
						top = map[i][j];
					}
				}
			}
			//가장 높은 봉우리 저장하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] == top) {
						top_list2.add(new int[] {i,j,1});
					}
				}
			}
			
			ans = Integer.MIN_VALUE;
			//1. k만큼 봉우리 높이 낮추기
			for(int i = 0; i < n; i++) {
				for(int j=0; j<n; j++) {
					for (int depth = 1; depth <= k; depth++) {
						//depth만큼 공사 해보고
						map[i][j] -= depth;
						//탐색 하고
						top = -1;// 최대 높이 봉우리 초기화
						top_list.addAll(top_list2); // top_list 초기화
						//등산로 길이 찾기
						find_load();
						//원상 복구
						map[i][j] += depth;
						
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
			
		}//tc end
	}//main end
	//2. 가장 높은 봉우리에서 탐색
	static void find_load() {
		while(!top_list.isEmpty()) {
			int temp[] = top_list.remove(0);
			int x = temp[0];
			int y = temp[1];
			int cnt = temp[2];
			for (int i = 0; i < 4; i++) {
				int nx = x + di[i];
				int ny = y + dj[i];
				if(nx>=0&& ny>=0 && nx<n&& ny<n
						&& map[x][y] > map[nx][ny] 
								) {
					cnt++;
					top_list.add(new int[] {nx,ny,cnt});
					cnt--;

				}
			}
			ans = Math.max(cnt, ans);
		}
		
	}//find_load end
	
	
	
}
