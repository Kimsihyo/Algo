package algo;

import java.util.Scanner;

public class Main_1592_영식이와친구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt(); // 방학 일 수
		int a = sc.nextInt(); // 국어
		int b = sc.nextInt(); // 총 수학
		int c = sc.nextInt(); // 하루 국어
		int d = sc.nextInt(); // 하루 수학

		int ko = a / c; // 국어 몇 일?
		if (a % c != 0) {
			ko = ko + 1;
		}
		int ma = b / d; // 수학 몇 일?
		if (b % d != 0) {
			ma = ma + 1;
		}

		int ans = ko;
		if (ko < ma) {
			ans = ma;
		}
		if(l >= ans) {
			System.out.println(l-ans);
		}


	}

}