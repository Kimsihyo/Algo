
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 연습장 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nn = 1000-n;
		int[] money = { 500, 100, 50, 10, 5, 1 };
		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < 6; i++) {
			cnt = 0;
			if(nn == 0) break;
			for (int j = 0;; j++) {
				if(nn < money[i]*j) {
					break;
				}
				cnt = j;
			}
			ans = ans + cnt;
			nn = nn - (money[i]*(cnt));
		}
		System.out.println(ans);

	}

}
