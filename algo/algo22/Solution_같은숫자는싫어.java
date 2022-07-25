package algo22;

import java.util.*;

public class Solution_같은숫자는싫어 {

	public static void main(String[] args) {
		int[] temp = {1,1,3,3,0,1,1};
		solution(temp);
	}

	public static int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]) list.add(arr[i]);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        list.
        return null;
	}
}
