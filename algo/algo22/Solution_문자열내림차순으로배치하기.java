package algo22;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution_문자열내림차순으로배치하기 {
    
	public static void main(String[] args) {
		solution(118372);
	}

	 public static long solution(long n) {
	        long answer = 0;
	        String string_N = String.valueOf(n);
	        char[] temp = string_N.toCharArray();
	        PriorityQueue<Integer> saveNumber 
	            = new PriorityQueue<>(new Comparator<Integer>(){
	                
	                @Override
	                public int compare(Integer o1, Integer o2){
	                    return o2 - o1;
	                }
	        });
	        for(int i=0; i<temp.length; i++){
	            saveNumber.add(temp[i] - '0');
	        }
	        String tempAnswer = "";
	        for(int i=0; i<temp.length; i++){
	            int tempI = saveNumber.poll();
	            String tempS = String.valueOf(tempI);
	            tempAnswer += tempS;
	        }
	        answer = Long.valueOf(tempAnswer);
	        return answer;
	}
}
