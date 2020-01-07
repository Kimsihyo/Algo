import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		dfs(n, 0);
		System.out.println(min);
		br.close();
	}

	static void dfs(int nn, int cnt) {
		if (cnt > min)
			return;
		if (nn == 1) {
			if (min > cnt) {
				min = cnt;
				return;
			}
		} else {
			if (nn % 3 == 0) {
				dfs(nn / 3, cnt + 1);

			}
			if (nn % 2 == 0) {
				dfs(nn / 2, cnt + 1);
			}
			dfs(nn - 1, cnt + 1);
		}
	}
}
