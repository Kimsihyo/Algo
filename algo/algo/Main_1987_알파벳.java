package algo;
import java.util.*;


public class Main_1987_알파벳 {
	private static int r,c, di[] = {0,1,0,-1}, dj[]= {1,0,-1,0};
	private static char[][] map;
	private static int[][] tmap;
	private static ArrayList<Character> list;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();

		map = new char[r][c];
		tmap = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			map[i] = sc.next().toCharArray();
//			System.out.println(Arrays.toString(map[i]));
		}
		list = new ArrayList<Character>();
		list.add(map[0][0]);// 알파뱃 체크
		tmap[0][0] = 1; // 시작점
		dfs(0,0,1);
		int ans = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				ans = Integer.max(ans, tmap[i][j]);
			}
		}
		System.out.println(ans);
		sc.close();
	}// main end
	private static void dfs(int x, int y,int cnt) {

		for (int i = 0; i < 4; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			
			if(nx>=r||ny>=c||nx<0||ny<0) continue;
			if(!chk(nx,ny)) continue;
			if(tmap[nx][ny]<tmap[x][y]+1) {
				tmap[nx][ny] = tmap[x][y]+1;
			}
			list.add(map[nx][ny]);
			dfs(nx,ny,cnt+1);
			if(list.contains(map[nx][ny])) {
				list.remove(map[nx][ny]);
			}
		}
	}
	
	private static boolean chk(int x, int y) {
		if(list.contains(map[x][y])) {
			return false;
		}
		return true;
	}
}