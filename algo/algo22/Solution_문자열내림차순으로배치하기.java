package algo22;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution_문자열내림차순으로배치하기 {
    
	public static void main(String[] args) {
		solution("Zbcdefg");
	}

	public static String solution(String s) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        	
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		// TODO Auto-generated method stub
        		return o2-o1;
        	}
        	
		});
        char[] temp = s.toCharArray();
        for(int i=0; i<temp.length; i++) {
        	pq.add(temp[i] - '0');
        }
        
        for(int i=0; i<temp.length; i++) {
        	temp[i] = (char) (pq.poll() + '0');
        }
        System.out.println(temp);
        return answer;//"gfedcbZ"
	}
}
