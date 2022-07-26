package algo22;

import java.util.*;

public class Solution_K번째수 {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		solution(array,commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
  		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1 - o2;
				}
			});
			for (int j = 0; j < 3; j++) {
				for (int k = commands[i][0]-1; k < commands[i][1]; k++) {
					q.add(array[k]);
				}
				int size = q.size();
				for(int k=0; k<size; k++) {
					if(k==commands[i][2]-1) {
						answer[i] = q.poll();
					}
					else {
						q.poll();
					}
				}
			}
		}
		return answer;
	}
}
