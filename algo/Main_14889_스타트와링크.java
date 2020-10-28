import java.io.*;
import java.util.*;

public class Main_14889_스타트와링크 {
	static int n, ans;
	static int[][] map;
	static boolean[] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		arr = new boolean[n];
		ans = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 완료
		setTeam(0,0);
		System.out.println(ans);
		br.close();
	}
	static void setTeam(int cnt,int idx) {
		if(cnt == n/2) {
			int start = 0;
			int link =0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(arr[i] && arr[j]) {
						start += map[i][j];
					}
					if(!arr[i] && !arr[j]) {
						link += map[i][j];
					}
				}
			}
			ans = Math.min(ans, Math.abs(start-link));
			return;
		}
		for (int i = idx; i < n; i++) {
			if(!arr[i]) {
				arr[i] = true;
				setTeam(cnt+1, i);
				arr[i] = false;
			}
		}
	}
	static void score() {

	}
}
