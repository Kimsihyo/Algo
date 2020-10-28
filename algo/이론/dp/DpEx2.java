package 이론.dp;

// B반 SW문제해결응용_JAVA 471페이지 연습문제2

public class DpEx2 {

	public static void main(String[] args) {
		int N = 6;
		int[] f = new int[N + 1];
		f[0] = 1; // 0cm는 막대가 없는 1가지 방법
		f[1] = 2;
		for (int i = 2; i <= N; i++) {
			f[i] = 2 * f[i - 1] + f[i - 2];
			// i-1은 파란색과 노란색 막대의 경우 2가지임으로 *2
			// i-2는 빨간색 막대의 경우
		}
		System.out.println(f[6]);
	}

}
