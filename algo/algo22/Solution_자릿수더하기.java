package algo22;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_자릿수더하기 {

	public static void main(String[] args) {
		int[] n = {4,3,2,1};
		solution(n);
	}

	public static int[] solution(int[] arr) {
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[arr.length-1];
        int min = 999999999;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
            //System.out.println(min);
        }
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(min != arr[i]){
                answer[idx] = arr[i];
                idx++;
            }
        }
        return answer;
	}
}
