package algo;

import java.util.Scanner;

public class Main_1476_날짜계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e, m, s;
		e = sc.nextInt();
		s = sc.nextInt();
		m = sc.nextInt();
		int cnt = 0;
		int i = 1;
		int j = 1;
		for (int k = 1;;) {// s
			cnt++;
			if (k == e && i == s && j == m) {
				System.out.println(cnt);
				break;
			}
			i++;
			j++;
			k++;
			if (k == 16) {
				k = 1;
			}
			if (j == 20) {
				j = 1;
			}
			if (i == 29) {
				i = 1;
			}

		}
	}

}
