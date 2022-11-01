class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int a, b;
        a = common[1] - common[0];
        b = common[2] - common[1];
        if(a == b) answer = common[common.length-1] + a; 
        else{
            a = common[1]/common[0];
            answer = common[common.length-1] * a;
        }
        
        
        return answer;
    }
}