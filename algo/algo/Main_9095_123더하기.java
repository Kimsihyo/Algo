package algo;
import java.util.Scanner;

public class Main_9095_123더하기 {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			cnt = 0;
			dfs(n, 0);
			System.out.println(cnt);
		}
	}
	static void dfs(int nn, int sum) {
		if(nn < sum) return;
		if(nn == sum) {
			cnt++;
			return;
		}
		dfs(nn, sum+1);
		dfs(nn, sum+2);
		dfs(nn, sum+3);
	}
}
