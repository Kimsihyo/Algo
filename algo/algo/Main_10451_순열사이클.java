package algo;

/*
 *  시간 초과  -> Bufferedreader로 해결... 어떻게 더 줄일 수 있을까?
 *  단순한 dfs 문제
 *  
 */




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_10451_순열사이클 {
	public static int V;
	public static boolean[][] chk;
	public static int[][] map;

	public static void dfs(int i, int j) {
		if (chk[i][j] == false) {
			chk[i][j] = true;

			for (int a = 1; a <= V; a++) {
				if (chk[j][a] == false && map[j][a] == 1) {
					dfs(j, a);
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
            
			map = new int[V + 1][V + 1];
			chk = new boolean[V + 1][V + 1];
			for (int i = 1; i <= V; i++) {
				String q = st.nextToken();
				int v = Integer.parseInt(q);
				map[i][v] = 1;
			}
			int cnt = 0;
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (chk[i][j] == false && map[i][j] == 1) {

						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
