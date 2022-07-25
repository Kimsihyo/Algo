package algo22;

import java.util.*;

public class Solution_큰수만들기 {
    
	public static void main(String[] args) {
		solution(4);
	}

	public static long solution(long n) {
        long answer = 0;
        for(long i=1; i<=n; i++) {
        	if(i*i == n) {
        		answer=i;
        		break;
        	}
        }
        if(answer == 0) answer = -1;
        else {
        	answer += 1;
        	answer *= answer;
        }
        System.out.println(answer);
        return answer;
	}
}
