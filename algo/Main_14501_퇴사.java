import java.util.Scanner;

public class Main_14501_퇴사 {
	static int n, t[],p[],pay,max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = new int[n];
		p = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		pay = 0;
		max = Integer.MIN_VALUE;
		work(0,0,0);
	}
	static void work(int now, int s, int next) {
		if(next == n) {
			max = Math.max(max, s);
			return;
		}else if() {
			
		}
		
		else {
			
				work(now+t[now],pay+p[now],next+1);
				work(next,p[now],next+1);
		
		}
	}
}
