package algo22;

import java.util.*;

public class Solution_핸드폰번호가리기 {

	public static void main(String[] args) {
		solution("01033334444");
	}

	public static String solution(String phone_number) {
        String answer = "";
        String[] arr = phone_number.split("");
        int len = arr.length;
        for(int i=0;i<len;i++){//876
            if(i>arr.length-5){
            	System.out.println(arr[i]);
                answer += arr[i];
            }else{
            	System.out.println("*");
                answer+="*";
            }
        }
//        System.out.print(answer);
        return answer;
	}
}
