package algo;
import java.io.*;
import java.util.*;
public class Main_1149_RGB거리{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < n; i++) {
			map[i][0] = Math.min(map[i][0] + map[i - 1][1], map[i][0] + map[i - 1][2]);
			map[i][1] = Math.min(map[i][1] + map[i - 1][0], map[i][1] + map[i - 1][2]);
			map[i][2] = Math.min(map[i][2] + map[i - 1][0], map[i][2] + map[i - 1][1]);
		}
//		Arrays.stream(map[n-1]).min().getAsInt();
		System.out.println(Math.min(Math.min(map[n-1][0], map[n-1][1]), map[n-1][2]));
		br.close();
	}
}
