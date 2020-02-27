package algo;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_ {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			int N = sc.nextInt();
			int T = sc.nextInt();
			int P = sc.nextInt();
			int peaple[][] = new int[N][T]; // 사람번호, 맞춘 문제
			int score[] = new int[T];//각 문제 점수
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < T; j++) {
					peaple[i][j] = sc.nextInt();
				}
				System.out.println(Arrays.toString(peaple[i]));
			}
			for (int i = 0; i < T; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if(peaple[j][i] == 1) {
						cnt++;
					}
					score[i] = N - cnt;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < T; j++) {
					
				}
			}

			
			System.out.println("#"+tc+" ");
		}
	}

}

/*
5 3 2
0 0 1  4
1 1 0  3
1 0 0  1
1 1 0  3
1 1 0  3
1번 = 1점
2번 = 2점
3번 = 4점
(자신보다 많은 점수를 획득한 참가자의 수) + (자신과 같은 점수를 획득하였지만 더 많은 문제를 푼 참가자의 수) + (자신과 같은 점수를 획득하고 같은 수의 문제를 풀었지만 번호가 더 작은 참가자의 수) + 1
기호 1번 = 0 + 0 + 0 + 1 1등 4점
기호 2번 = 1 + 0 + 0 + 1 2등 3점
기호 3번 = 4 + 0 + 0 + 1 5등 1점
기호 4번 = 1 + 0 + 0 + 1 2등 3점
기호 5번 = 1 + 0 + 0 + 1 2등 3점

*/