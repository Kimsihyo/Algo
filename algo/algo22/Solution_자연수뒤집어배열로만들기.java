package algo22;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		long n = 12345;
		solution(n);
	}

	public static int[] solution(long n) {
        String nString = String.valueOf(n);
        // System.out.println(nString);
        char[] saveNumber = new char[nString.length()];
        saveNumber = nString.toCharArray();
        int[] answer = new int[nString.length()];
        int cnt = nString.length()-1;
        for(int i=0; i<saveNumber.length; i++){
            System.out.println(saveNumber[cnt - i] - '0');
            answer[i] = saveNumber[cnt - i] - '0';
        }
        return answer;
	}
}
