package algo22;
import java.util.*;

public class Main_절대값힙 {

	public static void main(String[] args)  {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)>Math.abs(o2)) {
					return 1;
				}
				else if(Math.abs(o1)==Math.abs(o2)) {
					return o1-o2;
				}
				else {
					return -1;
				}
			}
			
		});
		
		for(int i=0; i<n; i++) {
			if(arr[i] != 0) pq.add(arr[i]);
			else {
				if(pq.peek() == null) System.out.println(0);
				else {
					int temp = pq.poll();
					System.out.println(temp);
				}
			}
		}
		
	}

}