package 이론.dp;

// B반 SW문제해결응용_JAVA 456페이지 연습문제1

public class DpEx1 {

	public static void main(String[] args) {
		int N = 8;
		int[] Y = new int[N + 1]; // 노란색
		int[] B = new int[N + 1]; // 파란색
		Y[1] = 1;
		B[1] = 1;
		for (int i = 2; i <= N; i++) {
			Y[i] = Y[i - 1] + B[i - 1];
			B[i] = Y[i - 1];
		}
		System.out.println(Y[8] + B[8]);
	}

}
