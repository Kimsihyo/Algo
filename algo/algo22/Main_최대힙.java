package algo22;
import java.util.*;

public class Main_최대힙 {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			if(arr[i] != 0) pq.add(arr[i]);
			else {
				//if(pq.size() == 0) pq.add(0);
				if(pq.peek() == null) System.out.println(0);
				else {
					System.out.println(pq.poll());
				}
			}
		}
	}
}