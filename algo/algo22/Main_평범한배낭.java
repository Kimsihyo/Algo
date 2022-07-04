package algo22;

import java.util.Scanner;

public class Main_평범한배낭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] obj = new int[N+1][2];

		for (int i = 1; i <= N; i++) {
			obj[i][0] = sc.nextInt();
			obj[i][1] = sc.nextInt();
		}

		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - obj[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - obj[i][0]] + obj[i][1]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
//public class Main_평범한배낭 {
//	static int N, max, K, obj[][];
//	public static void main(String[] args) {
//		//최대 가치를 구해라
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt(); // 물건개수
//		K = sc.nextInt(); // 최대 버틸 수 있는 무게
//		max = 0;
//		obj = new int[N][2];
//		for(int i=0; i<N; i++) {
//			obj[i][0] = sc.nextInt(); // W 무게
//			obj[i][1] = sc.nextInt(); // V 가치
//		}
//		
//		conform(0, 0, 0);
//		System.out.println(max);
//		
//	}
//	
//	static void conform(int now_weight, int now_value, int idx) {
//		if(now_weight <= K && now_value > max) {
//			max = now_value;
//			return;
//		}
//		for(int i=idx; i<N; i++) {
//			conform(now_weight + obj[i][0], now_value + obj[i][1] ,i+1);
//		}
//	}
//
//}
