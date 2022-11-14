import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;
        answer[0] = num;
        for(int i = 1; i < n; i++){
            // if(i==0) answer[i] = (long)x;
            answer[i] = answer[i-1] + num;
        }
        return answer;
    }
}