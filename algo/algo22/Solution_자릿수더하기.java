package algo22;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_자릿수더하기 {

	public static void main(String[] args) {
		int n = 123;
		solution(n);
	}

	public static int solution(int n) {
		int answer = 0;
		String stringNum = String.valueOf(n);
		char[] number = stringNum.toCharArray();
		for(int i=0; i<number.length; i++) {
//			System.out.println(number[i]);
			answer += (number[i] - '0');
		}
//		System.out.println(answer);
        return answer;
	}
}
