package algo;

import java.util.Scanner;

public class Main_9095_123더하기_재귀 {
	public static int count(int sum, int goal) {

		if (sum > goal) {
			return 0;
		}
		if (sum == goal) {
			return 1;
		}
		int now = 0;
		for (int i = 1; i <= 3; i++) {

			now += count(sum + i, goal);
		}
		return now;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케

		for (int tc = 0; tc < T; tc++) {
			int goal = sc.nextInt();

			System.out.println(count(0, goal));
		}
	}

}
