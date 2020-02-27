package algo;
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

	static void dfs(int now_number, int cnt) {
		if(cnt > min) return;
		if(now_number == 1) {
			min = Math.min(cnt, min);
			return;
		}
		if(now_number%3 == 0) {
			dfs(now_number/3, cnt+1);
		}
		if(now_number%2 ==0) {
			dfs(now_number/2, cnt+1);
		}
			dfs(now_number-1, cnt+1);
	}
}
