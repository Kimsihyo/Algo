package algo;

import java.util.Scanner;

public class Main_13458_시험감독 {
	static long n, b, c, ans, sum, room[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 방의 갯 수
		room = new long[(int) n];

		for (int i = 0; i < n; i++) {
			room[i] = sc.nextInt(); // 각 방에 몇 명 응시자가 있는지
		}

		b = sc.nextInt(); // 총 감독이 감시할 수 있는 인원
		c = sc.nextInt(); // 부 감독이 감시할 수 있는 인원

		ans = 0; // 각 방의 sum을 합하자

		for (int i = 0; i < n; i++) {
			sum = 0; // 각 방마다 초기화 될 것
			long x = room[i] - b;
			sum += 1;
			if (x > 0) {
				long ansx = x / c; // 
				long subx = x % c;
				if (subx > 0) {
					sum += 1;
				}
				sum += ansx;
			}
			ans += sum;
		}
		System.out.println(ans);
		sc.close();
	}

	
}
