package algo22;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		long n = 12345;
		solution(n);
	}

	public static int[] solution(long n) {
//		int[] answer = {};
        String nString = n+"";
        System.out.println(nString);
        char[] answer = new char[nString.length()];
        answer = nString.toCharArray();
        System.out.println(answer);
        PriorityQueue<Character> q = new PriorityQueue<Character>(new Comparator<Character>() {
		
        	@Override
        	public int compare(Character o1, Character o2) {
        		// TODO Auto-generated method stub
        		return o2 - o1;
        	}
        	
        });
        for(int i=0; i<answer.length; i++) {
        	q.add(answer[i]);
        }
        
        System.out.println(q);
        
        
        
        
		return null;
	}
}
