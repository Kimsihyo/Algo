package algo22;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_큰수만들기 {
    
	public static void main(String[] args) {
		solution("1231234", 3);
	}

	public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k;
        int start = 0;
        
        while(start < number.length() && answer.length() != len) {
        	int leftNum = k + answer.length() + 1;
        	int max = 0;
        	for(int j = start; j < leftNum; j++) {
        		if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
        	}
        	answer.append(Integer.toString(max));
        }
        return answer.toString();
	}
}
