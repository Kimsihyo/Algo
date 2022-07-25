package algo22;

import java.util.*;

public class Solution_최대공약수와최소공배수 {

	public static void main(String[] args) {
		solution(12, 12);
	}

	public static int[] solution(int n, int m) {
		

		int idx = 2;
		int temp = 1;
		while (true) {
			if(idx>n && idx>m) break;
			if (n % idx == 0 && m % idx == 0) {
				n /= idx;
				m /= idx;
				temp *= idx;
			}
			else{
				idx++;
			}
			//System.out.println(idx);
		}
		System.out.println(temp+"     "+n+"     "+m);
		int[] answer = {temp, temp*n*m};
		return answer;
	}
}
