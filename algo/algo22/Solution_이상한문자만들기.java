package algo22;

import java.util.*;

public class Solution_이상한문자만들기 {

	public static void main(String[] args) {
		solution("try hello world");
	}

	public static String solution(String s) {
		String answer = "";
		s = s.toLowerCase();
		String[] array = s.split("");
		int idx = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(" ")) {
				answer += " ";
				idx = 0;
			} else if (idx % 2 == 0) {
				answer += array[i].toUpperCase();
				idx++;
			} else if (idx % 2 != 0) {
				answer += array[i];
				idx++;
			}
//        	System.out.println(temp[i]);
		}
		System.out.println(answer);
		return answer;
	}
}
