package dp;

// B반 SW문제해결응용_JAVA 472~477페이지 동전 거스름 돈 구하기

public class CoinDP2 {
	private static int[] coin = { 1, 4, 6 };
	private static int[][] dp;

	public static void main(String[] args) {
		int N = 8;
		dp = new int[coin.length][N + 1];
		for (int i = 0; i < coin.length; i++) {
			for (int j = 1; j <= N; j++) {
				if (i < 1)
					dp[i][j] = dp[i][j - coin[i]] + 1;
				else if (j - coin[i] < 0)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.min(dp[i][j - coin[i]] + 1, dp[i - 1][j]);
			}
		}
		System.out.println(dp[coin.length - 1][N]);
	}

}
