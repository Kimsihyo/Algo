package 이론.dp;

import java.util.Arrays;

// B반 SW문제해결응용_JAVA 583페이지

public class LisTest2 {

	public static void main(String[] args) {
		int[] a = { 8, 2, 4, 3, 6, 11, 7, 10, 14, 5 };
		int n = a.length;

		int[] c = new int[n + 1];
		int idx = 0;
		c[idx] = a[0];
		System.out.println(Arrays.toString(c));

		for (int i = 1; i < n; i++) {
			if (c[idx] < a[i]) {
				c[++idx] = a[i];
			} else {
				int start = 0;
				int end = idx;
				while (start < end) {
					int mid = (start + end) / 2;
					if (c[mid] >= a[i])
						end = mid;
					else
						start = mid + 1;
				}
				c[end] = a[i];
			}
			System.out.println(Arrays.toString(c));
		}
		System.out.println(idx + 1);
		System.out.println(Arrays.toString(c));
	}

}
