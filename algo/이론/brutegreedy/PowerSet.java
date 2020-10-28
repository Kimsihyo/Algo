package 이론.brutegreedy;
import java.util.Arrays;
import java.util.Scanner;
// 중복순열 nPIr=n^r 5PI3=5*5*5=125
// 순열 nPr=n*(n-1)*...*(n-r) 5P3=5*4*3=60
// 중복조합 nHr=n+r-1Cr 5H3=5+3-1C3=7C3=7P3/3!=7*6*5/3*2*1=35
// 조합 nCr=nPr/r! 5C3=5*4*3/3*2*1=10
public class PowerSet {
	public static int n, r, cnt;
	public static int[] d = { 1, 2, 3, 4 };
	public static int[] v;
	public static void powerset(int count) {
		if (count == n) {
			cnt++;
			System.out.print(Arrays.toString(v) + " ");
			for (int i = 0; i < n; i++) {
				if (v[i] == 1)
					System.out.print(d[i] + " ");
			}
			System.out.println();
			return;
		}
		v[count] = 0;
		powerset(count + 1);
		v[count] = 1;
		powerset(count + 1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = d.length; // n=sc.nextInt();
		v = new int[n];
		powerset(0);
		System.out.println(cnt);
		sc.close();
	}
}