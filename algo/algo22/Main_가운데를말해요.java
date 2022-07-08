package algo22;
import java.util.*;

public class Main_가운데를말해요 {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] call_number = new int[n];
		for(int i=0; i<n; i++) {
			call_number[i] = sc.nextInt();
		}
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			 
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
			
		});
		for(int i=0; i<n; i++) {
			q.add(call_number[i]);
		}
		for(int i=0; i<n; i++) {
			System.out.println(q.poll());
		}


	}

}