package dp;

// B반 SW문제해결응용_JAVA 472~477페이지 동전 거스름 돈 구하기

public class CoinDP1 {
	private static int[] coin = { 1, 4, 6 };
	private static int[] dp;

	public static void main(String[] args) {
		int N = 8;
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE / 2;
			for (int j = 0; j < coin.length; j++) {
				if (i - coin[j] >= 0) {
					if (min > dp[i - coin[j]])
						min = dp[i - coin[j]];
				}
			}
			dp[i] = min + 1;
		}
		System.out.println(dp[N]);
	}

}
