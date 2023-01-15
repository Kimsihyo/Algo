import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0);
        return this.answer;
    }
    public void dfs(int[] numbers, int target, int idx, int sum){
        if(numbers.length == idx){
            if(target == sum) this.answer++;
            return;
        }
        dfs(numbers, target, idx+1, sum + numbers[idx]);
        dfs(numbers, target, idx+1, sum - numbers[idx]);
    }
}