package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
B반 SW문제해결응용_JAVA 487~506페이지 생일 선물
4
10
5 10
4 40
6 30
3 50
 */

public class KnapsackTest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int W = Integer.parseInt(br.readLine());
		int[] w = new int[N];
		int[] v = new int[N];
		int[][] k = new int[N + 1][W + 1];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				if (w[i - 1] > j)
					k[i][j] = k[i - 1][j];
				else
					k[i][j]=Math.max(k[i-1][j-w[i-1]]+v[i-1], k[i-1][j]);
			}
		}
		
		System.out.println(k[N][W]);
		for(int[] a:k)
			System.out.println(Arrays.toString(a));
		br.close();
	}

}
