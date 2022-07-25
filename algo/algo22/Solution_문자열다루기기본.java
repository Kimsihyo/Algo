package algo22;

import java.util.*;

public class Solution_문자열다루기기본 {

	public static void main(String[] args) {
		solution("1234");
	}

	public static boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6) {
        	System.out.println("@@@");
        	return false;
        }
        String[] arr = s.split("");
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("0")) continue;
            else if(arr[i].equals("1")) continue;
            else if(arr[i].equals("2")) continue;
            else if(arr[i].equals("3")) continue;
            else if(arr[i].equals("4")) continue;
            else if(arr[i].equals("5")) continue;
            else if(arr[i].equals("6")) continue;
            else if(arr[i].equals("7")) continue;
            else if(arr[i].equals("8")) continue;
            else if(arr[i].equals("9")) continue;
            else{
                answer = false;
            }
        }
        System.out.println(answer);
        return answer;
	}
}
