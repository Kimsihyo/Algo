import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
//			st = new StringTokenizer(br.readLine());
			int n = sc.nextInt(); // 다이아몬드 갯수
			int k = sc.nextInt(); // 설정 크기 차이
			int[] d = new int[n];
			for (int i = 0; i < n; i++) {
				d[i] = sc.nextInt();
			}
			int ans = 0;
			int max = -1;
			for (int i = 0; i < n; i++) {
				boolean[] chk = new boolean[n];
				chk[i] = true;
				ans = 1;
				for (int j = 0; j < n; j++) {
					for (int j2 = 0; j2 < n; j2++) {
						if (i != j && Math.abs(d[j] - d[j+j2]) <= k && !chk[j]) {
							chk[j] = true;
							ans++;
						}
					}
				}
				max = Math.max(max, ans);
			}
			System.out.println("#" + tc + " " + max);
		}
//		br.close();
	}

}
