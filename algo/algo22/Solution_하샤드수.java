package algo22;

import java.util.*;

public class Solution_하샤드수 {

	public static void main(String[] args) {
		solution(10);
	}

	public static boolean solution(int x) {
        String s = String.valueOf(x);
        String[] arr = s.split("");
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
        	sum += Integer.valueOf(arr[i]);
        }
        if(x%sum==0)return true;
        return false;
	}
}
